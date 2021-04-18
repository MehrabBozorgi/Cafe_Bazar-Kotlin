package com.example.bazarupdate.Retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    companion object {
        var retrofit: Retrofit? = null
        var baseurl = "http://mehrabbozorgi1.ir/"
        fun getClient(): Retrofit {
            if (retrofit == null) {

                retrofit = Retrofit.Builder()
                    .baseUrl(baseurl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!
        }

    }
}