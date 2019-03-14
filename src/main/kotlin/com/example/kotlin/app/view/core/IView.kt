package com.example.kotlin.app.view.core

import com.example.kotlin.app.model.core.event.IViewLoad
import com.example.kotlin.app.service.core.event.IEvent

/**
 * Base interface of views
 */
interface IView {
    /**
     * View load event
     */
    fun eventViewLoadRequest(): IEvent<IViewLoad>

    /**
     * Show the view
     */
    fun show()
}