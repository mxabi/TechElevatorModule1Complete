package com.techelevator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

public class Lucky13Test {

    Lucky13 lucky = new Lucky13();

    @Test

    public void testNo1And3() {
        assertEquals(true, lucky.getLucky(new int[] { 0, 5, 7, 8 }));
        assertEquals(true, lucky.getLucky(new int[] { 0, 5, 2, 29 }));
        assertEquals(true, lucky.getLucky(new int[] { 0, 6, 10, 8 }));
        assertEquals(false, lucky.getLucky(new int[] { 0, 1, 7, 8 }));
        assertEquals(false, lucky.getLucky(new int[] { 0, 1, 7, 8 }));
        assertEquals(false, lucky.getLucky(new int[] { 0, 3, 7, 8 }));
        assertEquals(false, lucky.getLucky(new int[] { 0, 1, 3, 4 }));
    }

    @Test

    public void testNotNull() {
        assertNotNull(lucky.getLucky(new int[] {0,2,3,4}));
        assertNotNull(lucky.getLucky(new int[] {0,2,6,9}));
    }
}
