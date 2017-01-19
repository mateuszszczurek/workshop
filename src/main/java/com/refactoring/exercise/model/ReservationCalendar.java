package com.refactoring.exercise.model;

import java.util.List;

public class ReservationCalendar {

    private final List<Reservation> reservations;

    public ReservationCalendar(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }
}
