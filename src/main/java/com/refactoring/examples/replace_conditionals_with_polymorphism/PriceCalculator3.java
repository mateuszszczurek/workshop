package com.refactoring.examples.replace_conditionals_with_polymorphism;

import com.refactoring.examples.replace_conditionals_with_polymorphism.discount.DiscountPolicy;
import com.refactoring.examples.replace_conditionals_with_polymorphism.discount.PriceCalculatorInterface;

import java.util.List;
import java.util.Optional;

public class PriceCalculator3 implements PriceCalculatorInterface {

    private final List<DiscountPolicy> discountPolicies;

    public PriceCalculator3(List<DiscountPolicy> discountPolicies) {
        this.discountPolicies = discountPolicies;
    }

    public float calculatePrice(final Client client, Merchandise merchandise) {

        Optional<DiscountPolicy> discountCalculator = discountPolicies
                .stream()
                .filter(discountPolicy -> discountPolicy.isApplicable(client))
                .findFirst();

        if(!discountCalculator.isPresent()) {
            return merchandise.getBasePrice();
        }

        return discountCalculator.get().calculate(merchandise);

    }

}