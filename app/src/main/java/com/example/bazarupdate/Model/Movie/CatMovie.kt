package com.example.bazarupdate.Model.Movie

import android.os.Parcel
import android.os.Parcelable

class CatMovie(
    var id: String,
    var icon: String,
    var name: String,
    var cat: String,
    var cat_id: String,
    var age: String,
    var zaban: String,
    var zir_nevis: String,
    var description: String,
    var point: String,
    var kodom_site: String,
    var time: String,
    var tools: String,
    var sale_sakh: String,
    var country: String,
    var keyfiat: String,
    var fasl_id: String,
    var cat_icon: String,
    var cat_name: String,
):Parcelable {
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
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(icon)
        parcel.writeString(name)
        parcel.writeString(cat)
        parcel.writeString(cat_id)
        parcel.writeString(age)
        parcel.writeString(zaban)
        parcel.writeString(zir_nevis)
        parcel.writeString(description)
        parcel.writeString(point)
        parcel.writeString(kodom_site)
        parcel.writeString(time)
        parcel.writeString(tools)
        parcel.writeString(sale_sakh)
        parcel.writeString(country)
        parcel.writeString(keyfiat)
        parcel.writeString(fasl_id)
        parcel.writeString(cat_icon)
        parcel.writeString(cat_name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CatMovie> {
        override fun createFromParcel(parcel: Parcel): CatMovie {
            return CatMovie(parcel)
        }

        override fun newArray(size: Int): Array<CatMovie?> {
            return arrayOfNulls(size)
        }
    }
}