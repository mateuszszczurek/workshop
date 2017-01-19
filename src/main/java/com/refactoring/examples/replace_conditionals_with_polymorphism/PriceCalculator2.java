package com.refactoring.examples.replace_conditionals_with_polymorphism;

import com.refactoring.examples.replace_conditionals_with_polymorphism.discount.DiscountPolicy;
import com.refactoring.examples.replace_conditionals_with_polymorphism.discount.PriceCalculatorInterface;

import java.util.List;

public class PriceCalculator2 implements PriceCalculatorInterface {

    private final List<DiscountPolicy> discountPolicies;

    public PriceCalculator2(List<DiscountPolicy> discountPolicies) {
        this.discountPolicies = discountPolicies;
    }

    public float calculatePrice(Client client, Merchandise merchandise) {

        for (DiscountPolicy discountPolicy : discountPolicies) {
            if (discountPolicy.isApplicable(client)) {
                return discountPolicy.calculate(merchandise);
            }
        }

        return merchandise.getBasePrice();

    }

}