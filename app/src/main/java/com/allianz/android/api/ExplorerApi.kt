package com.allianz.android.api

import com.allianz.android.api.base.AllianzFramework
import com.allianz.android.api.endpoint.ExplorerEndpoint

class ExplorerApi {
    /**
     * Lazily evaluates an instance of [ExplorerEndpoint].
     */
    private val endpoints: ExplorerEndpoint by lazy {
        AllianzFramework.retrofitExplorerInstance
                .create(ExplorerEndpoint::class.java)
    }

    fun fetchMovies(page: Int) = endpoints.fetchMovies(page)
}