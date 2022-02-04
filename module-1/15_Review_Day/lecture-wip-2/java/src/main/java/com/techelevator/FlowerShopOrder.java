package com.techelevator;

import java.math.BigDecimal;

public class FlowerShopOrder {
    /*Add a bouquet type, number of roses, and subtotal attribute/property to the Flower Shop Order class:
bouquet type: indicates the type of bouquet.
number of roses: indicates the number of roses added to the bouquet.
subtotal: indicates the order subtotal before shipping by adding $19.99 for the standard bouquet, plus $2.99 for each rose.

     */
    private String bouquetType;
    private int numRoses;

    //subtotal is derived
    public BigDecimal getSubtotal(){
        BigDecimal totalPrice = new BigDecimal("19.99"); //the base price is 19.99
        BigDecimal pricePerRose = new BigDecimal("2.99");
        //then add an additional 2.99 per rose
        if (numRoses > 0) {
            BigDecimal roseAdditionalPrice = pricePerRose.multiply(new BigDecimal(numRoses));
            totalPrice = totalPrice.add(roseAdditionalPrice);
        }
        return totalPrice;
    }
    //Create a constructor that accepts bouquet type and number of roses.
    public FlowerShopOrder(String bouquetType, int numRoses){
        this.bouquetType = bouquetType;
        this.numRoses = numRoses;
    }

    public BigDecimal getDeliveryTotal(boolean sameDayDeliver, String zipCode){
        //delivery total = the delivery fee plus the subtotal
        BigDecimal deliveryFee = getDeliveryFee(sameDayDeliver, zipCode);
        //default is already 19.99 and no same-day
        return deliveryFee.add(getSubtotal());
    }

    //i want to keep things simple - one task per method
    public BigDecimal getDeliveryFee(boolean sameDayDeliver, String zipCode) {
        BigDecimal deliveryFee = new BigDecimal("19.99");//default for all other zip codes
        BigDecimal sameDayFee = new BigDecimal("5.99");

        boolean isOneThousand = zipCode.startsWith("1")&& zipCode.length()==5;
        boolean isTwentyThousand = zipCode.startsWith("2")&& zipCode.length()==5;
        boolean isThirtyThousand = zipCode.startsWith("3")&& zipCode.length()==5;
        if (isTwentyThousand){
            deliveryFee = new BigDecimal("3.99");
            if (sameDayDeliver){
                deliveryFee = deliveryFee.add(sameDayFee);
            }
        } else if (isThirtyThousand){
            deliveryFee = new BigDecimal("6.99");
            if (sameDayDeliver){
                deliveryFee = deliveryFee.add(sameDayFee);
            }
        } else if (isOneThousand){
            deliveryFee = BigDecimal.ZERO; //fee is waived
        }
        return deliveryFee;
    }

    @Override
    public String toString(){
        String str = "ORDER - "+bouquetType+" - "+numRoses+" roses - "+getSubtotal();
        return str;
    }
}
