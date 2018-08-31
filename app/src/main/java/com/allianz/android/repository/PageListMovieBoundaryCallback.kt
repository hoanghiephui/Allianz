package com.allianz.android.repository

import android.annotation.SuppressLint
import android.arch.paging.PagedList
import android.util.Log
import com.allianz.android.api.ExplorerApi
import com.allianz.android.models.toMovieEntity
import com.allianz.android.room.Movie
import com.allianz.android.room.MoviesRoomDataSource
import io.reactivex.schedulers.Schedulers

class PageListMovieBoundaryCallback(private val explorerApi: ExplorerApi,
                                    private val moviesRoomDataSource: MoviesRoomDataSource) : PagedList.BoundaryCallback<Movie>() {

    private var isRequestRunning = false
    private var requestedPage = 1

    override fun onZeroItemsLoaded() {
        Log.i(TAG, "onZeroItemsLoaded")
        fetchAndStoreMovies()
    }

    override fun onItemAtEndLoaded(itemAtEnd: Movie) {
        Log.i(TAG, "onItemAtEndLoaded")
        fetchAndStoreMovies()
    }

    @SuppressLint("CheckResult")
    private fun fetchAndStoreMovies() {
        if (isRequestRunning) return

        isRequestRunning = true
        explorerApi.fetchMovies(requestedPage)
                .map { movieApiList -> movieApiList.map { it.toMovieEntity() } }
                .doOnSuccess { listMovie ->
                    if (listMovie.isNotEmpty()) {
                        moviesRoomDataSource.storeMovies(listMovie)
                        Log.i(TAG, "Inserted: ${listMovie.size}")
                    } else {
                        Log.i(TAG, "No Inserted")
                    }
                    requestedPage++
                }
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .toCompletable()
                .doFinally { isRequestRunning = false }
                .subscribe({ Log.i(TAG, "Movies Completed") }, { it.printStackTrace() })

    }

    companion object {
        private const val TAG: String = "PageListMovieBoundary "
    }
}