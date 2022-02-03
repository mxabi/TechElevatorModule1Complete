package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/*
   General Structure of a Test: Arrange, Act, Assert
   Annotations: @Before - run this method before every test
                @After - run this method after every test
                @Test - this method is a test
    all the methods must be public void and accept no params
    method names should be overly verbose
    public void method_name_describes_exactly_what_you_are_testing() {}

    Best practices:
       is there an if statement - test if its true and false
       is there a loop - test if the thing is empty, only one element, lots of elements
       is an object passed in  - test null, test an empty object, test missing values

 */
public class ExercisesTest {
    //declare it at the class level so all my tests have access to it
    private Exercises exercises;

    //before every test, instantiate exercises
    @Before
    public void setup(){
        exercises = new Exercises();
    }

    @Test
    public void test_sleep_in_is_weekday_is_vacation(){
        //arrange - is done by the before- we create a new exercises object

        //Act
        boolean result = exercises.sleepIn(true,true);

        //Assert
        Assert.assertTrue("If vacation is true, it should return true",result);
    }
    @Test
    public void test_sleep_in_is_not_weekday_is_vacation(){
        //arrange - is done by the before- we create a new exercises object

        //Act
        boolean result = exercises.sleepIn(false,true);

        //Assert
        Assert.assertTrue("If vacation is true, it should return true",result);
    }
    @Test
    public void test_sleep_in_is_weekday_is_not_vacation(){
        //arrange - is done by the before- we create a new exercises object

        //Act
        boolean result = exercises.sleepIn(true,false);

        //Assert
        Assert.assertFalse("If its a weekday and not vacation you can't  sleep in",result);
    }
    @Test
    public void test_sleep_in_is_not_weekday_is_not_vacation(){
        //arrange - is done by the before- we create a new exercises object

        //Act
        boolean result = exercises.sleepIn(false,false);

        //Assert
        Assert.assertTrue("If its not a weekday and not vacation you can  sleep in",result);
        Assert.assertTrue("Message is here",false);
    }
}
