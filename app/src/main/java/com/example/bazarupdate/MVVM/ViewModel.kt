package com.example.bazarupdate.MVVM

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.bazarupdate.Model.App_Game.*
import com.example.bazarupdate.Model.Movie.CatMovie
import com.example.bazarupdate.Model.Movie.Movie
import com.example.bazarupdate.Model.Profile.MyMessage

class ViewModel(application: Application) : AndroidViewModel(application) {
    var repository = Repository(application)
    ////////////////
    ////////////////
    ////////////////
    //Game

    fun getGoli(): LiveData<List<GetGoli>> {
        return repository.getGoli()
    }

    fun moreGame(): LiveData<List<MoreGame>> {
        return repository.moreGame()
    }

    fun newGame(): LiveData<List<MoreGame>> {
        return repository.newGame()
    }

    fun moreGameForYou(): LiveData<List<MoreGame>> {
        return repository.moreGameForYou()
    }

    fun bestNew(): LiveData<List<MoreGame>> {
        return repository.bestNew()
    }

    fun updateGame(): LiveData<List<MoreGame>> {
        return repository.updateGame()
    }

    fun catGame(): LiveData<List<CatGame>> {
        return repository.catGame()
    }

    fun AllMore(id: String): LiveData<MoreGame> {
        return repository.AllMore(id)
    }

    fun getComment(id: String): LiveData<MoreGame> {
        return repository.getComment(id)
    }

    fun extraGame(): LiveData<List<MoreGame>> {
        return repository.extraGame()
    }

    fun getBanners(): LiveData<List<Banners>> {
        return repository.getBanners()
    }
    ////////////////
    ////////////////
    ////////////////
    //application

    fun moreApplication(): LiveData<List<MoreGame>> {
        return repository.moreApplication()
    }

    fun newApp(): LiveData<List<MoreGame>> {
        return repository.newApp()
    }

    fun moreAppForYou(): LiveData<List<MoreGame>> {
        return repository.moreAppForYou()
    }

    fun bestNewApp(): LiveData<List<MoreGame>> {
        return repository.bestNewApp()
    }

    fun updateApp(): LiveData<List<MoreGame>> {
        return repository.updateApp()
    }

    fun catApp(): LiveData<List<CatGame>> {
        return repository.catApp()
    }

    fun AllMoreApp(id: String): LiveData<MoreGame> {
        return repository.AllMoreApp(id)
    }

    fun getCommentApp(id: String): LiveData<MoreGame> {
        return repository.getCommentApp(id)
    }

    fun extraApp(): LiveData<List<MoreGame>> {
        return repository.extraApp()
    }

    fun getSliders(): LiveData<List<Banners>> {
        return repository.getSliders()
    }

    //////////////////////////////////
    //////////////////////////////////
    //////////////////////////////////
    //movie
    fun getBigImage(): LiveData<List<BigImage>> {

        return repository.getBigImage()
    }

    fun getUpdateFilm(): LiveData<List<Movie>> {

        return repository.getUpdateFilm()
    }

    fun getFilmIran(): LiveData<List<Movie>> {

        return repository.getFilmIran()
    }

    fun getFilmHero(): LiveData<List<Movie>> {

        return repository.getFilmHero()
    }

    fun getAnimat(): LiveData<List<Movie>> {

        return repository.getAnimat()
    }

    fun getMore1(): LiveData<List<Movie>> {

        return repository.getMore1()
    }

    fun getCat(): LiveData<List<CatMovie>> {

        return repository.getCat()
    }

    fun getCommentMovie(id: String): LiveData<Movie> {

        return repository.getCommentMovie(id)
    }

    fun getFasl(id: String): LiveData<Movie> {

        return repository.getFasl(id)
    }


    ///////////////
    ///////////////
    ///////////////
    //profile

    fun getSignUp(email:String,pass:String): LiveData<MyMessage> {

        return repository.getSignUp(email,pass)
    }

    fun search(search:String): LiveData<List<MoreGame>> {

        return repository.search(search)
    }
}