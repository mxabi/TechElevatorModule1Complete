package com.techelevator;

import com.techelevator.shapes.Circle;
import com.techelevator.shapes.Shape;
import com.techelevator.shapes.Square;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        //demoShape();


        // Create a new general auction
        System.out.println("Starting a general auction");
        System.out.println("-----------------");

        Auction generalAuction = new Auction("Tech Elevator t-shirt");

        generalAuction.placeBid(new Bid("Josh", 1));
        generalAuction.placeBid(new Bid("Fonz", 23));
        generalAuction.placeBid(new Bid("Rick Astley", 13));
        //....
        //....
        // This might go on until the auction runs out of time or hits a max # of bids

        ReserveAuction ra = new ReserveAuction("Bengals jersey",100);
        Bid katiesBid = new Bid("Katie",90);
        ra.placeBid(katiesBid);
        Bid abedaBid = new Bid("Abeda",1000);
        ra.placeBid(abedaBid);
        Bid zachsBid = new Bid("Zach",150);
        ra.placeBid(zachsBid);

        //BigDecimal
        BigDecimal balance = new BigDecimal("3.3");
        BigDecimal zero = BigDecimal.ZERO;
        BigDecimal one = BigDecimal.ONE;
        balance.add(one); //THIS DOES NOT CHANGE BALANCE, IT RETURNS A NEW BIG DECIMAL WITH THE RESULT

        balance = balance.add(one);//this will update balance
        //is balance > 0?
        int result = balance.compareTo(BigDecimal.ZERO);
        //result will be -1 if balance is less than zero (the parameter)
        //result will be 0 if balance is equal to  zero (the parameter)
        //result will be 1 if balance is greater than zero (the parameter)

    }

    private static void demoShape() {
        Shape myShape = new Shape("orange",false,1);
        System.out.println(myShape.getColor()+" "+myShape.isFilled()+" "+myShape.getNumLines());

        Square square = new Square();
        square.setColor("black");
        //square.setNumLines(4);
        square.setFilled(false);
        square.setSideLength(4);

        Square s2 = new Square("gold",true);

        //polymorphism - every square is-a Shape
        Shape sq3 = new Square(5);
        //since sq3 really is a square, its going
        //to look there FIRST for the getPerimeter method
        double sq3Perim = sq3.getPerimeter();
        //sq3.getSideLength();
        //since the datatype for sq3 is a Shape, I can't access the Square methods directly
        //but i can cast if absolutely must (try not to becuase it violates OOP conventions)
        double sl = ((Square)sq3).getSideLength();

        Circle circle = new Circle("blue",true,1);
        double circPerim = circle.getPerimeter();

        List<Shape> myListOfShapes = new ArrayList<>();
        myListOfShapes.add(square);
        myListOfShapes.add(s2);
        myListOfShapes.add(circle);
        for(Shape s : myListOfShapes){
            double p = s.getPerimeter(); //call the getPerimiter from the actual class s is
            System.out.println("Perimter: "+p);
        }
    }
}
