package com.techelevator.shapes;

import com.techelevator.accessexamples.Examples;

import java.util.ArrayList;
import java.util.List;

public class MainProgram {
    public static void main(String[] args) {

        //demo of the access
        // so now we're in a different package than Examples
        //ONLY have access to public, not protected, default or private
        Examples e = new Examples();
        e.publicInt = 5;
//        e.protectedInt = 5;
//        e.defaultInt = 5;
        //e.privateInt = 5;

        List<Shape> myShapes = new ArrayList<>();
        Rectangle r = new Rectangle("orange",true,10,100.5);
        myShapes.add(r); //add the rectangle to the list of shapes. a rectnagle is-a shape

        //i cannot instantiate Shape becuase it's abstract
        //Shape s = new Shape("red",false,1);
        //i CAN have the parent/superclass/generic as the datatype
        Shape r2 = new Rectangle("black",true,1.5,2.3);

        myShapes.add(new Circle("blue",false, 4.4));

        for (Shape shape : myShapes){
            //System.out.println("Color: "+shape.getColor()+" Area: "+shape.getArea());
            System.out.println(shape);
        }
    }

    public static void exampleMethod(Shape s){
        System.out.println("My parameter is a Shape so i can pass in a rectangle, circle, etc");
    }
}
