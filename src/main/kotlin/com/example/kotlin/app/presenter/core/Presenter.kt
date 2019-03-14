package com.example.kotlin.app.presenter.core

import com.example.kotlin.app.model.core.event.IViewLoad
import com.example.kotlin.app.view.core.IView

/**
 * Base class of presenters
 */
abstract class Presenter<T>(protected val view: T) : IPresenter, IViewLoad where T : IView {

    /**
     * The function that going to be executed when the view is loaded
     */
    abstract override fun onLoad()


    override fun present() {
        view.show()
    }

    /**
     * Constructor
     */
    init {
        this.view.eventViewLoadRequest().addListener(this)
    }
}