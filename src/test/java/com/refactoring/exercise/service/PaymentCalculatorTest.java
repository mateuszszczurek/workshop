package com.refactoring.exercise.service;

import com.refactoring.exercise.model.Guest;
import com.refactoring.exercise.model.Room;
import com.refactoring.exercise.model.RoomClass;
import org.junit.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static java.math.BigDecimal.valueOf;
import static java.time.LocalDate.of;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class PaymentCalculatorTest {

    LocalDate reservationStartDate = of(2017, 1, 10);
    LocalDate reservationStartEnd = of(2017, 1, 15);

    Guest guest = mock(Guest.class);

    PaymentCalculator paymentCalculator = new PaymentCalculator();

    @Test
    public void checking_how_chrono_unit_works() {

        LocalDate startDate = of(2017, 1, 10);
        LocalDate endDate = of(2018, 2, 20);

        long between = ChronoUnit.DAYS.between(startDate, endDate);

        assertThat(between).isEqualTo(406);
    }

    @Test
    public void should_be_able_to_calculate_price_for_luxury_room() {
        Room room = room(RoomClass.LUXURY);

        Invoice invoice = paymentCalculator.calculatePayment(room, guest, reservationStartDate, reservationStartEnd);

        assertThat(invoice.getPaymentAmount()).isEqualTo(valueOf(1200.0));
    }

    @Test
    public void should_be_able_to_calculate_price_for_moderate_room() {
        Room room = room(RoomClass.MODERATE);

        Invoice invoice = paymentCalculator.calculatePayment(room, guest, reservationStartDate, reservationStartEnd);

        assertThat(invoice.getPaymentAmount()).isEqualTo(valueOf(1000.0));
    }

    @Test
    public void should_be_able_to_calculate_price_for_budget_room() {
        Room room = room(RoomClass.BUDGET);

        Invoice invoice = paymentCalculator.calculatePayment(room, guest, reservationStartDate, reservationStartEnd);

        assertThat(invoice.getPaymentAmount()).isEqualTo(valueOf(900.0));
    }

    private Room room(RoomClass roomClass) {
        return new Room(roomClass, 4, 1);
    }

}