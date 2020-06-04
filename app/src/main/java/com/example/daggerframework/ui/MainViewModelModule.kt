package com.example.daggerframework.ui

import androidx.lifecycle.ViewModel
import com.sunking.lapo.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by Rahul on 04/06/20.
 */
@Module
abstract class MainViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainViewmodel::class)
    abstract fun bindMainActivityViewModel(viewModel: MainViewmodel): ViewModel
}