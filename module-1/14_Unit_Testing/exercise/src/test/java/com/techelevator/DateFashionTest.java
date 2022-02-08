package com.techelevator;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert.*;

public class DateFashionTest {

    DateFashion date = new DateFashion();

    @Test
    public void testCanGetSeat8OrAbove() {
        Assert.assertEquals(2, date.getATable(4, 8));
        Assert.assertEquals(2, date.getATable(8, 3));
        Assert.assertEquals(2, date.getATable(8, 8));
        Assert.assertEquals(2, date.getATable(5, 10));
        Assert.assertEquals(2, date.getATable(9, 10));

    }

    @Test
    public void testCanGetSeat2OrBelow() {
        Assert.assertEquals(0, date.getATable(1, 8));
        Assert.assertEquals(0, date.getATable(2, 2));
        Assert.assertEquals(0, date.getATable(2, 7));
        Assert.assertEquals(0, date.getATable(1, 1));
        Assert.assertEquals(0, date.getATable(0, 10));

    }

    @Test
    public void testCanGetSeatBetween() {
        Assert.assertEquals(1, date.getATable(5, 6));
        Assert.assertEquals(1, date.getATable(3, 7));
        Assert.assertEquals(1, date.getATable(7, 7));
        Assert.assertEquals(1, date.getATable(4, 6));
        Assert.assertEquals(1, date.getATable(5, 7));

    }
}
