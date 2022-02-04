package com.techelevator.interfaceexample;

public class Bicycle implements Sellable, Vehicle{
    private boolean pedaling;
    private double price;

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void go() {
        pedaling = true;
    }

    @Override
    public void speedUp() {
        pedaling = true;
    }

    @Override
    public void slowDown() {
        pedaling = false;
    }

    @Override
    public void stop() {
        pedaling = false;
    }
}
