package com.techelevator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

public class NonStartTest {

    NonStart partial = new NonStart();

    @Test
    public void testConc() {

        assertEquals("ellohere", partial.getPartialString("Hello", "There"));
        assertEquals("hipoal", partial.getPartialString("Ship", "Coal"));
        assertEquals("avaode", partial.getPartialString("java", "code"));
    }

    @Test
    public void testConcAEmpty() {

        assertEquals("here", partial.getPartialString("", "There"));
        assertEquals("oal", partial.getPartialString("", "Coal"));
        assertEquals("ode", partial.getPartialString("", "code"));
    }

    @Test
    public void testConcBEmpty() {

        assertEquals("ello", partial.getPartialString("Hello", ""));
        assertEquals("hip", partial.getPartialString("Ship", ""));
        assertEquals("ava", partial.getPartialString("java", ""));
    }
}
