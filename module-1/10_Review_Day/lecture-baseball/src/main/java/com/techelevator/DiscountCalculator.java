package com.techelevator;

import java.util.Scanner;

/*
  Java parsing:
    Integer.parseInt(String s);
    Long.parseLong(String s);
    Double.parseDouble(String s);
    Boolean.parseBoolean(String s);
 */
class DiscountCalculator {

    /**
     * The main method is the start and end of our program
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);//required to read from the console

        System.out.println("Welcome to the Discount Calculator");Calculator

        // Prompt the user for a discount amount
        // The answer needs to be saved as a double
        System.out.print("Enter the discount amount (w/out percentage): ");

        //always read in input from the user as a string
        String strDiscount = input.nextLine(); //nextLine reads in what the user typed as a whole line

        // Prompt the user for a series of prices
        System.out.print("Please provide a series of prices (space separated): ");
        String strPriceList = input.nextLine(); //10 50 41.2

        //convert the discount to a double
        double discount = Double.parseDouble(strDiscount);

        //separate out the strPriceList
        String[] strPriceArray = strPriceList.split(" ");

        String strPrice = "";
        //  for each one of those, we'll:
        for (int i=0; i< strPriceArray.length;i++){
             strPrice = strPriceArray[i];
            //     convert to a double, calculate the new price with the discount, print it out
            double price = Double.parseDouble(strPrice);
            //if my price is 100 and my discount is 40 then i should print 60
            double salePrice = price - (price * discount/100);
           // System.out.println("Original price: $"+price+" Sale price: $"+salePrice);

            //  System.out.format("%.3f%n", pi);     // -->  "3.142"
            System.out.format("Original price $%.2f Discount price $%.2f%n",price,salePrice);
        }

        //string comparison
        //primitives ==
        //when we compare strings, .equals
        String name = "Katie";
        String name2 = "Zach";
        if (name==name2){ //this compares if they are referencing the same spot in memory

        }
        if (name.equals(name2)){ //this is actually comparing the string contents

        }

    }

21zx}
