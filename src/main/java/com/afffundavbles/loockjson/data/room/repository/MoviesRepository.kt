package com.afffundavbles.loockjson.data.room.repository

import androidx.lifecycle.LiveData
import com.afffundavbles.loockjson.models.MovieItemModel

interface MoviesRepository {
    val allMovies: LiveData<List<MovieItemModel>>
    suspend fun insertMovie(movieItemModel: MovieItemModel, onSuccess:() -> Unit)
    suspend fun deleteMovie(movieItemModel: MovieItemModel, onSuccess:() -> Unit)

}