package com.refactoring.exercise.service;

import com.refactoring.exercise.model.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

public class ReservationService {

    private final Hotel hotel;

    public ReservationService(Hotel hotel) {
        this.hotel = hotel;
    }

    public Reservation reserveRoom(int size, LocalDate firstDate, LocalDate secondDate, Guest guest) {
        Reservation reservation = null;
        List<Room> roomList1 = hotel.getRooms();
        List<Room> roomList2 = roomList1.stream().filter(room -> room.getRoomSize() == size).collect(toList());
        for (Room room : roomList2) {
            ReservationCalendar reservationCalendar = hotel.getReservationCalendar();
            List<Reservation> reservationList3 = reservationCalendar.getReservations();
            List<Reservation> reservationList4 = reservationList3.stream().filter(existingReservations -> existingReservations.getRoom().getRoomNumber() == room.getRoomNumber()).collect(toList());
            Optional<Reservation> first1 = reservationList4.stream().filter(reservation1 -> {
                LocalDate start = reservation1.getStartDate();
                LocalDate end = reservation1.getEndDate();
                return !(secondDate.isBefore(start) || firstDate.isAfter(end));
            }).findFirst();

            if (!first1.isPresent()) {
                return new Reservation(firstDate, secondDate, room, guest);
            } else {
                continue;
            }
        }
        return reservation;

    }

}
