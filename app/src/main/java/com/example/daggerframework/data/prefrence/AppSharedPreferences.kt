package com.sunking.lapo.commons.preferences

import androidx.lifecycle.MutableLiveData


interface AppSharedPreferences {


    fun setCurruntDate(deviceid: String)
    fun getCurruntDate(): String

    val observableSavedUser: MutableLiveData<String>

    fun getUser(): String?
    //

    //
    fun setUser(User: String)

    fun clearSharePreference()

    companion object {
        val NONE_USER = null
    }


}
