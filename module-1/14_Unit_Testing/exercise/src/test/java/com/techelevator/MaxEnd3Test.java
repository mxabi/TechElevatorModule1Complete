package com.techelevator;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

public class MaxEnd3Test {

    MaxEnd3 end3 = new MaxEnd3();

    @Test

    public void testBiggerElementAndRepeatIt() {
        assertArrayEquals(new int[] { 3, 3, 3 }, end3.makeArray(new int[] { 1, 2, 3 }));
        assertArrayEquals(new int[] { 7, 7, 7 }, end3.makeArray(new int[] { 1, 2, 7 }));
        assertArrayEquals(new int[] { 1, 1, 1 }, end3.makeArray(new int[] { 1, 0, 1 }));
        assertArrayEquals(new int[] { 8, 8, 8 }, end3.makeArray(new int[] { 8, 8, 2 }));
        assertArrayEquals(new int[] { 5, 5, 5 }, end3.makeArray(new int[] { 1, 5, 3 }));
        assertArrayEquals(new int[] { 9, 9, 9 }, end3.makeArray(new int[] { 9, 5, 3 }));
    }
}
