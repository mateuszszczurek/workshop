package com.refactoring.examples.replace_conditionals_with_polymorphism;

import com.refactoring.examples.replace_conditionals_with_polymorphism.discount.*;

import java.util.ArrayList;
import java.util.List;

// Price Calculator:
// 30% discount if bought over 100 goods
// 20% discount if bought over 50 up to 100 goods
// 10% discount if bought from 10 to 50 goods

public class Main {


    public static void main(String[] args) {

        PriceCalculatorInterface priceCalculator1 = new PriceCalculator();

        List<DiscountPolicy> discountPolicies = new ArrayList<DiscountPolicy>();

        discountPolicies.add((new LoyalCustomerPolicy()));
        discountPolicies.add((new SeasonalCustomerPolicy()));
        discountPolicies.add((new NewCustomerPolicy()));
        PriceCalculatorInterface priceCalculator2= new PriceCalculator2(discountPolicies);

        PriceCalculatorInterface priceCalculator3 = new PriceCalculator3(discountPolicies);

        calculateUsingDifferentCalculators(priceCalculator1, priceCalculator2, priceCalculator3);

    }

    private static void calculateUsingDifferentCalculators(PriceCalculatorInterface ... calculators) {
        Merchandise merchandise = new Merchandise(100);
        Client loyalClient = new Client("John", 123);
        Client seasonalClient = new Client("Chris", 78);
        Client newClient = new Client("Danny", 21);
        Client rareClient = new Client("Ronny", 5);

        for (PriceCalculatorInterface calculator : calculators) {
            logSeparatorLine();
            checkDiscount(calculator, merchandise, loyalClient, seasonalClient, newClient, rareClient);
        }

    }

    private static void logSeparatorLine() {
        System.out.println("---------------");
    }

    private static void checkDiscount(PriceCalculatorInterface priceCalculator, Merchandise merchandise, Client... clients) {
        for (Client client : clients) {
            float priceAfterDiscount = priceCalculator.calculatePrice(client, merchandise);

            System.out.println(String.format("Price after discount %.2f USD for %s", priceAfterDiscount, client.getClientName()));
        }
    }

}
