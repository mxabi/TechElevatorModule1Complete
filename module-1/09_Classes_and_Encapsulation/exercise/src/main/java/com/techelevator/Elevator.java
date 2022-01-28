package com.techelevator;

public class Elevator {

    private int currentFloor =1;
    private int numberOfFloors;
    private boolean doorOpen;

    public int getCurrentFloor() {
        return currentFloor;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public boolean isDoorOpen() {
        return doorOpen;
    }

    public Elevator(int totalNumberofFloors){
        this.numberOfFloors = totalNumberofFloors;
       // will tell us how many floors are available to elevator

    }

    public void openDoor(){
        doorOpen = true;
    }

    public void closeDoor(){
        doorOpen = false;
    }

    public void goUp (int desiredFloor){
        if (doorOpen == false){
            if (desiredFloor >= currentFloor && desiredFloor <= numberOfFloors){
                currentFloor = desiredFloor;
            }
        }
    }

    public void goDown(int desiredFloor){
        if (doorOpen == false){
            if (desiredFloor <= currentFloor && desiredFloor >0){
                currentFloor = desiredFloor;
            }
        }

    }
}
