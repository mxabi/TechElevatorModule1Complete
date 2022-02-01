package com.techelevator.farm;

import java.util.ArrayList;
import java.util.List;

public class OldMacdonald {
	public static void main(String[] args) {
		/*
		In OOP, polymorphism is the idea that something can be given a different meaning or usage based on context.
		Different objects can be treated as the same type of thing within a program.

		Examples of polymorphism:
		-I can have a method that has the base/super class as parameter and pass in an object of the child/subclass

		An interface is a contract that defines what methods a user can expect but not the implementation of the methods
		 - cannot be instantiated
		 - multiple interfaces are allowed
		 - is-a relationship

		Can implement two interfaces - comma delimited

		 */

		//DRY Don't Repeat Yourself
		List<Singable> myFarm = new ArrayList<>();
		myFarm.add(new Cow());
		myFarm.add(new Chicken());
		myFarm.add(new Duck());
		myFarm.add(new Duck());
		myFarm.add(new Goose());

		//i can have a local variable that's referencing a duck before i add it to the list
		//but i'm not really going to do anything with it in this application so its not necessary
		Duck katiesRubberDuck = new Duck();
		myFarm.add(katiesRubberDuck);
		
		//add in the tractor to the list last
		myFarm.add(new Tractor());

		//sing about every animal on my farm
		for(Singable thing : myFarm){
			singVerse(thing);
		}

		//List is an interface, ArrayList is a class that implements that interface
		List<Sellable> yardSale = new ArrayList<>();
		yardSale.add(new Egg());
		yardSale.add(new Chicken());
		for (Sellable item : yardSale){
			System.out.println(item.getName()+" is on sale for $"+item.getPrice());
		}


	}

	//since a duck is-a Farm Animal, i can pass in duck. since a cow is-a farm animal, i can pass in cow, ...
	private static void singVerse(Singable thing) {
		System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
		System.out.println("And on his farm he had a " + thing.getName() + ", ee, ay, ee, ay, oh!");
		System.out.println("With a " + thing.getSound() + " " + thing.getSound() + " here");
		System.out.println("And a " + thing.getSound() + " " + thing.getSound() + " there");
		System.out.println("Here a " + thing.getSound() + " there a " + thing.getSound() + " everywhere a " + thing.getSound() + " " + thing.getSound());
		System.out.println();
	}
}
