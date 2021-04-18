package com.example.bazarupdate.Model.App_Game

import android.os.Parcel
import android.os.Parcelable
import java.util.ArrayList

class CatGame(
    var id: String?,
    var cat_icon: String?,
    var cat_name: String?,
    var name: String?,
    var description: String?,
    var size: String?,
    var icon: String?,
    var cat_id: String?,
    var big_img: String?,
    var developer_name: String?,
    var kind: String?,
    var download: String?,
    var version: String?,
    var application_id: String?,
    var developer_phone: String?,
    var developer_email: String?,
    var developer_web: String?,
    var apk: String?,
    var img_slide: String?,
    var slide: ArrayList<String>
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        TODO("slide")
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(cat_icon)
        parcel.writeString(cat_name)
        parcel.writeString(name)
        parcel.writeString(description)
        parcel.writeString(size)
        parcel.writeString(icon)
        parcel.writeString(cat_id)
        parcel.writeString(big_img)
        parcel.writeString(developer_name)
        parcel.writeString(kind)
        parcel.writeString(download)
        parcel.writeString(version)
        parcel.writeString(application_id)
        parcel.writeString(developer_phone)
        parcel.writeString(developer_email)
        parcel.writeString(developer_web)
        parcel.writeString(apk)
        parcel.writeString(img_slide)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CatGame> {
        override fun createFromParcel(parcel: Parcel): CatGame {
            return CatGame(parcel)
        }

        override fun newArray(size: Int): Array<CatGame?> {
            return arrayOfNulls(size)
        }
    }
}