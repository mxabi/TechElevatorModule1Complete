package com.techelevator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class SameFirstLastTest {

    SameFirstLast firstLast = new SameFirstLast();

    @Test
    public void testFirstAndLastEqualAndSizeBiggerThanOne() {
        assertEquals(true, firstLast.isItTheSame(new int[] { 1, 2, 4, 3, 1 }));
        assertEquals(true, firstLast.isItTheSame(new int[] { 5, 2, 3, 5 }));
        assertEquals(true, firstLast.isItTheSame(new int[] { 3, 2, 3 }));
        assertEquals(false, firstLast.isItTheSame(new int[] { 4, 1 }));
        assertEquals(false, firstLast.isItTheSame(new int[] { 3, 3, 3, 1 }));
        assertEquals(false, firstLast.isItTheSame(new int[] { 0, 2, 1 }));
        assertEquals(false, firstLast.isItTheSame(new int[] {}));

    }

    @Test
    public void testNullFirstAndLast() {
        assertEquals(false, firstLast.isItTheSame(null));

    }
}
