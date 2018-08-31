package com.allianz.android.ui.fragments

import android.arch.lifecycle.ViewModelProviders
import android.view.View
import com.allianz.android.R
import com.allianz.android.viewmodel.HomeViewModel

class HomeFragment : BaseFragment() {
    private val viewModel: HomeViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory)
                .get(HomeViewModel::class.java)
    }

    override fun initLayout() =
            R.layout.fragment_home

    override fun initView(view: View) {
        viewModel.getMovies()
    }

    override fun configureLogic() {
    }

    override fun configureViewModel() {
    }

    override fun onDestroyViews() {
    }
}