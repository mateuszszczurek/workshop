package com.refactoring.examples.replace_conditionals_with_polymorphism.discount;

import com.refactoring.examples.replace_conditionals_with_polymorphism.Client;
import com.refactoring.examples.replace_conditionals_with_polymorphism.Merchandise;

public class LoyalCustomerPolicy implements DiscountPolicy {

    public boolean isApplicable(Client client) {
        return client.getAmountOfGoodsBought() > 100;
    }

    public float calculate(Merchandise merchandise) {
        return merchandise.getBasePrice() * 0.7f;
    }

}
