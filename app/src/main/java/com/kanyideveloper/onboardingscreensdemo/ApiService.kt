package com.kanyideveloper.onboardingscreensdemo

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService{

    @GET("beers")
    fun getBeers() : Call<Beers>
}

object BeersApi{
    private const val BASE_URL = "https://api.punkapi.com/v2/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}

























/*
interface ApiService {

    @GET("beers")
    fun getBeers() : Call<Beers>

}

object BeersApi{
    const val BASE_URL = "https://api.punkapi.com/v2/"
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val retrofirService by lazy {
        retrofit.create(ApiService::class.java)
    }
}*/
