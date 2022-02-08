package com.techelevator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

public class StringBitsTest {

    StringBits bits = new StringBits();

    @Test
    public void testStringStartingWithEveryOtherChar() {
        assertEquals("Hlo", bits.getBits("Hello"));
        assertEquals("H", bits.getBits("Hi"));
        assertEquals("Hello", bits.getBits("Heeololeo"));

    }

    @Test
    public void testNull() {
        assertEquals("", bits.getBits(null));
    }
}
