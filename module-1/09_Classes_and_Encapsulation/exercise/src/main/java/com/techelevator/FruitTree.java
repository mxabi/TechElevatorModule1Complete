package com.techelevator;

public class FruitTree {

    //Create Instance Variables
    public String typeOfFruit;
    public int piecesOfFruitLeft;

    //Create getters and setters for instance variables

    public int getPiecesOfFruitLeft() {
        return piecesOfFruitLeft;
    }

    public String getTypeOfFruit() {
        return typeOfFruit;
    }

    //Create constructor
    public FruitTree(String typeOfFruit, int piecesOfFruitLeft){
        this.piecesOfFruitLeft = piecesOfFruitLeft;
        this.typeOfFruit = typeOfFruit;
    }

    public boolean pickFruit ( int numberOfPiecesToRemove){
        int fruitleft = piecesOfFruitLeft - numberOfPiecesToRemove;
        if (fruitleft >=0){
            this.piecesOfFruitLeft =fruitleft;
            return true;
        }
        this.piecesOfFruitLeft = 0;
        return false;
    }
}
