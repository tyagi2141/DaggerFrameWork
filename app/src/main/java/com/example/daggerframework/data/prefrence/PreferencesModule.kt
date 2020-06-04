package com.sunking.lapo.commons.preferences


import android.app.Application
import com.example.daggerframework.di.AppModule
import com.example.daggerframework.di.scope.AppScope
import com.google.gson.Gson

import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module(includes = [AppModule::class])
class PreferencesModule {

    @AppScope
    @Provides
    fun provideAppPreferences(app: Application, @Named("prefs") gson: Gson): AppSharedPreferences =
        AppPreferences(app, gson)



    @Provides
    @Named("prefs")
    fun provideGson() = Gson()
}