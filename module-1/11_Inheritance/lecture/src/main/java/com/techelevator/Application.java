package com.techelevator;

public class Application {

    public static void main(String[] args) {

        Shape myShape =new Shape("Orange", true,1);
        System.out.println(myShape.getColor() + "" + myShape.isFilled() + myShape.getNumLines());

        Square s = new Square();
        s.setColor("red");
        s.setFilled(false);
        s.setNumLines(4);
        s.setSideLength(4);
        Square s2 = new Square("gold",true);


        //polymorphism
        //Every square is a shape
        Shape sq3 = new Square();
        sq3.set


        /* Create a new general auction
        System.out.println("Starting a general auction");
        System.out.println("-----------------");

        Auction generalAuction = new Auction("Tech Elevator t-shirt");

        generalAuction.placeBid(new Bid("Josh", 1));
        generalAuction.placeBid(new Bid("Fonz", 23));
        generalAuction.placeBid(new Bid("Rick Astley", 13));
        //....
        //....
        // This might go on until the auction runs out of time or hits a max # of bids

        */

    }
}
