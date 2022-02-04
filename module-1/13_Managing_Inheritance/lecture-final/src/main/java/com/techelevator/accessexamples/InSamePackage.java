package com.techelevator.accessexamples;

public class InSamePackage {
    //in the same package, I can access public protected and default

    public static void main(String[] args) {
        //in a different class in the same package
        // i have access to everything EXCEPT private
        Examples e = new Examples();
        e.publicInt = 5;
        e.protectedInt = 5;
        e.defaultInt = 5;
        //e.privateInt = 5;

    }

}
