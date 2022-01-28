package com.techelevator;

//step 1 Create book class

public class Book {
    //Create instance variables -- characteristics of Book
    //private variables encapsulate state

    private String authorName;
    private String bookTitle;
    private double price;

    public String getAuthorName() {
        return authorName;
    }

    public double getPrice() {
        return price;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Book ( String bookTitle, String authorName, double price){
        this.bookTitle = bookTitle;
        this.authorName = authorName;
        this.price = price;
    }
        //Class is complete with string representation
    public String bookInfo(){
        return "Book title: " + bookTitle + " Author Name: " + authorName + " price: " + price;
    }
}
