package com.example.bazarupdate.Model.App_Game

import android.os.Parcel
import android.os.Parcelable

class GetGoli(
    var id: String,
    var name: String,
    var description: String,
    var size: String,
    var icon: String,
    var cat: String,
    var cat_id: String,
    var big_img: String,
    var developer_name: String,
    var kind: String,
    var download: String,
    var version: String,
    var developer_phone: String,
    var developer_email: String,
    var developer_web: String,
    var apk: String,
    var application_id: String,
    var img_url: String,
    var img_slide: String,
    var slide: List<String>,
    var comment: List<GetComment>
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.createStringArrayList()!!,
        TODO("comment")
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(name)
        parcel.writeString(description)
        parcel.writeString(size)
        parcel.writeString(icon)
        parcel.writeString(cat)
        parcel.writeString(cat_id)
        parcel.writeString(big_img)
        parcel.writeString(developer_name)
        parcel.writeString(kind)
        parcel.writeString(download)
        parcel.writeString(version)
        parcel.writeString(developer_phone)
        parcel.writeString(developer_email)
        parcel.writeString(developer_web)
        parcel.writeString(apk)
        parcel.writeString(application_id)
        parcel.writeString(img_url)
        parcel.writeString(img_slide)
        parcel.writeStringList(slide)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<GetGoli> {
        override fun createFromParcel(parcel: Parcel): GetGoli {
            return GetGoli(parcel)
        }

        override fun newArray(size: Int): Array<GetGoli?> {
            return arrayOfNulls(size)
        }
    }
}