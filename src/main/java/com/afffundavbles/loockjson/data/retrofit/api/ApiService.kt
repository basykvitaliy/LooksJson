package com.afffundavbles.loockjson.data.retrofit.api

import com.afffundavbles.loockjson.models.MoviesModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("3/movie/popular?api_key=a5ba47a7ca3e23a9d83875a1a28d5448&language=en-US&page=1")
    suspend fun getPopularMovie(): Response<MoviesModel>
}