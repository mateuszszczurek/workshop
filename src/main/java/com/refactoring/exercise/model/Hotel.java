package com.refactoring.exercise.model;

import java.util.List;

public class Hotel {

    private final List<Room> rooms;
    private final ReservationCalendar reservationCalendar;

    public Hotel(List<Room> rooms, ReservationCalendar reservationCalendar) {
        this.rooms = rooms;
        this.reservationCalendar = reservationCalendar;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public ReservationCalendar getReservationCalendar() {
        return reservationCalendar;
    }
}
