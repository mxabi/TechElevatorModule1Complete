package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class FlowerShopOrderTest {

    @Test
    public void test_flower_shop_order_subtotal(){
        FlowerShopOrder testOrder = new FlowerShopOrder("idk",0);
        BigDecimal expectedResult = new BigDecimal("19.99");
        Assert.assertEquals("an order with no roses is 19.99",expectedResult,testOrder.getSubtotal());

        testOrder = new FlowerShopOrder("idk",10);
        expectedResult = new BigDecimal("49.89");
        Assert.assertEquals("an order with 10 roses is 49.89",expectedResult,testOrder.getSubtotal());
    }
    @Test
    public void test_flower_shop_order_negative_roses() {
        FlowerShopOrder testOrder = new FlowerShopOrder("idc",-100);
        BigDecimal expectedResult = new BigDecimal("19.99");
        Assert.assertEquals("Ignore negative numbers for count roses",expectedResult,testOrder.getSubtotal());

    }
    @Test
    public void test_get_delivery_fee_10000(){
        FlowerShopOrder fo = new FlowerShopOrder("na",0);
        String zip = "10000";
        BigDecimal expected = BigDecimal.ZERO;
        Assert.assertEquals("for zip 10000 its always free",expected,fo.getDeliveryFee(true,zip));
        Assert.assertEquals("for zip 10000 its always free",expected, fo.getDeliveryFee(false,zip));
    }
    @Test
    public void test_get_delivery_fee_20000(){
        FlowerShopOrder fo = new FlowerShopOrder("na",0);
        String zip = "20000";
        BigDecimal expectedSameDay = new BigDecimal("9.98");//same day is 3.99 + 5.99
        BigDecimal expectedNotSameDay = new BigDecimal("3.99");
        Assert.assertEquals("zip 20000 sameDay",expectedSameDay,fo.getDeliveryFee(true,zip));
        Assert.assertEquals("zip 20000 not same day",expectedNotSameDay, fo.getDeliveryFee(false,zip));
    }

    @Test
    public void test_get_delivery_fee_30000(){
        FlowerShopOrder fo = new FlowerShopOrder("na",0);
        String zip = "30000";
        BigDecimal expectedSameDay = new BigDecimal("12.98");//same day is 6.99 + 5.99
        BigDecimal expectedNotSameDay = new BigDecimal("6.99");
        Assert.assertEquals("zip 30000 sameDay",expectedSameDay,fo.getDeliveryFee(true,zip));
        Assert.assertEquals("zip 30000 not same day",expectedNotSameDay, fo.getDeliveryFee(false,zip));
    }
    @Test
    public void test_get_delivery_fee_everywhereelse(){
        FlowerShopOrder fo = new FlowerShopOrder("na",0);
        String zip = "90000";
        BigDecimal expected = new BigDecimal("19.99"); //no same day
        Assert.assertEquals("zip 90000 sameDay",expected,fo.getDeliveryFee(true,zip));
        Assert.assertEquals("zip 90000 not same day",expected, fo.getDeliveryFee(false,zip));

        zip = "10";
        Assert.assertEquals("zip 10 sameDay",expected,fo.getDeliveryFee(true,zip));
        Assert.assertEquals("zip 10 not same day",expected, fo.getDeliveryFee(false,zip));
    }
    @Test
    public void test_total_is_fee_plus_subtotal(){
        FlowerShopOrder fo = new FlowerShopOrder("na",0);

        BigDecimal expectedResult = fo.getSubtotal().add(fo.getDeliveryFee(true,"1"));
        Assert.assertEquals("Total is both added",expectedResult,fo.getDeliveryTotal(true,"1"));

    }
    @Test
    public void test_to_string(){
        String bouquetName = "valentines";
        int roseCount = 6;
        FlowerShopOrder fo = new FlowerShopOrder(bouquetName,roseCount);

        String expectedResult = "ORDER - "+bouquetName+" - "+roseCount+" roses - "+"37.93";
        Assert.assertEquals("to string should print details",expectedResult,fo.toString());

    }
}
