package com.techelevator.farm;

public class FarmAnimal implements Singable{
	private String name;

	public FarmAnimal(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getSound() {
		return "meh";
	}

	@Override
	public boolean equals(Object o){ //Object is super generic
		//not very OOP
		if (o instanceof FarmAnimal){ //if it's a farm animal
			return ((FarmAnimal) o).name.equals(this.name); //if the name is the same then it's equal
		}
		return false; //otherwise not equal return false
	}
}
