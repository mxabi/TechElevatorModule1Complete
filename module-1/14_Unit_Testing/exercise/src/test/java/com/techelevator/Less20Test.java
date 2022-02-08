package com.techelevator;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Assert.*;

public class Less20Test {

    Less20 less = new Less20();

    @Test
    public void testMultiple20True() {

        Assert.assertEquals(true, less.isLessThanMultipleOf20(18));
        Assert.assertEquals(true, less.isLessThanMultipleOf20(19));
        Assert.assertEquals(true, less.isLessThanMultipleOf20(58));
        Assert.assertEquals(true, less.isLessThanMultipleOf20(59));
    }

    @Test
    public void testMultiple20False() {

        Assert.assertEquals(false, less.isLessThanMultipleOf20(17));
        Assert.assertEquals(false, less.isLessThanMultipleOf20(15));
        Assert.assertEquals(false, less.isLessThanMultipleOf20(75));
        Assert.assertEquals(false, less.isLessThanMultipleOf20(94));
    }
}
