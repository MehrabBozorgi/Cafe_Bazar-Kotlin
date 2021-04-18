package com.example.bazarupdate.Model.Movie

import android.os.Parcel
import android.os.Parcelable
import com.example.bazarupdate.Model.App_Game.CommentMovie

class Movie(
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
    var kodom_site	: String,
    var time: String,
    var tools: String,
    var sale_sakh: String,
    var country: String,
    var keyfiat: String,
    var fasl_id: String,
    var movie_id: String,
    var comment_name: String,
    var date: String,
    var size: String,
    var comment:List<CommentMovie>,
    var faslha:List<Fasl>
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
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        TODO("comment"),
        TODO("faslha")
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(icon)
        parcel.writeString(name)
        parcel.writeString(cat)
        parcel.writeString(cat_id)
        parcel.writeString(age)
        parcel.writeString(size)
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
        parcel.writeString(movie_id)
        parcel.writeString(comment_name)
        parcel.writeString(date)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Movie> {
        override fun createFromParcel(parcel: Parcel): Movie {
            return Movie(parcel)
        }

        override fun newArray(size: Int): Array<Movie?> {
            return arrayOfNulls(size)
        }
    }
}