package com.refactoring.exercise.model;

public class Room {

    private final RoomClass roomClass;
    private final int roomSize;
    private int roomNumber;

    public Room(RoomClass roomClass, int roomSize, int roomNumber) {
        this.roomClass = roomClass;
        this.roomSize = roomSize;
        this.roomNumber = roomNumber;
    }

    public RoomClass getRoomClass() {
        return roomClass;
    }

    public int getRoomSize() {
        return roomSize;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomClass=" + roomClass +
                ", roomSize=" + roomSize +
                '}';
    }
}
