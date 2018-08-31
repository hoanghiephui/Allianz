package com.allianz.android.repository

import android.arch.paging.PagedList
import android.arch.paging.RxPagedListBuilder
import com.allianz.android.api.ExplorerApi
import com.allianz.android.room.DATABASE.PAGE_SIZE
import com.allianz.android.room.Movie
import com.allianz.android.room.MoviesRoomDataSource
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HomeRepository @Inject constructor(
        private val explorerApi: ExplorerApi,
        private val moviesRoomDataSource: MoviesRoomDataSource
) {
    fun fetchOrGetMovies(): Observable<PagedList<Movie>> = RxPagedListBuilder(moviesRoomDataSource.getMovies(), PAGE_SIZE)
            .setBoundaryCallback(PageListMovieBoundaryCallback(explorerApi, moviesRoomDataSource))
            .buildObservable()
}