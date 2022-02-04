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
}
