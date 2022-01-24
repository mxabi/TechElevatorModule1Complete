package com.techelevator;

import java.util.Scanner;

class DiscountCalculator {

    /**
     * The main method is the start and end of our program
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Discount Calculator");

        // Prompt the user for a discount amount
        // The answer needs to be saved as a double
        System.out.print("Enter the discount amount (w/out percentage): ");
        String strDiscount = scanner.nextLine();



        // Prompt the user for a series of prices
        System.out.print("Please provide a series of prices (space separated): ");
        String strPriceList = scanner.nextLine(); //10 50 41.2

        //convert the discount to a double
        double discount = Double.parseDouble(strDiscount);
        //seperate out the strPriceList
        // convert to a double, calculate the discount, print it out

        //Java parsing
        //regex
        String[] strpriceArray =strPriceList.split( "");

        //for each one of those , we'll:
        for (int i = 0; i< strpriceArray.length;i++) {
            String strPrice = strpriceArray[i];
            //convert to a double, calculate the discount, print it out
            double price = Double.parseDouble((strPrice));

            //if my price is 100 and my discount is 40 then i should print 60;
            double salePrice = price - (price*discount/100);
            System.out.println("Original price is "+ price +" Sale price is "+salePrice);

            //string comparison
            //primitives ==
            //when we compare strings, .equals
            String name = "Katie";
            String name2 = "Zach";

            if (name == name2) {
                //this compares if they are referencing the same spot in memory
            }
            if (name.equals(name2)){
                //compares the string contents
            }
        }





    }

}
