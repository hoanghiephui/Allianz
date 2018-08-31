package com.allianz.android

import android.app.Activity
import android.app.Application
import com.allianz.android.api.base.AllianzFramework
import com.allianz.android.api.base.FrameworkInterface
import com.allianz.android.di.AppInjector
import dagger.Lazy
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Named

class AllianzApplication : Application(), HasActivityInjector, FrameworkInterface {
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>
    @field:[Inject Named("api")]
    lateinit var retrofitApi: Lazy<Retrofit>
    @field:[Inject Named("explorer")]
    lateinit var retrofitExplorer: Lazy<Retrofit>

    override fun onCreate() {
        super.onCreate()
        // Inject into Application
        AppInjector.init(this)
        // Pass objects API
        AllianzFramework.init(this)
    }

    override fun activityInjector() = dispatchingAndroidInjector

    override fun getRetrofitApiInstance(): Retrofit = retrofitApi.get()

    override fun getRetrofitExplorerInstance(): Retrofit = retrofitExplorer.get()
}