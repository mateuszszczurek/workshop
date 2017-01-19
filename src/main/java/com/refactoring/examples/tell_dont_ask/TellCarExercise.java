package com.refactoring.examples.tell_dont_ask;

public class TellCarExercise {

    public static void main(String[] args) {

        TellCar tellCar = new TellCar(100);

        for(int i = 0; i < 11 ; i++) {
            tellCar.speedUp(10);
        }
    }

}
