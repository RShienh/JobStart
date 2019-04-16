package com.humber.jobstart.Models;

/**
 * The type Events.
 * A Model class with getter and setters
 */
public class Events {
    private String eventDate, eventDetails ;

    /**
     * Instantiates a new Events.
     * empty constructor
     */
    public Events() {
    }

    /**
     * Instantiates a new Events.
     *
     * @param eventDate    the event date
     * @param eventDetails the event details
     */
    public Events(String eventDate, String eventDetails) {
        this.eventDate = eventDate;
        this.eventDetails = eventDetails;
    }

    /**
     * Gets event date.
     *
     * @return the event date
     */
    public String getEventDate() {
        return eventDate;
    }

    /**
     * Sets event date.
     *
     * @param eventDate the event date
     */
    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    /**
     * Gets event details.
     *
     * @return the event details
     */
    public String getEventDetails() {
        return eventDetails;
    }

    /**
     * Sets event details.
     *
     * @param eventDetails the event details
     */
    public void setEventDetails(String eventDetails) {
        this.eventDetails = eventDetails;
    }
}
