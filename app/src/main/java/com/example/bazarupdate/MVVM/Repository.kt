package com.example.bazarupdate.MVVM

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.bazarupdate.Model.App_Game.*
import com.example.bazarupdate.Model.Movie.CatMovie
import com.example.bazarupdate.Model.Movie.Movie
import com.example.bazarupdate.Model.Profile.MyMessage

class Repository(var context: Application) {
    var apiService = ApiService(context)

    ///////////////////
    ///////////////////
    ///////////////////
    //Game
    fun getGoli(): LiveData<List<GetGoli>> {
        return apiService.getGoli()
    }

    fun moreGame(): LiveData<List<MoreGame>> {
        return apiService.moreGame()
    }

    fun newGame(): LiveData<List<MoreGame>> {
        return apiService.newGame()
    }

    fun moreGameForYou(): LiveData<List<MoreGame>> {
        return apiService.moreGameForYou()
    }

    fun bestNew(): LiveData<List<MoreGame>> {
        return apiService.bestNew()
    }

    fun updateGame(): LiveData<List<MoreGame>> {
        return apiService.updateGame()
    }

    fun catGame(): LiveData<List<CatGame>> {
        return apiService.catGame()
    }

    fun AllMore(id: String): LiveData<MoreGame> {
        return apiService.AllMore(id)
    }

    fun getComment(id: String): LiveData<MoreGame> {
        return apiService.getComment(id)
    }

    fun extraGame(): LiveData<List<MoreGame>> {
        return apiService.extraGame()
    }

    fun getBanners(): LiveData<List<Banners>> {
        return apiService.getBanners()
    }

    //////////////
    //////////////
    //////////////
    //application
    fun moreApplication(): LiveData<List<MoreGame>> {
        return apiService.moreApplication()
    }

    fun newApp(): LiveData<List<MoreGame>> {
        return apiService.newApp()
    }

    fun moreAppForYou(): LiveData<List<MoreGame>> {
        return apiService.moreAppForYou()
    }

    fun bestNewApp(): LiveData<List<MoreGame>> {
        return apiService.bestNewApp()
    }

    fun updateApp(): LiveData<List<MoreGame>> {
        return apiService.updateApp()
    }

    fun catApp(): LiveData<List<CatGame>> {
        return apiService.catApp()
    }

    fun AllMoreApp(id: String): LiveData<MoreGame> {
        return apiService.AllMoreApp(id)
    }

    fun getCommentApp(id: String): LiveData<MoreGame> {
        return apiService.getCommentApp(id)
    }

    fun extraApp(): LiveData<List<MoreGame>> {
        return apiService.extraApp()
    }

    fun getSliders(): LiveData<List<Banners>> {
        return apiService.getSliders()
    }

    /////////////////
    /////////////////
    /////////////////
    //movie
    fun getBigImage(): LiveData<List<BigImage>> {
        return apiService.getBigImage()
    }

    fun getUpdateFilm(): LiveData<List<Movie>> {
        return apiService.getUpdateFilm()
    }

    fun getFilmIran(): LiveData<List<Movie>> {
        return apiService.getFilmIran()
    }

    fun getFilmHero(): LiveData<List<Movie>> {
        return apiService.getFilmHero()
    }

    fun getAnimat(): LiveData<List<Movie>> {
        return apiService.getAnimat()
    }

    fun getMore1(): LiveData<List<Movie>> {
        return apiService.getMore1()
    }

    fun getCat(): LiveData<List<CatMovie>> {
        return apiService.getCat()
    }


    fun getCommentMovie(id: String): LiveData<Movie> {
        return apiService.getCommentMovie(id)
    }

    fun getFasl(id: String): LiveData<Movie> {
        return apiService.getFasl(id)
    }


    ///////////////
    ///////////////
    ///////////////
    //profile

    fun getSignUp(email: String, pass: String): LiveData<MyMessage> {
        return apiService.getSignUp(email, pass)
    }

    //
    fun search(search: String): LiveData<List<MoreGame>> {
        return apiService.search(search)
    }

}