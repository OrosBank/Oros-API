package org.apache.fineract.utils;

import java.util.List;

/**
 * Holds information related to the timeline of an entity.
 */
public final class Timeline {

    private List<Event> events;

    /**
     * Returns the list of events.
     */
    public List<Event> getEvents() {
        return events;
    }

    /**
     * Sets the list of events.
     * @param events the list of events
     */
    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
