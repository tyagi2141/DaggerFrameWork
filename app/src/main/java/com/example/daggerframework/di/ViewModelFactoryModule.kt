package com.sunking.lapo.di

import androidx.lifecycle.ViewModelProvider
import com.example.daggerframework.viewHolder.ViewModelProviderFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelProviderFactory): ViewModelProvider.Factory

}
