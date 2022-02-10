package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class CaesarCipherTest {
    @Test
    public void test_encrypt(){
        CaesarCipher cc = new CaesarCipher();
        String original = "ABC";
        String encrypted = "DEF";
        int shift = 3;

        String actual = cc.encrypt(original,shift);
        Assert.assertEquals("Test shift of 3",encrypted,actual);
    }

    //todo we should test boundary conditions - ascii values of 127+

    @Test
    public void test_decrypt(){
        CaesarCipher cc = new CaesarCipher();
        String original = "ABC";
        String encrypted = "DEF";
        int shift = 3;

        String actual = cc.decrypt(encrypted,shift);
        Assert.assertEquals("Test shift of 3",original,actual);
    }
}
