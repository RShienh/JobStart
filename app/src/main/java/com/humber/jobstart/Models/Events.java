package com.humber.jobstart.Models;

public class Events {
    private String eventDate, eventDetails ;

    public Events() {
    }

    public Events(String eventDate, String eventDetails) {
        this.eventDate = eventDate;
        this.eventDetails = eventDetails;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventDetails() {
        return eventDetails;
    }

    public void setEventDetails(String eventDetails) {
        this.eventDetails = eventDetails;
    }
}
