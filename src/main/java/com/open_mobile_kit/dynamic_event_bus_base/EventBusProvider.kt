package com.open_mobile_kit.dynamic_event_bus_base

/**
 * Singleton provider for the event bus.
 * This allows setting the event bus before starting the MainActivity,
 * and the MainActivity can retrieve it when created.
 */
object EventBusProvider {
    private var instance: DynamicEventBusInterface? = null

    /**
     * Set the event bus instance to be used by MainActivity
     */
    fun setEventBus(eventBus: DynamicEventBusInterface) {
        instance = eventBus
    }

    /**
     * Get the current event bus instance, if available
     */
    fun getEventBus(): DynamicEventBusInterface? {
        return instance
    }
}