package com.example.daggerframework.data.network

import android.app.Application
import com.example.daggerframework.common.Constants
import com.example.daggerframework.di.AppModule
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.readystatesoftware.chuck.ChuckInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Named

/**
 * Created by Rahul on 04/06/20.
 */
@Module(includes = [AppModule::class])
class NetworkModule {
    @Provides
    fun provideGson(): Gson = GsonBuilder()
        .setLenient()
        .create()

    @Provides
    fun provideCache(cacheFile: File): Cache = Cache(cacheFile, Constants.OKHTTP_CACHE_DIR_SIZE)

    @Provides
    fun provideHttpCacheFile(app: Application): File {
        val directory =
            File(app.cacheDir.toString() + File.separator + Constants.OKHTTP_CACHE_DIR_NAME)
        if (!directory.exists())
            directory.mkdirs()
        return directory

    }


    @Provides
    fun provideOkHttpClient(
        cache: Cache,
//        @Named("AuthInterceptor") authInterceptor: Interceptor,
//        @Named("ChuckInterceptor") chuckInterceptor: Interceptor,
        @Named("HttpLoggingInterceptor") loggingInterceptor: Interceptor,
        @Named("StethoInterceptor") stethoInterceptor: Interceptor
//        @Named("NetLoggingInterceptor") netLoggingInterceptor: Interceptor
    ): OkHttpClient =
        OkHttpClient.Builder()
//            .addInterceptor(chuckInterceptor)
            .addInterceptor(loggingInterceptor)
            .addNetworkInterceptor(stethoInterceptor)
//            .addInterceptor(netLoggingInterceptor)
//            .addInterceptor(authInterceptor)
            .cache(cache)
            .readTimeout(20, TimeUnit.SECONDS)
            .connectTimeout(20, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .build()


    @Provides
    @Named("OkHttpHelper")
    fun okHttpHelperClient(
        gson: Gson
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl(Constants.API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

    @Provides
    @Named("ChuckInterceptor")
    fun provideChuckInterceptor(app: Application): Interceptor =
        ChuckInterceptor(app.applicationContext)

    @Provides
    @Named("StethoInterceptor")
    fun provideStethoInterceptor(): Interceptor =
        StethoInterceptor()

//    @Provides
//    @Named("NetLoggingInterceptor")
//    fun provideNetLoggingInterceptor(): Interceptor =
//        NetLoggingInterceptor()

    @Provides
    @Named("HttpLoggingInterceptor")
    fun provideHttpLoggingInterceptor(app: Application): Interceptor {
        val loggingInterceptor = HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
            override fun log(message: String) {
                Timber.tag("OkHttp").d(message)
//                AndroidRemoteDebugger.Log.d("OkHttp", message)
            }
        })

        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        loggingInterceptor.redactHeader("Authorization")
        //loggingInterceptor.redactHeader("Cookie");
        return loggingInterceptor
    }

    @Provides
    fun RxJava2CallAdapterFactory() = RxJava2CallAdapterFactory.create()

    @Provides
    @Named("RealRetrofit")
    fun getClient(
        @Named("OkHttpHelper") retrofit: Retrofit,
        okHttpClient: OkHttpClient,
        rxJava2CallAdapterFactory: RxJava2CallAdapterFactory
    ): Retrofit =
        retrofit.newBuilder()
            .client(okHttpClient)
            .addCallAdapterFactory(rxJava2CallAdapterFactory)
            .build()


    @Provides
    fun provideApiService(@Named("RealRetrofit") retrofit: Retrofit): Routes =
        retrofit.create(Routes::class.java)

}