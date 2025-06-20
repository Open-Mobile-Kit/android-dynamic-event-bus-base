package com.open_mobile_kit.dynamic_event_bus_base

import android.util.Log

/**
 * A connector class for the DynamicEventBus system that provides a cleaner interface
 * for interacting with the event bus. Uses a builder pattern for configuration.
 */
class DynamicEventBusConnector private constructor(
    private val eventBus: DynamicEventBusInterface,
    private val eventListener: DynamicEventListener?
) {

    companion object {
        private const val TAG = "EventBusConnector"

        /**
         * Create a new builder for configuring a DynamicEventBusConnector
         */
        @JvmStatic
        fun builder(): Builder {
            return Builder()
        }
    }

    init {
        eventListener?.let { eventBus.addEventListener(it) }
    }

    /**
     * Sends an event to all registered listeners
     *
     * @param eventType The type of the event
     * @param eventData The data associated with the event
     */
    fun dispatch(eventType: String, eventData: Any?) {
        eventBus.dispatch(eventType, eventData)
    }

    /**
     * Disconnects from the event bus, unregistering any listeners
     */
    fun disconnect() {
        try {
            eventListener?.let { eventBus.removeEventListener(it) }
        } catch (e: Exception) {
            Log.e(TAG, "Error disconnecting from event bus", e)
        }
    }


    /**
     * Builder class for configuring a DynamicEventBusConnector
     */
    class Builder {
        private var eventBus: DynamicEventBusInterface? = null
        private var eventListener: DynamicEventListener? = null

        /**
         * Set the event bus implementation to use
         */
        fun withEventBus(eventBus: DynamicEventBusInterface): Builder {
            this.eventBus = eventBus
            return this
        }

        /**
         * Set the event listener for receiving events
         */
        fun withEventListener(listener: DynamicEventListener): Builder {
            this.eventListener = listener
            return this
        }

        /**
         * Build the connector with the configured options
         * If no event bus is provided, it will use the default DynamicEventBusInterface singleton
         */
        fun build(): DynamicEventBusConnector {
            val actualEventBus = eventBus
                ?: throw IllegalStateException("DynamicEventBusInterface instance not available")

            return DynamicEventBusConnector(actualEventBus, eventListener)
        }
    }
}
