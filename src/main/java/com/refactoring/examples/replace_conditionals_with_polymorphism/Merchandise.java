package com.refactoring.examples.replace_conditionals_with_polymorphism;

public class Merchandise {

    private final float basePrice;

    Merchandise(float basePrice) {
        this.basePrice = basePrice;
    }

    public float getBasePrice() {
        return basePrice;
    }
}
