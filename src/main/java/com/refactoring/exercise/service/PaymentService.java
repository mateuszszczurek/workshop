package com.refactoring.exercise.service;

import com.refactoring.exercise.model.Guest;
import com.refactoring.exercise.model.Room;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PaymentService {

    public int calculatePayment(Room room, Guest client, LocalDate startDate, LocalDate endDate) {


        double rateForDate;
        float baseRate = 50;

        switch (room.getRoomClass()) {
            case BUDGET:
                rateForDate = 0.9 * room.getRoomSize() * baseRate;
                break;
            case LUXURY:
                rateForDate = 1.2 * room.getRoomSize() * baseRate;
                break;
            case MODERATE:
                rateForDate = 1 * room.getRoomNumber() * baseRate;
        }

        long between = ChronoUnit.DAYS.between(startDate, endDate);

        return 0;
    }

}
