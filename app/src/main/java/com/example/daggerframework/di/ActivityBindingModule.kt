package com.example.daggerframework.di

import com.example.daggerframework.ui.MainViewModelModule
import com.readystatesoftware.chuck.internal.ui.MainActivity

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector(
        modules = [
            MainViewModelModule::class
        ]
    )

    abstract fun contributeMainActivity(): MainActivity


}
