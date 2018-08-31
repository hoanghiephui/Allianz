package com.allianz.android.di.module

import android.app.Application
import android.app.NotificationManager
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.allianz.android.api.EnvironmentSettings
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class ApplicationModule {
    @Provides
    @Singleton
    internal fun provideApplicationContext(application: Application): Context {
        return application
    }

    @Provides
    @Singleton
    protected fun provideSettings(): EnvironmentSettings {
        return EnvironmentSettings()
    }

    @Provides
    @Singleton
    protected fun provideGson(): Gson {
        return Gson()
    }

    @Provides
    @Singleton
    fun provideNotificationManager(context: Context): NotificationManager {
        return context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    }

    @Provides
    @Singleton
    fun sharedPreferences(context: Context): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(context)
    }
}