package com.allianz.android.api.base

import retrofit2.Retrofit

object AllianzFramework {
    private lateinit var retrofitInterface: FrameworkInterface

    val retrofitApiInstance: Retrofit
        get() = retrofitInterface.getRetrofitApiInstance()

    val retrofitExplorerInstance: Retrofit
        get() = retrofitInterface.getRetrofitExplorerInstance()


    fun init(frameworkInterface: FrameworkInterface) {
        retrofitInterface = frameworkInterface
    }
}