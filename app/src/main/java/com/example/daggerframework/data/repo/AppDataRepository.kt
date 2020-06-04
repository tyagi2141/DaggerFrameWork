package com.sunking.lapo.common.data


import android.app.Application
import com.example.daggerframework.data.network.Routes
import com.sunking.lapo.commons.db.AppDatabase
import com.sunking.lapo.commons.preferences.AppSharedPreferences


class AppDataRepository(
    private var app: Application,
    private var appSharedPreferences: AppSharedPreferences,
    private var apiService: Routes,
    private var localDatabase: AppDatabase
) : DataRepository {



}