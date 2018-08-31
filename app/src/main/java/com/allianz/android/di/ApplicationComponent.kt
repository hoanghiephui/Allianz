package com.allianz.android.di

import android.app.Application
import com.allianz.android.AllianzApplication
import com.allianz.android.di.module.ActivityBindingModule
import com.allianz.android.di.module.ApiModule
import com.allianz.android.di.module.ApplicationModule
import com.allianz.android.di.module.DataManagerModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class,
        ApplicationModule::class, ActivityBindingModule::class, ApiModule::class, DataManagerModule::class])
interface ApplicationComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

    fun inject(allianzApplication: AllianzApplication)
}