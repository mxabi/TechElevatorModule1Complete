package com.techelevator.cardgame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeckOfCards {

    //Crate 52 cards and have them in the deck
    //What instance variables
    //How should we store the cards?
    //List, Array

    private List<Card> deck = new ArrayList<>();

    //set the deck of cards - initialize the deck of cards
    //constructor

    public DeckOfCards() {
        //create all 52 cards & add them to the deck
        //instance variable : has a relationship
        //a deck of cards has a list of cards
        //a student has a number
        //a student has a birthday, lastname,firstname

        String[] suits = {"hearts", "diamonds", "spades", "clubs"};
        for (String suit : suits) {
            for (int num = 1; num <= 13; num++) {
                Card card = new Card(suit, num);
                deck.add(card);
            }
        }
    }

    //shuffle the deck
    public void shuffle(){
        Collections.shuffle(deck);
    }

    public Card dealOne(){
        //take a card from the deck
        //
        Card dealIT = deck.get(0);
        deck.remove(0);
        return dealIT;
    }

    //to print deck of cards
    public String toString(){
        String returnStr = "";
        for (Card card: deck){
            returnStr += card.toString()+ "\n";
        }
        return returnStr;
    }
}
