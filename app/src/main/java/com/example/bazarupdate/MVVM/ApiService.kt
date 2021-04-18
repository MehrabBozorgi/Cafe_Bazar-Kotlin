package com.example.bazarupdate.MVVM

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.bazarupdate.Model.App_Game.*
import com.example.bazarupdate.Model.Movie.CatMovie
import com.example.bazarupdate.Model.Movie.Movie
import com.example.bazarupdate.Model.Profile.MyMessage
import com.example.bazarupdate.Retrofit.ApiClient
import com.example.bazarupdate.Retrofit.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiService(var context: Application) {
    var apiService = ApiClient.getClient().create(ApiService::class.java)

    ///////////////////
    ///////////////////
    ///////////////////
    //Game
    fun getGoli(): MutableLiveData<List<GetGoli>> {

        val mutableLiveData = MutableLiveData<List<GetGoli>>()
        apiService.getGoli().enqueue(object : Callback<List<GetGoli>> {
            override fun onResponse(call: Call<List<GetGoli>>, response: Response<List<GetGoli>>) {

                mutableLiveData.value = response.body()

            }

            override fun onFailure(call: Call<List<GetGoli>>, t: Throwable) {
                Toast.makeText(context, t.toString(), Toast.LENGTH_SHORT).show()
            }

        })
        return mutableLiveData
    }

    fun moreGame(): MutableLiveData<List<MoreGame>> {

        val mutableLiveData = MutableLiveData<List<MoreGame>>()
        apiService.moreGame().enqueue(object : Callback<List<MoreGame>> {
            override fun onResponse(
                call: Call<List<MoreGame>>,
                response: Response<List<MoreGame>>
            ) {
                mutableLiveData.value = response.body()
            }

            override fun onFailure(call: Call<List<MoreGame>>, t: Throwable) {
                Toast.makeText(context, t.toString(), Toast.LENGTH_SHORT).show()
            }
        })
        return mutableLiveData
    }

    fun newGame(): MutableLiveData<List<MoreGame>> {

        val mutableLiveData = MutableLiveData<List<MoreGame>>()
        apiService.newGame().enqueue(object : Callback<List<MoreGame>> {
            override fun onResponse(
                call: Call<List<MoreGame>>,
                response: Response<List<MoreGame>>
            ) {

                mutableLiveData.value = response.body()

            }

            override fun onFailure(call: Call<List<MoreGame>>, t: Throwable) {
                Toast.makeText(context, t.toString(), Toast.LENGTH_SHORT).show()
            }
        })
        return mutableLiveData

    }

    fun moreGameForYou(): MutableLiveData<List<MoreGame>> {

        val mutableLiveData = MutableLiveData<List<MoreGame>>()
        apiService.moreGameForYou().enqueue(object : Callback<List<MoreGame>> {
            override fun onResponse(
                call: Call<List<MoreGame>>,
                response: Response<List<MoreGame>>
            ) {

                mutableLiveData.value = response.body()

            }

            override fun onFailure(call: Call<List<MoreGame>>, t: Throwable) {
                Toast.makeText(context, t.toString(), Toast.LENGTH_SHORT).show()
            }
        })
        return mutableLiveData

    }

    fun bestNew(): MutableLiveData<List<MoreGame>> {

        val mutableLiveData = MutableLiveData<List<MoreGame>>()
        apiService.bestNew().enqueue(object : Callback<List<MoreGame>> {
            override fun onResponse(
                call: Call<List<MoreGame>>,
                response: Response<List<MoreGame>>
            ) {

                mutableLiveData.value = response.body()

            }

            override fun onFailure(call: Call<List<MoreGame>>, t: Throwable) {
                Toast.makeText(context, t.toString(), Toast.LENGTH_SHORT).show()
            }
        })
        return mutableLiveData

    }

    fun updateGame(): MutableLiveData<List<MoreGame>> {
        val mutableLiveData = MutableLiveData<List<MoreGame>>()
        apiService.updateGame().enqueue(object : Callback<List<MoreGame>> {
            override fun onResponse(
                call: Call<List<MoreGame>>,
                response: Response<List<MoreGame>>
            ) {
                mutableLiveData.value = response.body()
            }

            override fun onFailure(call: Call<List<MoreGame>>, t: Throwable) {
                Toast.makeText(context, t.toString(), Toast.LENGTH_SHORT).show()
            }
        })
        return mutableLiveData

    }

    fun catGame(): MutableLiveData<List<CatGame>> {

        val mutableLiveData = MutableLiveData<List<CatGame>>()
        apiService.catGame().enqueue(object : Callback<List<CatGame>> {
            override fun onResponse(call: Call<List<CatGame>>, response: Response<List<CatGame>>) {

                mutableLiveData.value = response.body()
            }

            override fun onFailure(call: Call<List<CatGame>>, t: Throwable) {
                Toast.makeText(context, t.toString(), Toast.LENGTH_SHORT).show()
            }

        })
        return mutableLiveData
    }

    fun AllMore(id: String): MutableLiveData<MoreGame> {

        val mutableLiveData = MutableLiveData<MoreGame>()
        apiService.AllMore(id).enqueue(object : Callback<MoreGame> {
            override fun onResponse(
                call: Call<MoreGame>,
                response: Response<MoreGame>
            ) {

                mutableLiveData.value = response.body()
            }

            override fun onFailure(call: Call<MoreGame>, t: Throwable) {
                Toast.makeText(context, t.toString(), Toast.LENGTH_LONG).show()
            }
        })
        return mutableLiveData
    }

    fun getComment(id: String): MutableLiveData<MoreGame> {

        val mutableLiveData = MutableLiveData<MoreGame>()
        apiService.getComment(id).enqueue(object : Callback<MoreGame> {
            override fun onResponse(
                call: Call<MoreGame>,
                response: Response<MoreGame>
            ) {

                mutableLiveData.value = response.body()
            }

            override fun onFailure(call: Call<MoreGame>, t: Throwable) {
                Toast.makeText(context, t.toString(), Toast.LENGTH_LONG).show()
            }
        })
        return mutableLiveData
    }

    fun extraGame(): MutableLiveData<List<MoreGame>> {
        var mutableLiveData = MutableLiveData<List<MoreGame>>()
        apiService.extraGame().enqueue(object : Callback<List<MoreGame>> {
            override fun onResponse(
                call: Call<List<MoreGame>>,
                response: Response<List<MoreGame>>
            ) {
                mutableLiveData.value = response.body()
            }

            override fun onFailure(call: Call<List<MoreGame>>, t: Throwable) {
                Toast.makeText(context, t.toString(), Toast.LENGTH_SHORT).show()
            }
        })
        return mutableLiveData

    }

    fun getBanners(): MutableLiveData<List<Banners>> {

        var mutableLiveData = MutableLiveData<List<Banners>>()
        apiService.getBanners().enqueue(object : Callback<List<Banners>> {
            override fun onResponse(call: Call<List<Banners>>, response: Response<List<Banners>>) {

                mutableLiveData.value = response.body()

            }

            override fun onFailure(call: Call<List<Banners>>, t: Throwable) {
                Toast.makeText(context, t.toString(), Toast.LENGTH_SHORT).show()
            }

        })
        return mutableLiveData
    }

    ///////////////////
    ///////////////////
    ///////////////////
    //application
    fun moreApplication(): MutableLiveData<List<MoreGame>> {

        var mutableLiveData = MutableLiveData<List<MoreGame>>()
        apiService.moreApplication().enqueue(object : Callback<List<MoreGame>> {
            override fun onResponse(
                call: Call<List<MoreGame>>,
                response: Response<List<MoreGame>>
            ) {
                mutableLiveData.value = response.body()
            }

            override fun onFailure(call: Call<List<MoreGame>>, t: Throwable) {
                Toast.makeText(context, t.toString(), Toast.LENGTH_SHORT).show()
            }
        })
        return mutableLiveData
    }

    fun newApp(): MutableLiveData<List<MoreGame>> {

        var mutableLiveData = MutableLiveData<List<MoreGame>>()
        apiService.newApp().enqueue(object : Callback<List<MoreGame>> {
            override fun onResponse(
                call: Call<List<MoreGame>>,
                response: Response<List<MoreGame>>
            ) {

                mutableLiveData.value = response.body()

            }

            override fun onFailure(call: Call<List<MoreGame>>, t: Throwable) {
                Toast.makeText(context, t.toString(), Toast.LENGTH_SHORT).show()
            }
        })
        return mutableLiveData

    }

    fun moreAppForYou(): MutableLiveData<List<MoreGame>> {

        var mutableLiveData = MutableLiveData<List<MoreGame>>()
        apiService.moreAppForYou().enqueue(object : Callback<List<MoreGame>> {
            override fun onResponse(
                call: Call<List<MoreGame>>,
                response: Response<List<MoreGame>>
            ) {

                mutableLiveData.value = response.body()

            }

            override fun onFailure(call: Call<List<MoreGame>>, t: Throwable) {
                Toast.makeText(context, t.toString(), Toast.LENGTH_SHORT).show()
            }
        })
        return mutableLiveData

    }

    fun bestNewApp(): MutableLiveData<List<MoreGame>> {

        var mutableLiveData = MutableLiveData<List<MoreGame>>()
        apiService.bestNewApp().enqueue(object : Callback<List<MoreGame>> {
            override fun onResponse(
                call: Call<List<MoreGame>>,
                response: Response<List<MoreGame>>
            ) {

                mutableLiveData.value = response.body()

            }

            override fun onFailure(call: Call<List<MoreGame>>, t: Throwable) {
                Toast.makeText(context, t.toString(), Toast.LENGTH_SHORT).show()
            }
        })
        return mutableLiveData

    }

    fun updateApp(): MutableLiveData<List<MoreGame>> {
        var mutableLiveData = MutableLiveData<List<MoreGame>>()
        apiService.updateApp().enqueue(object : Callback<List<MoreGame>> {
            override fun onResponse(
                call: Call<List<MoreGame>>,
                response: Response<List<MoreGame>>
            ) {
                mutableLiveData.value = response.body()
            }

            override fun onFailure(call: Call<List<MoreGame>>, t: Throwable) {
                Toast.makeText(context, t.toString(), Toast.LENGTH_SHORT).show()
            }
        })
        return mutableLiveData

    }

    fun catApp(): MutableLiveData<List<CatGame>> {

        var mutableLiveData = MutableLiveData<List<CatGame>>()
        apiService.catApp().enqueue(object : Callback<List<CatGame>> {
            override fun onResponse(call: Call<List<CatGame>>, response: Response<List<CatGame>>) {

                mutableLiveData.value = response.body()
            }

            override fun onFailure(call: Call<List<CatGame>>, t: Throwable) {
                Toast.makeText(context, t.toString(), Toast.LENGTH_SHORT).show()
            }

        })
        return mutableLiveData
    }

    fun AllMoreApp(id: String): MutableLiveData<MoreGame> {

        var mutableLiveData = MutableLiveData<MoreGame>()
        apiService.AllMoreApp(id).enqueue(object : Callback<MoreGame> {
            override fun onResponse(
                call: Call<MoreGame>,
                response: Response<MoreGame>
            ) {

                mutableLiveData.value = response.body()
            }

            override fun onFailure(call: Call<MoreGame>, t: Throwable) {
                Toast.makeText(context, t.toString(), Toast.LENGTH_LONG).show()
            }
        })
        return mutableLiveData
    }

    fun getCommentApp(id: String): MutableLiveData<MoreGame> {

        var mutableLiveData = MutableLiveData<MoreGame>()
        apiService.getCommentApp(id).enqueue(object : Callback<MoreGame> {
            override fun onResponse(
                call: Call<MoreGame>,
                response: Response<MoreGame>
            ) {

                mutableLiveData.value = response.body()
            }

            override fun onFailure(call: Call<MoreGame>, t: Throwable) {
                Toast.makeText(context, t.toString(), Toast.LENGTH_LONG).show()
            }
        })
        return mutableLiveData
    }

    fun extraApp(): MutableLiveData<List<MoreGame>> {
        var mutableLiveData = MutableLiveData<List<MoreGame>>()
        apiService.extraApp().enqueue(object : Callback<List<MoreGame>> {
            override fun onResponse(
                call: Call<List<MoreGame>>,
                response: Response<List<MoreGame>>
            ) {
                mutableLiveData.value = response.body()
            }

            override fun onFailure(call: Call<List<MoreGame>>, t: Throwable) {
                Toast.makeText(context, t.toString(), Toast.LENGTH_SHORT).show()
            }
        })
        return mutableLiveData

    }

    fun getSliders(): MutableLiveData<List<Banners>> {

        var mutableLiveData = MutableLiveData<List<Banners>>()
        apiService.getSliders().enqueue(object : Callback<List<Banners>> {
            override fun onResponse(call: Call<List<Banners>>, response: Response<List<Banners>>) {

                mutableLiveData.value = response.body()

            }

            override fun onFailure(call: Call<List<Banners>>, t: Throwable) {
                Toast.makeText(context, t.toString(), Toast.LENGTH_SHORT).show()
            }

        })
        return mutableLiveData
    }

    ///////////////////
    ///////////////////
    ///////////////////
    //movie
    fun getBigImage(): MutableLiveData<List<BigImage>> {

        var mutableLiveData = MutableLiveData<List<BigImage>>()
        apiService.getBigImage().enqueue(object : Callback<List<BigImage>> {
            override fun onResponse(
                call: Call<List<BigImage>>,
                response: Response<List<BigImage>>
            ) {

                mutableLiveData.value = response.body()

            }

            override fun onFailure(call: Call<List<BigImage>>, t: Throwable) {
                Toast.makeText(context, t.toString(), Toast.LENGTH_SHORT).show()
            }

        })
        return mutableLiveData
    }

    fun getUpdateFilm(): MutableLiveData<List<Movie>> {

        var mutableLiveData = MutableLiveData<List<Movie>>()
        apiService.getUpdateFilm().enqueue(object : Callback<List<Movie>> {
            override fun onResponse(call: Call<List<Movie>>, response: Response<List<Movie>>) {

                mutableLiveData.value = response.body()

            }

            override fun onFailure(call: Call<List<Movie>>, t: Throwable) {
                Toast.makeText(context, t.toString(), Toast.LENGTH_SHORT).show()
            }

        })
        return mutableLiveData
    }

    fun getFilmIran(): MutableLiveData<List<Movie>> {

        var mutableLiveData = MutableLiveData<List<Movie>>()
        apiService.getFilmIran().enqueue(object : Callback<List<Movie>> {
            override fun onResponse(call: Call<List<Movie>>, response: Response<List<Movie>>) {

                mutableLiveData.value = response.body()

            }

            override fun onFailure(call: Call<List<Movie>>, t: Throwable) {
                Toast.makeText(context, t.toString(), Toast.LENGTH_SHORT).show()
            }

        })
        return mutableLiveData
    }

    fun getFilmHero(): MutableLiveData<List<Movie>> {

        var mutableLiveData = MutableLiveData<List<Movie>>()
        apiService.getFilmHero().enqueue(object : Callback<List<Movie>> {
            override fun onResponse(call: Call<List<Movie>>, response: Response<List<Movie>>) {

                mutableLiveData.value = response.body()

            }

            override fun onFailure(call: Call<List<Movie>>, t: Throwable) {
                Toast.makeText(context, t.toString(), Toast.LENGTH_SHORT).show()
            }

        })
        return mutableLiveData
    }

    fun getAnimat(): MutableLiveData<List<Movie>> {

        var mutableLiveData = MutableLiveData<List<Movie>>()
        apiService.getAnimat().enqueue(object : Callback<List<Movie>> {
            override fun onResponse(call: Call<List<Movie>>, response: Response<List<Movie>>) {

                mutableLiveData.value = response.body()

            }

            override fun onFailure(call: Call<List<Movie>>, t: Throwable) {
                Toast.makeText(context, t.toString(), Toast.LENGTH_SHORT).show()
            }

        })
        return mutableLiveData
    }

    fun getMore1(): MutableLiveData<List<Movie>> {

        var mutableLiveData = MutableLiveData<List<Movie>>()
        apiService.getMore1().enqueue(object : Callback<List<Movie>> {
            override fun onResponse(call: Call<List<Movie>>, response: Response<List<Movie>>) {

                mutableLiveData.value = response.body()

            }

            override fun onFailure(call: Call<List<Movie>>, t: Throwable) {
                Toast.makeText(context, t.toString(), Toast.LENGTH_SHORT).show()
            }

        })
        return mutableLiveData
    }

    fun getCat(): MutableLiveData<List<CatMovie>> {

        var mutableLiveData = MutableLiveData<List<CatMovie>>()
        apiService.getCat().enqueue(object : Callback<List<CatMovie>> {
            override fun onResponse(
                call: Call<List<CatMovie>>,
                response: Response<List<CatMovie>>
            ) {

                mutableLiveData.value = response.body()

            }

            override fun onFailure(call: Call<List<CatMovie>>, t: Throwable) {
                Toast.makeText(context, t.toString(), Toast.LENGTH_SHORT).show()
            }

        })
        return mutableLiveData
    }

    fun getCommentMovie(id: String): MutableLiveData<Movie> {

        var mutableLiveData = MutableLiveData<Movie>()

        apiService.getCommentMovie(id).enqueue(object : Callback<Movie> {
            override fun onResponse(call: Call<Movie>, response: Response<Movie>) {

                mutableLiveData.value = response.body()

            }

            override fun onFailure(call: Call<Movie>, t: Throwable) {
                Toast.makeText(context, t.toString(), Toast.LENGTH_SHORT).show()
            }

        })
        return mutableLiveData
    }

    fun getFasl(id: String): MutableLiveData<Movie> {

        var mutableLiveData = MutableLiveData<Movie>()

        apiService.getFasl(id).enqueue(object : Callback<Movie> {
            override fun onResponse(call: Call<Movie>, response: Response<Movie>) {

                mutableLiveData.value = response.body()

            }

            override fun onFailure(call: Call<Movie>, t: Throwable) {
                Toast.makeText(context, t.toString(), Toast.LENGTH_SHORT).show()
            }

        })
        return mutableLiveData
    }

    fun getSignUp(email: String, pass: String): MutableLiveData<MyMessage> {
        var mutableLiveData = MutableLiveData<MyMessage>()

        apiService.getSignUp(email, pass).enqueue(object : Callback<MyMessage> {
            override fun onResponse(call: Call<MyMessage>, response: Response<MyMessage>) {

                mutableLiveData.value = response.body()

            }

            override fun onFailure(call: Call<MyMessage>, t: Throwable) {
                Toast.makeText(context, t.toString(), Toast.LENGTH_SHORT).show()
            }

        })
        return mutableLiveData

    }

    //Search
    fun search(search: String): MutableLiveData<List<MoreGame>> {
        var mutableLiveData = MutableLiveData<List<MoreGame>>()
        apiService.search(search).enqueue(object : Callback<List<MoreGame>> {
            override fun onResponse(
                call: Call<List<MoreGame>>,
                response: Response<List<MoreGame>>
            ) {

                mutableLiveData.value = response.body()

            }

            override fun onFailure(call: Call<List<MoreGame>>, t: Throwable) {
                Toast.makeText(context, t.toString(), Toast.LENGTH_SHORT).show()
            }

        })
        return mutableLiveData

    }


}
