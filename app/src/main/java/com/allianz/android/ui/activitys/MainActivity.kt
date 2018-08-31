package com.allianz.android.ui.activitys

import android.os.Bundle
import com.allianz.android.R
import com.allianz.android.ktextensions.replaceFragment
import com.allianz.android.ui.fragments.HomeFragment

class MainActivity : BaseActivity() {

    override fun initLayout() =
            R.layout.activity_main

    override fun configureLogic(savedInstanceState: Bundle?) {
        replaceFragment(HomeFragment(), R.id.container, null)
    }

    override fun setEvents() {
    }
}
