package com.afffundavbles.loockjson.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "movie_table")
data class MovieItemModel(

    @PrimaryKey(autoGenerate = true)
    val id: Int,

    val overview: String,

    val poster_path: String,

    val release_date: String,

    val title: String,

) : Serializable