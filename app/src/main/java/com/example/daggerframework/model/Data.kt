package com.sunking.lapo.LocalData.model


import android.os.Parcelable
import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by Rahul on 31/03/20.
 */
@Parcelize
 data class Data(

    @ColumnInfo
    @SerializedName("title") var title: String?,

    @ColumnInfo
    @SerializedName("body") var body: String?,

    @ColumnInfo
    @SerializedName("Ids") var ids: String?
) : Parcelable