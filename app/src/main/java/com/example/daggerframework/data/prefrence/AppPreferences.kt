package com.sunking.lapo.commons.preferences

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import androidx.lifecycle.MutableLiveData
import androidx.core.content.edit
import com.example.daggerframework.common.Constants
import com.google.gson.Gson


class AppPreferences(var app: Application, var gson: Gson) :
    AppSharedPreferences {

    var settings: SharedPreferences? = null
    var editor: SharedPreferences.Editor? = null
    val PREFS_NAME: String = "GreenLightPlanet"

    private val prefs: Lazy<SharedPreferences> = lazy {
        app.getSharedPreferences(
            Constants.APP_PREFERENCES_FILE_NAME, Context.MODE_PRIVATE
        ).apply {
            registerOnSharedPreferenceChangeListener(changeListener)
        }

    }

    companion object {
        const val KEY_USER: String = "user"
    }




    private val observableUser = MutableLiveData<String>()

    override val observableSavedUser: MutableLiveData<String>
        get() {
            observableUser.value = getUser()
            return observableUser
        }

    override fun getUser(): String? {
        return ""
    }

    override fun setUser(User: String) {

    }


    private val changeListener = SharedPreferences.OnSharedPreferenceChangeListener { _, key ->
        when (key) {
            KEY_USER -> observableUser.value = getUser()
        }
    }




    override fun setCurruntDate(date: String) {
        prefs.value.edit { putString("date", date) }
    }

    override fun getCurruntDate(): String {
        return prefs.value.getString("date", null) ?: return ""
    }

    override fun clearSharePreference() {
        prefs.value.edit().clear().commit()
    }

}
