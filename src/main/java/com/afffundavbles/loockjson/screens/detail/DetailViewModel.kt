package com.afffundavbles.loockjson.screens.detail

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.afffundavbles.loockjson.MAIN
import com.afffundavbles.loockjson.REALISATION
import com.afffundavbles.loockjson.data.room.repository.MoviesRepositoryRealization
import com.afffundavbles.loockjson.models.MovieItemModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailViewModel:  ViewModel() {

    fun insert(movieItemModel: MovieItemModel, onSuccess:() -> Unit) =
        viewModelScope.launch (Dispatchers.IO){
            REALISATION.insertMovie(movieItemModel){
                onSuccess()
            }
        }
    fun delete(movieItemModel: MovieItemModel, onSuccess:() -> Unit) =
        viewModelScope.launch (Dispatchers.IO){
            REALISATION.deleteMovie(movieItemModel){
                onSuccess()
            }
        }



}