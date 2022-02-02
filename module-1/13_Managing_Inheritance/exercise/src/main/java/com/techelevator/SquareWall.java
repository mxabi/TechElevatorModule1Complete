package com.techelevator;

public class SquareWall extends RectangleWall {

    public SquareWall(String name, String color, int sideLength){
        super(name,color,sideLength,sideLength);
        this.sideLength = sideLength;
    }

    @Override
    public int getArea() {
        return sideLength*sideLength;
    }

    public int getSideLength() {
        return sideLength;
    }

    public void setSideLength(int sideLength) {
        this.sideLength = sideLength;
    }

    private int sideLength;

    @Override
    public String toString() {
        return "TEST " + "(" + getSideLength() + "x" + getSideLength() +")" + " square"
                ;
    }
}
