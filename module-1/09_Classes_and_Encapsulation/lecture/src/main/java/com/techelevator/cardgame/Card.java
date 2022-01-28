package com.techelevator.cardgame;

import java.util.HashMap;
import java.util.Map;

public class Card {


    private String suit;
    // need getter

    public String getSuit(){
        return suit;
    }
    //no setter because we are not changing card after getting

    //have a map that translates number to value

    private static final Map<Integer,String> numToValue = Map.of(1,"Ace", 11,"Jack",12,"Queen",13,"King");


    private int number;

    public int getNumber() {
        return number;
    }

    //derived property for string representation
    //of number

    public String getValue(){
        // this will return Ace for 1, 2 for 2... Jack for 11; face cards get words
        String value =numToValue.get(number);
        if (value == null){
            value = String.valueOf(number);
        }
        return value;
       /*if (number ==1){
            return "Ace";
        } else if (number ==11){
            return "Jack";
        }*/
    }

    public Card(String suit, int number){
        this.suit = suit;
        this.number = number;
    }

    //to print nicely, make it a  toString method
    public String toString(){
        return getValue() + " of " + suit;
    }


}
