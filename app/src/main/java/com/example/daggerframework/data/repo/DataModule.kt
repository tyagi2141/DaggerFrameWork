package com.sunking.lapo.common.data

import android.app.Application
import com.example.daggerframework.data.network.NetworkModule
import com.example.daggerframework.data.network.Routes
import com.example.daggerframework.di.AppModule
import com.example.daggerframework.di.scope.AppScope
import com.sunking.lapo.commons.db.AppDatabase
import com.sunking.lapo.commons.db.AppdbModule
import com.sunking.lapo.commons.preferences.AppSharedPreferences
import com.sunking.lapo.commons.preferences.PreferencesModule
import dagger.Module
import dagger.Provides

@Module(includes = [AppModule::class, NetworkModule::class, AppdbModule::class, PreferencesModule::class])
class DataModule {

    @AppScope
    @Provides
    fun provideAppDataRepository(
        app: Application,
        appSharedPreferences: AppSharedPreferences,
        apiService: Routes,
        localDatabase: AppDatabase
    ): DataRepository = AppDataRepository(app, appSharedPreferences, apiService, localDatabase)

}