package com.techelevator.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeckOfCards {

   //should this be a queue instead since you can only deal from one side?
    private List<Card> deck = new ArrayList<>();

    //set the deck - initialize the deck of cards
    public DeckOfCards(){
        //create all 52 cards and add them to the deck
        String[] suits = {"hearts","diamonds","spades","clubs"};
        for(String suit: suits){ //for each suit
            //add a card numbered 1 through 13
            for (int num = 1; num<=13; num++){
                Card card = new Card(suit,num);
                deck.add(card);
            }
        }
        shuffle();
    }

    //shuffle the deck
    public void shuffle(){
        Collections.shuffle(deck);
    }

    public Card dealOne(){
        //take a card from the deck
        // remove the card from the deck
        // and return it
        Card dealIt = deck.get(0);
        deck.remove(0);
        return dealIt;
    }

    public String toString(){
        String returnStr = "";
        for(Card card : deck){
            returnStr += card.toString()+"\n";
        }
        return returnStr;
    }


}
