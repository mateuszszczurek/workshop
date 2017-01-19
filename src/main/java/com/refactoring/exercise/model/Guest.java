package com.refactoring.exercise.model;

public class Guest {

    private final String name;
    private final String lastName;

    public Guest(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

}
