package com.techelevator.farm;

public class Egg implements Sellable{
    @Override
    public String getName() {
        return "brown egg";
    }

    @Override
    public double getPrice() {
        return .5;
    }

    //i can have other things in the class
    private String chickenParent;
    public String getChickenParent(){
        return chickenParent;
    }
    public void setChickenParent(String parent){
        chickenParent = parent;
    }
}
