package com.example.daggerframework

import android.app.Activity
import com.example.daggerframework.di.AppComponent
import com.example.daggerframework.di.AppModule
import com.example.daggerframework.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.DispatchingAndroidInjector
import javax.inject.Inject

/**
 * Created by Rahul on 04/06/20.
 */
class AppApplication :DaggerApplication() {

    private lateinit var component: AppComponent

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return component
    }

    override fun onCreate() {
        component = DaggerAppComponent.factory().create(AppModule(this))
        component.inject(this)
        super.onCreate()



    }
}