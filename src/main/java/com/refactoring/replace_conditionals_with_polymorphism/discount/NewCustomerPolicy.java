package com.refactoring.replace_conditionals_with_polymorphism.discount;

import com.refactoring.replace_conditionals_with_polymorphism.Client;
import com.refactoring.replace_conditionals_with_polymorphism.Merchandise;

public class NewCustomerPolicy implements DiscountPolicy {

    public boolean isApplicable(Client client) {
        return client.getAmountOfGoodsBought() > 10 && client.getAmountOfGoodsBought() < 50;
    }

    public float calculate(Merchandise merchandise) {
        return merchandise.getBasePrice() * 0.9f;
    }
}
