package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class Module1CodingAssessmentTest {
    @Test
    public void test_static_returns_true(){
        //i can call static methods with the Class Name
        Assert.assertTrue(Module1CodingAssessment.testReturnsTrue());
    }
    @Test
    public void test_returns_true(){
        //if it's not a static method, i have to create an object
        Module1CodingAssessment mca = new Module1CodingAssessment();
        Assert.assertTrue(mca.testNonStaticReturnsTrue());
    }
}
