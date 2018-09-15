package com.vp.detail.service

import com.vp.detail.model.MovieDetail
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface DetailService {
    @GET("/")
    fun getMovie(@Query("i") imdbID: String): Call<MovieDetail>
}