package com.refactoring.examples.tell_dont_ask;

public class AskCar {

    private int currentSpeed;
    private int maxSpeed;

    public AskCar(int maxSpeed) {
        this.currentSpeed = 0;
        this.maxSpeed = maxSpeed;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(int currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

}
