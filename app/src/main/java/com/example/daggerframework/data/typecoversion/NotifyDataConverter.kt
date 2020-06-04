package com.sunking.lapo.notification.LocalData.Dao

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.sunking.lapo.LocalData.model.Data


public class NotifyDataConverter {

    var gson = Gson()

    @TypeConverter
    fun fromNotifyDataConverter(data: String?): Data? {
        return gson.fromJson<Data>(data, Data::class.java)
    }

    @TypeConverter
    fun toNotifyDataConverter(data: Data): String? =
        gson.toJson(data)

}