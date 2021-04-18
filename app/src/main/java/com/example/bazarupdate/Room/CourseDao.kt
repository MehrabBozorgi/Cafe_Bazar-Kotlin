package com.example.bazarupdate.Room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CourseDao {
    @Insert
    fun insert(course: RCourse)

    @Query("SELECT * FROM rcourse")
    fun getAllCourse(): LiveData<List<RCourse>>

    @Query("SELECT * FROM RCourse WHERE name in (:name)")
    fun getSignCourse(name: String): LiveData<RCourse>

    @Delete
    fun deleteCourse(course: RCourse)

}










