package com.example.bazarupdate.Room

import androidx.lifecycle.LiveData

class RoomRepository(var courseDao: CourseDao) {

    fun insert(course: RCourse) {
        courseDao.insert(course)
    }

    fun getAllCourse(): LiveData<List<RCourse>> {
        return courseDao.getAllCourse()
    }

    fun getSignCourse(name:String):LiveData<RCourse>{
        return courseDao.getSignCourse(name)
    }

    fun deleteCourse(course: RCourse){
        return courseDao.deleteCourse(course)
    }

}
