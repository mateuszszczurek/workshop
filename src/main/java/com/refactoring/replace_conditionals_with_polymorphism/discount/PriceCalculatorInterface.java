package com.refactoring.replace_conditionals_with_polymorphism.discount;

import com.refactoring.replace_conditionals_with_polymorphism.Client;
import com.refactoring.replace_conditionals_with_polymorphism.Merchandise;

public interface PriceCalculatorInterface  {

    float calculatePrice(Client client, Merchandise merchandise);

}
