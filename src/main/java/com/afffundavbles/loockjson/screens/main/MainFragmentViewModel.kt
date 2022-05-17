package com.afffundavbles.loockjson.screens.main

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.afffundavbles.loockjson.REALISATION
import com.afffundavbles.loockjson.data.retrofit.RetrofitRepository
import com.afffundavbles.loockjson.data.room.MoviesRoomDatabase
import com.afffundavbles.loockjson.data.room.repository.MoviesRepositoryRealization
import com.afffundavbles.loockjson.models.MoviesModel
import kotlinx.coroutines.launch
import retrofit2.Response

class MainFragmentViewModel(application: Application): AndroidViewModel(application) {
    private val repository = RetrofitRepository()
    val myMovies: MutableLiveData<Response<MoviesModel>> = MutableLiveData()
    val context = application


    fun getMoviesRetrofit(){
        viewModelScope.launch {
            try {
                myMovies.value = repository.getMovies()
            }catch (e:Exception){
                Log.e("ERROR", e.message.toString())
            }

        }
    }
    fun initDatabase(){
        val daoMovie = MoviesRoomDatabase.getInstance(context).getMovieDao()
        REALISATION = MoviesRepositoryRealization(daoMovie)
    }


}