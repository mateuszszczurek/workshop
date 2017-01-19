package com.refactoring.exercise.model;

import java.time.LocalDate;

public class Reservation {

    private final LocalDate startDate;
    private final LocalDate endDate;
    private final Room room;
    private final Guest guest;

    public Reservation(LocalDate startDate, LocalDate endDate, Room room, Guest guest) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.room = room;
        this.guest = guest;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Guest getGuest() {
        return guest;
    }

    public Room getRoom() {
        return room;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", room=" + room +
                ", guest=" + guest +
                '}';
    }
}
