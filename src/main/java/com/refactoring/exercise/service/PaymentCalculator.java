package com.refactoring.exercise.service;

import com.refactoring.exercise.model.Guest;
import com.refactoring.exercise.model.Room;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PaymentCalculator {

    public Invoice calculatePayment(Room room, Guest guest, LocalDate startDate, LocalDate endDate) {


        double rateForDate;
        double baseRate = 50;

        int roomSize = room.getRoomSize();

        switch (room.getRoomClass()) {
            case BUDGET:
                rateForDate = 0.9 * roomSize * baseRate;
                break;
            case LUXURY:
                rateForDate = 1.2 * roomSize * baseRate;
                break;
            case MODERATE:
                rateForDate = 1 * roomSize * baseRate;
                break;
            default:
                throw new RuntimeException();
        }

        long amountOfDays = ChronoUnit.DAYS.between(startDate, endDate);

        return new Invoice(guest, BigDecimal.valueOf(rateForDate * amountOfDays));
    }

}
