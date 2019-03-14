package com.example.kotlin.app.service.core.event

import org.junit.Assert
import org.junit.Test
import kotlin.test.assertEquals

class DefaultEventHandlerTest {

    /**
     * Custom event structure defined for test
     */
    interface ICustomEvent {


        fun onEventFired(eventValue: Int)
    }

    class Subscriber(val event: IEvent<ICustomEvent>, var value: Int) : ICustomEvent {

        override fun onEventFired(eventValue: Int) {
            value = eventValue
        }

        init {
            event.addListener(this)
        }

    }

    @Test
    fun getListeners() {

        // Create event handler akka initiator
        val eventInitiator: IEventHandler<ICustomEvent> = DefaultEventHandler()
        val eventHandler: IEvent<ICustomEvent> = eventInitiator

        // Create subscribers
        val listeners = Array(5) {
            Subscriber(eventHandler, it)
        }

        // Fire the event
        eventInitiator.getListeners().forEachIndexed { index, event ->
            event.onEventFired((index + 1) * 10)
        }


        Assert.assertArrayEquals(arrayOf(10, 20, 30, 40, 50), listeners.map { it.value }.sorted().toTypedArray())


    }

    @Test
    fun addListener() {

        // Create event handler akka initiator
        val eventInitiator: IEventHandler<ICustomEvent> = DefaultEventHandler()
        val eventHandler: IEvent<ICustomEvent> = eventInitiator

        // Create subscribers
        val listeners = Array(5) {
            Subscriber(eventHandler, it)
        }

        assertEquals(5, listeners.size)
        Assert.assertArrayEquals(arrayOf(0, 1, 2, 3, 4), listeners.map { it.value }.sorted().toTypedArray())
    }

    @Test
    fun removeListener() {

        // Create event handler akka initiator
        val eventInitiator: IEventHandler<ICustomEvent> = DefaultEventHandler()
        val eventHandler: IEvent<ICustomEvent> = eventInitiator

        // Create subscribers
        val listeners = Array(5) {
            Subscriber(eventHandler, it)
        }



        eventHandler.removeListener(listeners.last())


        assertEquals(4, eventInitiator.getListeners().size)

        for (l in eventInitiator.getListeners()) {
            eventHandler.removeListener(l)
        }

        assertEquals(0, eventInitiator.getListeners().size)

        eventInitiator.getListeners().forEach { it.onEventFired(100) }

        Assert.assertArrayEquals(arrayOf(0, 1, 2, 3, 4), listeners.map { it.value }.sorted().toTypedArray())


    }
}