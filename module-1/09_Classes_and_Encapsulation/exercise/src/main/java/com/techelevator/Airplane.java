package com.techelevator;

public class Airplane {

    //Instance Variables
    private String planeNumber;
    private int totalFirstClassSeats;
    private int bookedFirstClassSeats;
    private int availableFirstClassSeats; //derived
    private int totalCoachSeats;
    private int bookedCoachSeats;
    private int availableCoachSeats;  //derived

    //Getters and Setters


    public String getPlaneNumber() {
        return planeNumber;
    }

    public int getTotalCoachSeats() {
        return totalCoachSeats;
    }

    public int getAvailableCoachSeats() {
        int availableCoachSeats = totalCoachSeats - bookedCoachSeats;
        return availableCoachSeats;
    }

    public int getBookedCoachSeats() {
        return bookedCoachSeats;
    }

    public int getBookedFirstClassSeats() {
        return bookedFirstClassSeats;
    }

    public int getAvailableFirstClassSeats() {
        //derived by subtracting totalFirstClassSeats -
        //bookedFirstClassSeats
        int availableFirstClassSeats = totalFirstClassSeats - bookedFirstClassSeats;
        return availableFirstClassSeats;
    }

    public int getTotalFirstClassSeats() {
        return totalFirstClassSeats;
    }

    public Airplane(String planeNumber, int totalFirstClassSeats, int totalCoachSeats) {
        this.planeNumber = planeNumber;
        this.totalCoachSeats = totalCoachSeats;
        this.totalFirstClassSeats = totalFirstClassSeats;
    }

    public boolean reserveSeats(boolean forFirstClass, int totalNumberOfSeats) {
        /*
        if (forFirstClass == true) {
            if (totalNumberOfSeats < totalFirstClassSeats)
                this.bookedFirstClassSeats += totalNumberOfSeats;
            return true;
        }
        if (totalNumberOfSeats < totalCoachSeats) {
            this.bookedCoachSeats += totalNumberOfSeats;
            return true;
        }
        return false;
    }
         */
        if (forFirstClass == false) {
            if (totalNumberOfSeats < totalCoachSeats) {
                this.bookedCoachSeats = totalNumberOfSeats;
                return true;
            }
        }
        if (forFirstClass == true) {
            if (totalNumberOfSeats < totalFirstClassSeats) {
                this.bookedFirstClassSeats = totalNumberOfSeats;
                return true;
            }

        }

        return false;
    }
}
