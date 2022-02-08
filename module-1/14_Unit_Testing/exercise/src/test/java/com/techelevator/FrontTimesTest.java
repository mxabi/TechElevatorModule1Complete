package com.techelevator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

public class FrontTimesTest {

    FrontTimes front = new FrontTimes();

    @Test
    public void testNotNull() {
        assertNotNull(front.generateString("Chocolate", 2));
        assertNotNull(front.generateString("test", 5));
        assertNotNull(front.generateString("hoooraaay", 7));
    }

    @Test
    public void testStringTimes() {
        assertEquals("hehheh", front.generateString("hehehehe", 2));
        assertEquals("shishi", front.generateString("ship", 2));
        assertEquals("cho", front.generateString("chocolate", 1));
        assertEquals("chochochocho", front.generateString("chocolate", 4));
        assertEquals("aaaa", front.generateString("a", 4));

    }

    @Test
    public void testStringEmpty() {
        assertEquals("", front.generateString("", 4));
        assertEquals("", front.generateString("", 0));

    }
}
