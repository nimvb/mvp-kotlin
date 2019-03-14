package com.example.kotlin.app.view.core

import com.example.kotlin.app.model.core.event.IViewLoad
import com.example.kotlin.app.service.core.event.DefaultEventHandler
import com.example.kotlin.app.service.core.event.IEvent
import com.example.kotlin.app.service.core.event.IEventHandler

abstract class View : IView {

    private val viewLoadEvent: IEventHandler<IViewLoad> = DefaultEventHandler()

    override fun eventViewLoadRequest(): IEvent<IViewLoad> = viewLoadEvent

    override fun show() {
        viewLoadEvent.getListeners().forEach { it.onLoad() }
        load()
    }

    abstract fun load()
}