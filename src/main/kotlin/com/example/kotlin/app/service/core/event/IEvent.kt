package com.example.kotlin.app.service.core.event

/**
 * Defines required API for event subscribers
 */
interface IEvent<T> {

    /**
     * Add [listener] to the event queue
     */
    fun addListener(listener: T)

    /**
     * Remove [listener] from event queue
     */
    fun removeListener(listener: T)
}