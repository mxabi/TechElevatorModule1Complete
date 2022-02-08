package com.techelevator;

import java.math.BigDecimal;

public class FlowerShopOrder {

    private String boquetType;
    private int numRoses;


    //subtotal is derived

    public BigDecimal getSubtotal(){
        BigDecimal totalRose = new BigDecimal(19.99);
        BigDecimal pricePerRose = new BigDecimal(2.99);
        for (int countRose = 0; countRose < numRoses; countRose++){
            totalRose = totalRose.add(pricePerRose);
        } return totalRose;
    }

    //constructor

    public FlowerShopOrder(String boquetType, int numRoses){
        this.boquetType = boquetType;
        this.numRoses = numRoses;
    }


}
