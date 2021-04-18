package com.example.bazarupdate.Room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class RCourse(
    @PrimaryKey(autoGenerate = false) var id: Int,
    @ColumnInfo var icon: String,
    @ColumnInfo var name: String,
    @ColumnInfo var size: String,

)