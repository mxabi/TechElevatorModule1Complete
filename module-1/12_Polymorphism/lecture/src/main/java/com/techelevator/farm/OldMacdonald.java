package com.techelevator.farm;

import java.util.ArrayList;
import java.util.List;

public class OldMacdonald {
	public static void main(String[] args) {

		//Polymorphism is the idea that something can be given a different meaning or usage based on
		//Different objects can be treated the same way


		Cow cow = new Cow();
		System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
		System.out.println("And on his farm he had a " + cow.getName() + ", ee, ay, ee, ay, oh!");
		System.out.println("With a " + cow.getSound() + " " + cow.getSound() + " here");
		System.out.println("And a " + cow.getSound() + " " + cow.getSound() + " there");
		System.out.println("Here a " + cow.getSound() + " there a " + cow.getSound() + " everywhere a " + cow.getSound() + " " + cow.getSound());
		System.out.println();

		Chicken chicken = new Chicken;

		List<FarmAnimal> myfarms = new ArrayList<>();
		myFarms.add(new Cow());
	}
}
