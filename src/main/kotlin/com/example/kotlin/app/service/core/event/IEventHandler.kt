package com.example.kotlin.app.service.core.event

/**
 * Defines required API for event initiator
 */
interface IEventHandler<T> : IEvent<T> {

    /**
     * Returns list of current event subscribers
     */
    fun getListeners(): List<T>
}