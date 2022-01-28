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
        for(String item: suits){ //for each suit
            //add a card numbered 1 through 13
            for (int num = 1; num<=13; num++){
                Card card = new Card(item,num);
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
        String returnStr = "Cards Left: "+deck.size()+"\n";
        for(Card card : deck){
            returnStr += card.toString()+"\n";
        }
        return returnStr;
    }

    //want to be able to add a card to the deck, return true if success, false if it was a dup
    public boolean addCardToDeck(Card card){
        boolean addedSuccessfully = false;

        //does the deck of cards already contain the card?
        if (cardInDeck(card)==false){
            //  if no then add the card to the deck and return true
            deck.add(card);
            addedSuccessfully = true;
        }
        //  if yes do nothing bc addedSuccessfully is already false

        return addedSuccessfully;
    }

    private boolean cardInDeck(Card c){
        for (Card card : deck){
            if (c.equals(card))
                return true;
        }
        return false;
    }


}
