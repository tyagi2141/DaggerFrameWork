package com.sunking.lapo.commons.db

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.sunking.lapo.LocalData.model.NotificationResult
import com.sunking.lapo.notification.LocalData.Dao.NotifyDataConverter


@Database(
    entities = [
        NotificationResult::class
    ],
    version = 1
)
@TypeConverters(
    NotifyDataConverter::class

    )

abstract class AppDatabase() : RoomDatabase(), Parcelable {
    constructor(parcel: Parcel) : this() {
    }

//Dao class here



    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }


}