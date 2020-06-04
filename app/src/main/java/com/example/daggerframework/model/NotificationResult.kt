package com.sunking.lapo.LocalData.model


import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by Rahul on 31/03/20.
 */

@Parcelize
@Entity(tableName = "notification")
public data class NotificationResult(


    @ColumnInfo(name = "data")
    @SerializedName("data")
    var data: Data,

    @PrimaryKey
    @ColumnInfo
    @SerializedName("dates")
    var dates: String,

    @ColumnInfo
    @SerializedName("ischecked")
    var isClicked: Boolean = false,

    @ColumnInfo
    @SerializedName("flag")
    var flag: Boolean = false

) : Parcelable