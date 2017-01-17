package com.refactoring.replace_conditionals_with_polymorphism;

public class Client {

    private final String name;
    private final int amountOfGoodsBought;

    Client(String name, int amountOfGoodsBought) {
        this.name = name;
        this.amountOfGoodsBought = amountOfGoodsBought;
    }

    public int getAmountOfGoodsBought() {
        return amountOfGoodsBought;
    }

    public String getClientName() {
        return name;
    }
}
