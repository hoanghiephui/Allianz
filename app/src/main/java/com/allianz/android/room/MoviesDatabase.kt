package com.allianz.android.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.allianz.android.room.DATABASE.DATABASE_MOVIE
import com.allianz.android.room.DATABASE.DATABASE_MOVIE_VERSION

@Database(entities = [Movie::class], version = DATABASE_MOVIE_VERSION, exportSchema = false)
abstract class MoviesDatabase : RoomDatabase() {

    abstract fun movieDao(): MoviesDao

    companion object {

        @Volatile
        private var INSTANCE: MoviesDatabase? = null

        fun getInstance(context: Context): MoviesDatabase = INSTANCE ?: synchronized(this) {
            INSTANCE ?: buildMoviesDatabase(context).also { INSTANCE = it }
        }

        private fun buildMoviesDatabase(context: Context) = Room.databaseBuilder(context, MoviesDatabase::class.java, DATABASE_MOVIE).build()
    }
}