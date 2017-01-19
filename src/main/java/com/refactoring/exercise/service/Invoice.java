package com.refactoring.exercise.service;

import com.refactoring.exercise.model.Guest;

import java.math.BigDecimal;

public class Invoice {

    private final Guest guest;
    private final BigDecimal paymentAmount;

    public Invoice(Guest guest, BigDecimal paymentAmount) {
        this.guest = guest;
        this.paymentAmount = paymentAmount;
    }

    public Guest getGuest() {
        return guest;
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

}
