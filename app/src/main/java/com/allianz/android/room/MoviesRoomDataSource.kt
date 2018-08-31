package com.allianz.android.room

class MoviesRoomDataSource(private val moviesDao: MoviesDao) {

    fun storeMovies(movieList: List<Movie>) = moviesDao.insert(movieList)

    fun getMovies() = moviesDao.allMovies()
}