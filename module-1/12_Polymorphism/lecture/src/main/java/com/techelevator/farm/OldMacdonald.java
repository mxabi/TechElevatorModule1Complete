package com.techelevator.farm;

public class OldMacdonald {
	public static void main(String[] args) {


		Cow cow = new Cow();
		System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
		System.out.println("And on his farm he had a " + cow.getName() + ", ee, ay, ee, ay, oh!");
		System.out.println("With a " + cow.getSound() + " " + cow.getSound() + " here");
		System.out.println("And a " + cow.getSound() + " " + cow.getSound() + " there");
		System.out.println("Here a " + cow.getSound() + " there a " + cow.getSound() + " everywhere a " + cow.getSound() + " " + cow.getSound());
		System.out.println();

	}
}
