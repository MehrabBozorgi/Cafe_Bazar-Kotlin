package com.example.bazarupdate.Room

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class RoomViewModel(application: Application) : AndroidViewModel(application) {
    var repository: RoomRepository

    init {
        var courseDao = AppDataBase.getDataBase(application).courseDao()
        repository = RoomRepository(courseDao)
    }

    fun insert(rCourse: RCourse) {
        repository.insert(rCourse)
    }

    fun getAllCourse(): LiveData<List<RCourse>> {
        return repository.getAllCourse()
    }

    fun getSignCourse(name: String): LiveData<RCourse> {
        return repository.getSignCourse(name)
    }


    fun deleteCourse(course: RCourse){
        return repository.deleteCourse(course)
    }


}