package com.refactoring.tell_dont_ask;

public class AskCarExercise {

    public static void main(String[] args) {
        AskCar car = new AskCar(100);

        for (; ; ) {

            int currentSpeed = car.getCurrentSpeed();

            speedUp(car, 10);

            if (car.getCurrentSpeed() > car.getMaxSpeed()) {
                System.out.println("Too much speed! Engine broke...");
                return;
            }

        }
    }

    private static void speedUp(AskCar car, int speedUpBy) {
        int desiredSpeed = car.getCurrentSpeed() + speedUpBy;
        System.out.println(String.format("Speeding up to %d km/h", desiredSpeed));
        car.setCurrentSpeed(desiredSpeed);
    }

}
