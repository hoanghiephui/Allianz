package com.allianz.android.api

import com.allianz.android.api.base.AllianzFramework
import com.allianz.android.api.endpoint.AllianzEndpoint

class AllianzApi {
    /**
     * Lazily evaluates an instance of [VietnamAirlinesEndpoint].
     */
    val endpoints: AllianzEndpoint by lazy {
        AllianzFramework.retrofitApiInstance
                .create(AllianzEndpoint::class.java)
    }
}