package com.techelevator;

public class BaseBallPlayer {

    //name, num hits, derived battingAvg, derived batting average as pretty string
    private String name;
    private double battingAvg; //derived
    private int playerAge;
    private int numOfBats;
    private int numOfHits;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //battingAvg is derived property based on numhits/numBats
    public double getBattingAvg() {
        if (numOfBats == 0) {
            return 0;
        } else {
            double battingAvg = numOfHits / numOfBats;
            return battingAvg;
        }
    }

    //batting average returned as String formatted correctly

    public String getPrettyBattingAvg(){
        String pretty = String.format("%.3f", getBattingAvg()); //give me a format the calculated
        return pretty;
    }
    public int getNumOfBats() {
        return numOfBats;
    }

    public void setNumOfBats(int numOfBats) {
        if (numOfBats >= 0) {
            this.numOfBats = numOfBats;
        }
    }
    public int getNumOfHits() {
        return numOfHits;
    }

    public void setNumOfHits(int numOfHits) {
        if (numOfHits >= 0) {
            this.numOfHits = numOfHits;
        }
    }
    //constructor to init all the data
    public BaseBallPlayer (String name, int numOfHits, int numOfBats){
        this.name = name;
        this.numOfHits = numOfHits;
        this.numOfBats = numOfBats;
    }


}
