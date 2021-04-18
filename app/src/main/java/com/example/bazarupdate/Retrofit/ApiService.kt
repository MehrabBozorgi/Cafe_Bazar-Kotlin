package com.example.bazarupdate.Retrofit

import com.example.bazarupdate.Model.App_Game.*
import com.example.bazarupdate.Model.Movie.CatMovie
import com.example.bazarupdate.Model.Movie.Movie
import com.example.bazarupdate.Model.Profile.MyMessage
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    //game
    @GET("getgoli.php")
    fun getGoli(): Call<List<GetGoli>>

    @GET("moregame.php")
    fun moreGame(): Call<List<MoreGame>>

    @GET("moregame.php")
    fun newGame(): Call<List<MoreGame>>

    @GET("moregame.php")
    fun bestNew(): Call<List<MoreGame>>

    @GET("moregame.php")
    fun updateGame(): Call<List<MoreGame>>

    @GET("cat_game.php")
    fun catGame(): Call<List<CatGame>>

    @GET("allmoregame.php")
    fun AllMore(@Query("id") id: String): Call<MoreGame>

    @GET("allmoregame.php")
    fun getComment(@Query("id") id: String): Call<MoreGame>

    @GET("moregame.php")
    fun extraGame(): Call<List<MoreGame>>

    //وقتی که روی ریلیتیو همه کلیک کردیم
    @GET("moregame.php")
    fun moreGameForYou(): Call<List<MoreGame>>

    @GET("getbanners.php")
    fun getBanners(): Call<List<Banners>>

//////////////////////////////
//////////////////////////////
//////////////////////////////

    //application
    @GET("moreapp.php")
    fun moreApplication(): Call<List<MoreGame>>

    @GET("moreapp.php")
    fun newApp(): Call<List<MoreGame>>

    @GET("moreapp.php")
    fun bestNewApp(): Call<List<MoreGame>>

    @GET("moreapp.php")
    fun updateApp(): Call<List<MoreGame>>

    @GET("cat_application.php")
    fun catApp(): Call<List<CatGame>>

    @GET("allmoreapp.php")
    fun AllMoreApp(@Query("id") id: String): Call<MoreGame>

    @GET("allmoreapp.php")
    fun getCommentApp(@Query("id") id: String): Call<MoreGame>

    @GET("moreapp.php")
    fun extraApp(): Call<List<MoreGame>>

    //وقتی که روی ریلیتیو همه کلیک کردیم
    @GET("moreapp.php")
    fun moreAppForYou(): Call<List<MoreGame>>

    @GET("sliders.php")
    fun getSliders(): Call<List<Banners>>
    ///////////
    ///////////
    ///////////
    //movie

    @GET("big_image_movie.php")
    fun getBigImage(): Call<List<BigImage>>

    @GET("movie.php")
    fun getUpdateFilm(): Call<List<Movie>>

    @GET("movie.php")
    fun getFilmIran(): Call<List<Movie>>

    @GET("movie.php")
    fun getFilmHero(): Call<List<Movie>>

    @GET("movie.php")
    fun getAnimat(): Call<List<Movie>>

    @GET("cat_movie.php")
    fun getCat(): Call<List<CatMovie>>

    @GET("allmovie.php")
    fun getCommentMovie(@Query("id") id: String): Call<Movie>

    @GET("movie.php")
    fun getMore1(): Call<List<Movie>>

    @GET("allmovie.php")
    fun getFasl(@Query("id") id: String): Call<Movie>

    ///////////
    ///////////
    ///////////
    //Profile
    @FormUrlEncoded
    @POST("login.php")
    fun getSignUp(@Field("email") email: String, @Field("pass") pass: String): Call<MyMessage>
    ///////////
    ///////////
    ///////////
    //Search

    @GET("search.php")
    fun search(@Query("search")  search: String):Call<List<MoreGame>>
}