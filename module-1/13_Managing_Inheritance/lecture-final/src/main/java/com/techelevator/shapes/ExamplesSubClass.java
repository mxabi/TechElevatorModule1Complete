package com.techelevator.shapes;

import com.techelevator.accessexamples.Examples;

//subclass that lives in a different package
public class ExamplesSubClass extends Examples {
    //i have access to protected stuff but not private
    public ExamplesSubClass(){
        publicInt = 5;
        protectedInt = 5;
//        defaultInt = 5;
//        privateInt = 5;
    }
}
