package com.afffundavbles.loockjson.screens.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.afffundavbles.loockjson.REALISATION
import com.afffundavbles.loockjson.data.room.repository.MoviesRepositoryRealization
import com.afffundavbles.loockjson.models.MovieItemModel

class FavoriteFragmentViewModel: ViewModel() {

    fun getAllMovies(): LiveData<List<MovieItemModel>>{
        return REALISATION.allMovies
    }
}