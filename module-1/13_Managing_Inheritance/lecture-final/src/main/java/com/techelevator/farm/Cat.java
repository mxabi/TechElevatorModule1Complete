package com.techelevator.farm;

public final class Cat extends FarmAnimal {
    public Cat() {
        super("Cat", "meow");
    }

   @Override
    public String eat() {
        return "purr";
    }

    /* since getSound in the parent is final,
    child classes are not allowed to override it
    @Override
    public String getSound(){
        return "MEOW!";
    }

     */
}
