package com.refactoring.examples.replace_conditionals_with_polymorphism.discount;

import com.refactoring.examples.replace_conditionals_with_polymorphism.Client;
import com.refactoring.examples.replace_conditionals_with_polymorphism.Merchandise;

public interface DiscountPolicy {

    boolean isApplicable(Client client);

    float calculate(Merchandise merchandise);

}
