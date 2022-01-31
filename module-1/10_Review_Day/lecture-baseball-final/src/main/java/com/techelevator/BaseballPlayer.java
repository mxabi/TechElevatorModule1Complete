package com.techelevator;

public class BaseballPlayer {
    //name, num hits, num at bats, derived batting average, derived batting average as a pretty string .001

    private String name;
    public String getName(){return name;}
    public void setName(String name){this.name = name;}

    private int numHits;
    public int getNumHits(){return numHits;}
    public void setNumHits(int numHits){
        if (numHits >= 0) {
            this.numHits = numHits;
        }
    }

    private int numAtBats;
    public int getNumAtBats(){return numAtBats;}
    public void setNumAtBats(int numAtBats){
        if (numAtBats >=0) {
            this.numAtBats = numAtBats;
        }
    }

    //batting average is derived based on the number of hits / number of at bats
    public double getBattingAverage(){
        //make sure we don't divide by zero!
        if (numAtBats==0){
            return 0;
        } else {
            return (double) numHits / numAtBats;
        }
    }

    //batting average returned as a string formatted correctly
    public String getPrettyBattingAverage(){
        String pretty = String.format("%.3f",getBattingAverage());//format the calculated battign average as a string with 3 decimal places
        return pretty;
    }

    //construtor to init all the data
    public BaseballPlayer(String name, int numAtBats, int numHits){
        this.name = name;
        this.numAtBats = numAtBats;
        this.numHits = numHits;
    }

}
