package com.refactoring.tell_dont_ask;

public class TellCar {

    private int currentSpeed;
    private final int maxSpeed;

    public TellCar(int maxSpeed) {
        this.currentSpeed = 0;
        this.maxSpeed = maxSpeed;
    }

    public void speedUp(int byWhatAmount) {
        int desiredSpeed = currentSpeed + byWhatAmount;

        if(desiredSpeed > maxSpeed) {
            System.out.println(String.format("Can't accelerate to %d, maximum speed is %d", desiredSpeed, maxSpeed));
            return;
        }

        System.out.println(String.format("Sppeding up to %d", desiredSpeed));

        this.currentSpeed = desiredSpeed;
    }

}
