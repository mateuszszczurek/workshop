package com.refactoring.replace_conditionals_with_polymorphism;

import com.refactoring.replace_conditionals_with_polymorphism.discount.PriceCalculatorInterface;

public class PriceCalculator implements PriceCalculatorInterface{

    public float calculatePrice(Client client, Merchandise merchandise) {

        int amountOfGoodsBought = client.getAmountOfGoodsBought();

        float price = merchandise.getBasePrice();

        if (amountOfGoodsBought > 100) {
            price *= (1 - 0.3);
        } else if (amountOfGoodsBought > 50 && amountOfGoodsBought <= 100) {
            price *= (1 - 0.2);
        } else if (amountOfGoodsBought > 10 && amountOfGoodsBought <= 50) {
            price *= (1 - 0.1);
        }

        return price;

    }

}
