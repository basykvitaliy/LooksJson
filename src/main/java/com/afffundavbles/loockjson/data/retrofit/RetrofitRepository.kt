package com.afffundavbles.loockjson.data.retrofit

import com.afffundavbles.loockjson.data.retrofit.api.RetrofitInstance
import com.afffundavbles.loockjson.models.MoviesModel
import retrofit2.Response

class RetrofitRepository {
    suspend fun getMovies(): Response<MoviesModel>{
        return RetrofitInstance.api.getPopularMovie()
    }
}