package com.allianz.android.di.module

import android.content.Context
import com.allianz.android.api.AllianzApi
import com.allianz.android.api.ExplorerApi
import com.allianz.android.room.MoviesDatabase
import com.allianz.android.room.MoviesRoomDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataManagerModule {
    @Provides
    @Singleton
    fun provideExplorerApiFactory(): ExplorerApi {
        return ExplorerApi()
    }

    @Provides
    @Singleton
    fun provideVietnamAirlineApiFactory(): AllianzApi {
        return AllianzApi()
    }

    @Provides
    @Singleton
    fun provideMoviesDatabase(context: Context): MoviesRoomDataSource {
        val moviesDatabase = MoviesDatabase.getInstance(context)
        return MoviesRoomDataSource(moviesDatabase.movieDao())
    }
}