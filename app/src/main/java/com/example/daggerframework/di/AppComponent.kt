package com.example.daggerframework.di

import android.app.Application
import com.example.daggerframework.AppApplication
import com.example.daggerframework.data.network.NetworkModule
import com.sunking.lapo.common.data.DataModule
import com.sunking.lapo.commons.db.AppdbModule
import com.sunking.lapo.commons.preferences.PreferencesModule
import com.sunking.lapo.di.ViewModelFactoryModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

/**
 * Created by Rahul on 04/06/20.
 */
@Component(modules = [
    AndroidInjectionModule::class,
            AppModule::class,
    PreferencesModule::class,
    NetworkModule::class,
    AppdbModule::class,
    DataModule::class,
    ViewModelFactoryModule::class,
    ActivityBindingModule::class,
    AndroidSupportInjectionModule::class

])
interface AppComponent:AndroidInjector<AppApplication> {

/*
    @Component.Builder
    interface Builder{

        @BindsInstance
        fun application(application: Application?):Builder?
        fun builder(): AppComponent?
    }*/


    @Component.Factory
    interface Factory {
        fun create(appModule: AppModule): AppComponent
    }
}