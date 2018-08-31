package com.allianz.android.ui.fragments

import android.arch.lifecycle.ViewModelProvider
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.allianz.android.di.Injectable
import javax.inject.Inject

abstract class BaseFragment : Fragment(), Injectable {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(initLayout(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        this.configureLogic()
        this.configureViewModel()
    }

    override fun onDestroyView() {
        onDestroyViews()
        super.onDestroyView()
    }

    /**
     * @method add id layout to view
     * @return [Int] id layout
     */
    abstract fun initLayout(): Int

    /**
     * @method init view
     * @param view
     */
    abstract fun initView(view: View)

    /**
     * @method config dagger
     */
    abstract fun configureLogic()

    /**
     * @method config view model
     */
    abstract fun configureViewModel()

    abstract fun onDestroyViews()
}