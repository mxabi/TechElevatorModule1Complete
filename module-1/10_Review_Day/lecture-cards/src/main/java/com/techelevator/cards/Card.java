package com.techelevator.cards;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Card {

    private String suit;
    public String getSuit(){
        return suit;
    }

    private int number;
    public int getNumber(){
        return number;
    }
    //have a map that translates the number to the value
    private static final Map<Integer,String> numToValue =  Map.of(1,"Ace", 11, "Jack",12,"Queen",13,"King");
    //i can declare and instantiate in one line in the class
    //but I cannot have random code floating around the class - everything else must be in a method

    //derived property for the string representation of the number
    public String getValue(){ //this will return Ace for 1, 2 for 2, 3 for 3...Jack for 11; face cards get words
        //look for it in the map of face card mapping
        String value = numToValue.get(number);
        if (value==null){ //if it's not there then it's 2-10 so just return the number
            value = String.valueOf(number);
        }
        return value;

    }

    //color property/variable - related to suit so let's derive it
    public String getColor() {
        if (suit.equals("hearts")|| suit.equals("diamonds")){
            return "red";
        } else {
            return "black";
        }
    }

    //You must know the suit and the number when you create a card
    //constructors are always public, no return value, named the same as the class
    public Card(String suit, int number){
        this.suit = suit.toLowerCase(Locale.ROOT); //set the instance variable suit equal to the parameter that is passed to the constructor
        this.number = number; //i MUST use the this keyword here to refer to the instance variable since the name matches the param
    }

    //to print nicely, make a toString method
    public String toString(){
        return getValue()+" of "+suit;
    }
}
