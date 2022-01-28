package com.techelevator;

/**
 * Bookstore
 */
public class Bookstore {

    public static void main(String[] args) {

        System.out.println("Welcome to the Tech Elevator Bookstore");
        System.out.println();

        Book magicTreeHouse = new Book("Magic TRree House", "Some Author", 5.99);
        // Step Three: Test the getters and setters
        /*
        magicTreeHouse.setBookTitle("Magic Tree House");
        magicTreeHouse.setAuthorName("author");
        magicTreeHouse.setPrice(3.99);

        String authorofBook = magicTreeHouse.getAuthorName();
        String booktitle = magicTreeHouse.getBookTitle();
        Double priceofBook = magicTreeHouse.getPrice();

        System.out.println("The book is called " + booktitle + " the price is " + priceofBook + " the author is " + authorofBook);
        */
        // Step Five: Test the Book constructor
        Book twoCities = new Book("A tale of two cities", "Charles Dickens", 19.99);

        System.out.println();

        // Test String Representation of Book class & Testing BookInfo Method
        //System.out.println(twoCities.bookInfo());
        //System.out.println(magicTreeHouse.bookInfo());
        // Step Nine: Test the ShoppingCart class

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(magicTreeHouse);
        shoppingCart.add(twoCities);
        System.out.println(shoppingCart.getReceipt());
        
    }
}
