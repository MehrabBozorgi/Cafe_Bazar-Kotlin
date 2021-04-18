package com.example.bazarupdate.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [RCourse::class], version = 1)
abstract class AppDataBase() : RoomDatabase() {
    abstract fun courseDao(): CourseDao

    companion object {
        private var instance: AppDataBase? = null
        fun getDataBase(context: Context): AppDataBase {
            if (instance != null) {
                return instance!!
            } else {
                instance = Room.databaseBuilder(
                    context,
                    AppDataBase::class.java, "update_cafe_bazar"
                ).allowMainThreadQueries().build()

                return instance!!
            }

        }

    }


}