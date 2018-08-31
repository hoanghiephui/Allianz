package com.allianz.android.api.base

import retrofit2.Retrofit

interface FrameworkInterface {
    /**
     * Provides an instance of Retrofit with it's base URL
     */
    abstract fun getRetrofitApiInstance(): Retrofit

    /**
     * Provides an instance of Retrofit with it's base URL
     */
    abstract fun getRetrofitExplorerInstance(): Retrofit
}