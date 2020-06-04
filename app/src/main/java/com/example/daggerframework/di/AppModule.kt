package com.example.daggerframework.di

import android.app.Application
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Inject
import javax.inject.Named

/**
 * Created by Rahul on 04/06/20.
 */
@Module
class AppModule @Inject constructor(var application: Application) {

    @Provides
    fun provideApp(): Application = application


    @Provides
    fun provideExecutor(): Executor = Executors.newFixedThreadPool(2)!!


    @Provides
    @Named("app")
    fun provideGson() = Gson()
}
