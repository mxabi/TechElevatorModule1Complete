package com.techelevator.farm;

//adding abstract to the FarmAnimal means that no one can say
// = new FarmAnimal(...);
public abstract class FarmAnimal implements Singable {
	private String name;
	private String sound;
	private boolean sleeping;

	public FarmAnimal(String name, String sound) {
		this.name = name;
		this.sound = sound;
	}

	public String getName( ) {
		return name;
	}
	public final String getSound( ) {
		//if the farm animal is sleeping, the sound that they make is zzzzz
		if (sleeping){
			return "zzzzzz";
		}
		return sound;
	}

	public boolean isSleeping(){
		return sleeping;
	}
	public void setSleeping(boolean sleeping){
		this.sleeping = sleeping;
	}

	//all FarmAnimal subclasses/child classes MUST have an eat method
	public abstract String eat();

}
