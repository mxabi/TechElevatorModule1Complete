package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

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
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
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
    @Test
    public void test_monkey_trouble(){
        //arrange - already done by @before

        //act and assert combo
        Assert.assertTrue("aSmile true, bSmile true should be true",exercises.monkeyTrouble(true,true));
        Assert.assertTrue("aSmile false, bSmile false should be true",exercises.monkeyTrouble(false,false));
        Assert.assertFalse("aSmile is true, bSmile is false should be false",exercises.monkeyTrouble(true,false));
        Assert.assertFalse("asMile is false, bSmile is true should be false",exercises.monkeyTrouble(false,true));
    }

    @Test
    public void test_sumDouble_a_b_equal(){
        //arrange - done by @Before

        //act
        int result = exercises.sumDouble(0,0);
        //assert
        Assert.assertEquals("Zeros should return 0",0,result);

        //act
        result = exercises.sumDouble(1,1);
        //assert
        Assert.assertEquals("a=1 & b=1 should return 4",4,result);
    }

    @Test
    public void test_sumDouble_a_b_not_equal(){
        //arrange - done by @Before

        //act
        int result = exercises.sumDouble(0,1);
        //assert
        Assert.assertEquals("a=0&b=1 should return 1",1,result);

        //act
        result = exercises.sumDouble(1,9);
        //assert
        Assert.assertEquals("a=1 & b=9 should return 10",10,result);
    }

    //TDD - method that takes an array of ints as a parameter and returns the sum
    @Test
    public void test_sum_array_happy_path(){
        //arrange
        //create the array to pass in as the parameter
        int[] testData = {1,2,3,4};
        int expectedResult = 10;

        //act
        int actualResult = exercises.sumArray(testData);

        Assert.assertEquals("array sum broken",expectedResult,actualResult);
    }
    @Test
    public void test_sum_array_pass_in_null(){
        //arrange - the array is set to null
        int[] uninitializedArray = null;
        int expectedResult = 0;
        int actualResult = exercises.sumArray(uninitializedArray);

        Assert.assertEquals("array passed in is null should return 0",expectedResult,actualResult);
    }
}
