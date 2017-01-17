package com.refactoring.replace_conditionals_with_polymorphism.discount;

import com.refactoring.replace_conditionals_with_polymorphism.Client;
import com.refactoring.replace_conditionals_with_polymorphism.Merchandise;

public class SeasonalCustomerPolicy implements DiscountPolicy {

    public boolean isApplicable(Client client) {
        return client.getAmountOfGoodsBought() > 50 && client.getAmountOfGoodsBought() <= 100;
    }

    public float calculate(Merchandise merchandise) {
        return merchandise.getBasePrice() * 0.8f;
    }
}
