package com.allianz.android.room

import android.arch.paging.DataSource
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.allianz.android.room.DATABASE.SELECT_MOVIE

@Dao
interface MoviesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(movieList: List<Movie>)

    @Query(SELECT_MOVIE)
    fun allMovies(): DataSource.Factory<Int, Movie>
}