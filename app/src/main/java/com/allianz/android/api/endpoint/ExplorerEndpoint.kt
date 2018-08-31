package com.allianz.android.api.endpoint

import com.allianz.android.api.Endpoint.DISCOVER
import com.allianz.android.api.Query.API_KEY
import com.allianz.android.api.Query.API_KEY_VALUE
import com.allianz.android.api.Query.INCLUDE_ADULT
import com.allianz.android.api.Query.INCLUDE_ADULT_DEFAULT
import com.allianz.android.api.Query.LANGUAGE
import com.allianz.android.api.Query.LANGUAGE_DEFAULT
import com.allianz.android.api.Query.PAGE
import com.allianz.android.api.Query.SORT_BY
import com.allianz.android.api.Query.SORT_BY_DEFAULT
import com.allianz.android.models.MovieApi
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ExplorerEndpoint {
    @GET(DISCOVER)
    fun fetchMovies(@Query(PAGE) page: Int,
                    @Query(SORT_BY) sortBy: String = SORT_BY_DEFAULT,
                    @Query(LANGUAGE) language: String = LANGUAGE_DEFAULT,
                    @Query(INCLUDE_ADULT) includeAdult: Boolean = INCLUDE_ADULT_DEFAULT,
                    @Query(API_KEY) apiKey: String = API_KEY_VALUE): Single<List<MovieApi>>
}