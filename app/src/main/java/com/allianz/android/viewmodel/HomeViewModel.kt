package com.allianz.android.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.arch.paging.PagedList
import com.allianz.android.repository.HomeRepository
import com.allianz.android.room.Movie
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HomeViewModel @Inject constructor(
        private val homeRepository: HomeRepository
) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()
    var pagedListMovie = MutableLiveData<PagedList<Movie>>()

    fun getMovies() {
        compositeDisposable.add(homeRepository.fetchOrGetMovies()
                .subscribe({ pagedListMovie.value = it }, { it.printStackTrace() }))
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}