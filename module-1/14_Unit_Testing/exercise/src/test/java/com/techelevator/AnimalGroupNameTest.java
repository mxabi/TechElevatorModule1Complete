package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AnimalGroupNameTest {

    AnimalGroupName animalMap;

    @Before
    public void setup(){

        animalMap = new AnimalGroupName();
    }

    @Test
    public void testForAnimalGroups() {

        Assert.assertEquals("Crash", animalMap.getHerd("Rhino"));
        Assert.assertEquals("Pack", animalMap.getHerd("Dog"));
        Assert.assertEquals("unknown",animalMap.getHerd("muppet"));
    }

    @Test
    public void testForNullOrEmptyGroups(){
        Assert.assertEquals("unknown",animalMap.getHerd(""));
        Assert.assertEquals("unknown", animalMap.getHerd(null));
    }
}
