package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class FlowerShopOrderTest {

    @Test
    public void test_flower_shop_order_subtotal(){
        FlowerShopOrder testOrder = new FlowerShopOrder("idk", 0);
        BigDecimal expectedResult = new BigDecimal(19.99);
        Assert.assertEquals("an order with no roses is 19.99", expectedResult,testOrder.getSubtotal());

        FlowerShopOrder testOrder2 = new FlowerShopOrder(("vday", 12));
        
    }
}
