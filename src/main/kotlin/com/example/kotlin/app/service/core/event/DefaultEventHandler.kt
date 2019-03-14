package com.example.kotlin.app.service.core.event

/**
 * Default implementation of event system
 */
class DefaultEventHandler<T> : IEventHandler<T> {

    private val subscribers: HashSet<T> = hashSetOf()


    override fun getListeners(): List<T> = subscribers.toList()

    override fun addListener(listener: T): Unit {
        subscribers.add(listener)
    }

    override fun removeListener(listener: T): Unit {
        subscribers.remove(listener)
    }
}