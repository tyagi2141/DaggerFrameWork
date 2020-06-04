package com.example.daggerframework.ui

import android.app.Application
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.sunking.lapo.common.data.DataRepository
import javax.inject.Inject
import javax.inject.Named

/**
 * Created by Rahul on 04/06/20.
 */




class MainViewmodel @Inject constructor(
    private var dataRepository: DataRepository,
    private var app: Application, @Named("app") private var gson: Gson
) :
    ViewModel() {

}
