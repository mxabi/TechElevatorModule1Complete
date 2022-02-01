package com.techelevator.farm;

public class Tractor implements Singable,Sellable{
    @Override
    public String getName() {
        return "Tractor";
    }

    @Override
    public double getPrice() {
        return 10000;
    }

    @Override
    public String getSound() {
        return "Vroom";
    }
}
