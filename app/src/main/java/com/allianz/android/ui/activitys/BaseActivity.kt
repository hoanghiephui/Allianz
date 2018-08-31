package com.allianz.android.ui.activitys

import android.arch.lifecycle.ViewModelProvider
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

abstract class BaseActivity : AppCompatActivity(), HasSupportFragmentInjector {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>
    @Inject
    lateinit var sharedPreferences: SharedPreferences

    abstract fun initLayout(): Int

    abstract fun configureLogic(savedInstanceState: Bundle?)

    abstract fun setEvents()

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = dispatchingAndroidInjector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (initLayout() != 0) {
            setContentView(initLayout())
        }
        configureLogic(savedInstanceState)
        setEvents()
    }

}