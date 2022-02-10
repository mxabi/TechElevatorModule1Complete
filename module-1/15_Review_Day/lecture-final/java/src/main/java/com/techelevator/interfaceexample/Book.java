package com.techelevator.interfaceexample;

public class Book implements Readable,Sellable{
    private String allTheText;
    @Override
    public String getText() {
        return allTheText;
    }

    @Override
    public double getPrice() {
        return 5.75;
    }
}
