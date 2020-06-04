package com.sunking.lapo.commons.db

import android.app.Application
import androidx.room.Room
import com.example.daggerframework.di.AppModule
import dagger.Module
import dagger.Provides


@Module(includes = [AppModule::class])
class AppdbModule {

    @Provides
    fun provideDatabase(app: Application): AppDatabase =
        Room.databaseBuilder(app, AppDatabase::class.java, "app.db").allowMainThreadQueries().build();




}