package com.techelevator.farm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
   -Adding a final keyword to a METHOD means that subclasses are not allowed to
    override that method
   -Add a final keyword to a CLASS means that you can't create any subclasses/use that
    class as a base class/parent class. Making a class final means you can't extend it to
    another class
    -An abstract class is a class that cannot be instantiated. It exists solely for the purpose
     of inheritance and polymorphism.
    -Abstract methods are methods on the parent class with NO LOGIC that MUST be implemented by the
     concrete(not abstract) subclasses
        -If a class has an abstract method, it must be an abstract class
        -If a class does not override an abstract method from the parent, it must also be abstract
    -So what's the difference between an abstract class and an interface?
       Abstract classes can still have some implemented methods
       A class can only inherit from ONE other class, but can implement as many interfaces as you want
       Inheriting from a class is like making a specialized version. A Cow is a specific FarmAnimal, a grandfather
        clock is a specific Clock. Where interfaces is what a class can do - a book is Sellable and Readable, the Tractor
        is Singable
 */
public class OldMacdonald {
	public static void main(String[] args) {

		List<Singable> singables =
				new ArrayList<Singable>(Arrays.asList(new Singable[]{new Cow(), new Chicken(), new Pig(), new Tractor()}));

		//add a new animal that is sleeping to my list of singables
		Cow sleepingCow = new Cow();
		sleepingCow.setSleeping(true);
		Pig sleepingPig = new Pig();
		sleepingPig.setSleeping(true);

		singables.add(sleepingCow);
		singables.add(sleepingPig);

		//add a sleeping cat
		Cat sleepingCat = new Cat();
		sleepingCat.setSleeping(true);
		singables.add(sleepingCat);

		//what is a generic farm animal
		//FarmAnimal fa = new FarmAnimal("something","meh"); //FarmAnimal is abstract so this is not allowed
		FarmAnimal cow = new Cow();

		for (Singable singable : singables) {
			String name = singable.getName();
			String sound = singable.getSound();
			System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
			System.out.println("And on his farm he had a " + name
					+ ", ee, ay, ee, ay, oh!");
			System.out.println("With a " + sound + " " + sound + " here");
			System.out.println("And a " + sound + " " + sound + " there");
			System.out.println("Here a " + sound + " there a " + sound
					+ " everywhere a " + sound + " " + sound);
			System.out.println();
		}

		Sellable[] sellables = new Sellable[] {new Cow(), new Pig(), new Egg()};

		for (Sellable sellable : sellables) {
			System.out.println("Step right up and get your " + sellable.getName());
			System.out.println("Only $" + sellable.getPrice());
		}
	}
}
