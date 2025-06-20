package com.open_mobile_kit.dynamic_event_bus.base

/**
 * Interface defining the core functionality of the DynamicEventBus system.
 * This allows for easier mocking in tests and alternative implementations.
 */
interface DynamicEventBusInterface {
    /**
     * Register a listener to receive events
     */
    fun addEventListener(listener: DynamicEventListener)

    /**
     * Unregister a previously registered listener
     */
    fun removeEventListener(listener: DynamicEventListener)

    /**
     * Dispatches an event with type and data to all registered listeners
     */
    fun dispatch(eventType: String, eventData: Any?)
}


/**
 * Interface for classes that want to listen to events from DynamicEventBusPlugin
 */
interface DynamicEventListener {
    fun onEventReceived(eventType: String, eventData: Any?)
}
