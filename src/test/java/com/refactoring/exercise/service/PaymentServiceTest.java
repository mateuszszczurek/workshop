package com.refactoring.exercise.service;

import org.junit.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class PaymentServiceTest {

    @Test
    public void checking_how_chrono_unit_works() {

        LocalDate startDate = LocalDate.of(2017, 1, 10);
        LocalDate endDate = LocalDate.of(2018, 2, 20);

        long between = ChronoUnit.DAYS.between(startDate, endDate);

        assertThat(between).isEqualTo(406);
    }

}