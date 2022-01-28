package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<Book> booksToBuy = new ArrayList<Book>();

    //Create method to add books to shopping cart
    public void add(Book bookToAdd){
        booksToBuy.add(bookToAdd);
    }

    // Create method to get total price of books
    public double getTotalPrice(){
        double total = 0.00;
        for (Book book : booksToBuy) {
            total += book.getPrice();
        }
        return total;
    }

    //Create a reciepts method to get list of each book in shopping cart
    //And total Price at end
    public String getReceipt(){
        String receipt = "\nReceipt\n";
        for (Book book : booksToBuy){
            receipt += book.bookInfo();
            receipt += "\n";
        }
        receipt += "\n Total $: " + getTotalPrice();
        return receipt;
    }
}
