package com.techelevator.farm;

public class Goose extends FarmAnimal {

    public Goose(){
        super("Goose");
    }
    @Override
    public String getSound(){
        return "Honk";
    }
}
