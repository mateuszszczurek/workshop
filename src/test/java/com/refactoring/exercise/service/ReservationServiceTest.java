package com.refactoring.exercise.service;

import com.refactoring.exercise.model.*;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static java.time.LocalDate.of;
import static java.time.Period.ofDays;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class ReservationServiceTest {

    @Test
    public void should_be_able_to_give_out_reservation_when_none_made_yet() {
        LocalDate reservationStartDate = of(2017, 1, 20);
        LocalDate reservationEndDate = of(2017, 1, 24);

        List<Room> rooms = new ArrayList<>();
        rooms.add(new Room(RoomClass.MODERATE, 3, 1));
        rooms.add(new Room(RoomClass.MODERATE, 3, 2));
        rooms.add(new Room(RoomClass.MODERATE, 3, 3));

        Hotel hotel = new Hotel(rooms, new ReservationCalendar(new ArrayList<>()));

        Guest guest = new Guest("Mateusz", "Szczurek");

        ReservationService reservationService = new ReservationService(hotel);

        Reservation reservation = reservationService.reserveRoom(3, reservationStartDate, reservationEndDate, guest);

        assertThat(reservation).satisfies(reservationWithinDates(reservationStartDate, reservationEndDate));
    }

    @Test
    public void should_fail_to_reserve_when_there_is_no_room_with_desired_size_available() {
        LocalDate reservationStartDate = of(2017, 1, 20);
        LocalDate reservationEndDate = of(2017, 1, 24);

        List<Room> rooms = new ArrayList<>();
        rooms.add(new Room(RoomClass.MODERATE, 3, 1));
        rooms.add(new Room(RoomClass.MODERATE, 4, 2));
        rooms.add(new Room(RoomClass.MODERATE, 5, 3));

        Hotel hotel = new Hotel(rooms, new ReservationCalendar(new ArrayList<>()));

        Guest guest = new Guest("Mateusz", "Szczurek");

        ReservationService reservationService = new ReservationService(hotel);

        Reservation reservation = reservationService.reserveRoom(10, reservationStartDate, reservationEndDate, guest);

        assertThat(reservation).isNull();
    }

    @Test
    public void should_be_able_tell_that_there_are_no_rooms_available() {
        LocalDate reservationStartDate = of(2017, 1, 20);
        LocalDate reservationEndDate = of(2017, 1, 24);

        List<Room> rooms = new ArrayList<>();
        Room room = new Room(RoomClass.MODERATE, 3, 1);
        rooms.add(room);

        List<Reservation> reservations = new ArrayList<>();
        reservations.add(new Reservation(reservationStartDate, reservationEndDate, room, mock(Guest.class)));
        Hotel hotel = new Hotel(rooms, new ReservationCalendar(reservations));

        Guest guest = new Guest("Mateusz", "Szczurek");

        ReservationService reservationService = new ReservationService(hotel);


        Reservation reservation = reservationService.reserveRoom(3, reservationStartDate, reservationEndDate, guest);

        assertThat(reservation).isNull();
    }

    @Test
    public void should_be_able_to_correctly_reserve_room_when_there_is_reservation_in_the_future() {
        LocalDate reservationStartDate = of(2017, 1, 20);
        LocalDate reservationEndDate = of(2017, 1, 24);

        List<Room> rooms = new ArrayList<>();
        Room room = new Room(RoomClass.MODERATE, 3, 1);
        rooms.add(room);

        List<Reservation> reservations = new ArrayList<>();
        reservations.add(new Reservation(reservationStartDate.plus(ofDays(50)), reservationEndDate.plus(ofDays(55)), room, mock(Guest.class)));
        Hotel hotel = new Hotel(rooms, new ReservationCalendar(reservations));

        Guest guest = new Guest("Mateusz", "Szczurek");

        ReservationService reservationService = new ReservationService(hotel);

        Reservation reservation = reservationService.reserveRoom(3, reservationStartDate, reservationEndDate, guest);

        assertThat(reservation).satisfies(reservationWithinDates(reservationStartDate, reservationEndDate));
    }

    @Test
    public void should_be_able_to_book_room_between_two_reservation() {
        LocalDate reservationStartDate = of(2017, 1, 20);
        LocalDate reservationEndDate = of(2017, 1, 24);

        List<Room> rooms = new ArrayList<>();
        Room room = new Room(RoomClass.MODERATE, 3, 1);
        rooms.add(room);

        List<Reservation> reservations = new ArrayList<>();
        reservations.add(new Reservation(reservationStartDate.minus(ofDays(10)), reservationEndDate.minus(ofDays(5)), room, mock(Guest.class)));
        reservations.add(new Reservation(reservationStartDate.plus(ofDays(10)), reservationEndDate.plus(ofDays(15)), room, mock(Guest.class)));
        Hotel hotel = new Hotel(rooms, new ReservationCalendar(reservations));

        Guest guest = new Guest("Mateusz", "Szczurek");

        ReservationService reservationService = new ReservationService(hotel);

        Reservation reservation = reservationService.reserveRoom(3, reservationStartDate, reservationEndDate, guest);

        assertThat(reservation).satisfies(reservationWithinDates(reservationStartDate, reservationEndDate));
    }

    private Consumer<Reservation> reservationWithinDates(LocalDate reservationStartDate, LocalDate reservationEndDate) {
        return expectedReservation -> {
            assertThat(expectedReservation).isNotNull();
            assertThat(expectedReservation.getStartDate()).isEqualTo(reservationStartDate);
            assertThat(expectedReservation.getEndDate()).isEqualTo(reservationEndDate);
        };
    }

}