package com.techelevator;

import java.util.*;

public class Lecture {

	public static void main(String[] args) {

		System.out.println("####################");
		System.out.println("        SETS");
		System.out.println("####################");
		System.out.println();

		/*
		  A set is a collection of unique values

		  an item is either in the set or not in the set
		  i can add an item to the set
		  i can remove an item from the set
		  loop through and print the set

		  Intellisense has a set of keywords that it makes blue
		  Just want to keep track of jersey numbers taken/available
		 */

		//Set<String> javaKeywords = new HashSet<>(); //no order
		Set<String> javaKeywords = new LinkedHashSet<>(); //maintains insertion order
		//Set<String> javaKeywords = new TreeSet<>(); //items are in order
		javaKeywords.add("public");
		javaKeywords.add("static");
		javaKeywords.add("void");
		//The add returns true if it was added, false if it was skipped for being a dup

		if (javaKeywords.add("main")){
			System.out.println("main added");
		}
		if (javaKeywords.add("main")){
			System.out.println("main added");
		}
		if (javaKeywords.add("main")){
			System.out.println("main added");
		}
		if (javaKeywords.add("main")){
			System.out.println("main added");
		}

		javaKeywords.add("main");//no dups not added again
		javaKeywords.add("main");//no dups not added again
		javaKeywords.add("main");//no dups not added again
		javaKeywords.add("main");//no dups not added again

		//test  LinkedHashSet if the insertion order changes if you try to add the dup
		javaKeywords.add("public");

		if (javaKeywords.contains("public")){
			System.out.println("Make the word public blue");
		}
		for(String str : javaKeywords){
			System.out.println(str);
		}


		System.out.println("####################");
		System.out.println("        MAPS");
		System.out.println("####################");
		System.out.println();

		// Maps are essentially lookup tables where you have a key value pair
		// KEYS must be unique, values don't have to be

		//declare and initialize a map
		//let's have student email as the key and value will be city located in
		Map<String,String> studentCityLookup = new HashMap<>(); //order by computer most efficient

		//we can also use TreeMap(order by the keys) or LinkedHashMap(insertion order)

		//i add things to the map using put(key,value)
		studentCityLookup.put("cameron@cameron.com","Panama City Beach");
		studentCityLookup.put("lily@lily.com","New York City");

		//if your key is a string, I STRONGLY ENCOURAGE you to use all lowercase or all uppercase and NOT mixed case
		studentCityLookup.put("zach@zach.com","Perrysburg");
		studentCityLookup.put("jim@jim.com","Virginia Beach");

		//other stuff in our application

		//what city does cameron live in?

		//is cameron even in the map?
		if (studentCityLookup.containsKey("cameron@cameron.com")){
			String cameronsCity = studentCityLookup.get("cameron@cameron.com");
			System.out.println("Cameron lives in "+cameronsCity);
		} else {
			System.out.println("Cameron is missing from the map");
		}

		//get will return null if the key is not in the map
		//and THE KEYS ARE CASE SENSITIVE
		String city = studentCityLookup.get("Jim@Jim.com");
		System.out.println("Jim lives in "+city);

		city = studentCityLookup.get("robert@robert.com");
		System.out.println("Robert lives in "+city);
		//does roberts city contain the word new?
		//boolean testIfHasNew = city.contains("New"); //null reference exception because city is null

		studentCityLookup.put("lily@lily.com","Babylon"); //this will replace the value for the key, no dups
		city = studentCityLookup.get("lily@lily.com");
		System.out.println("Lily lives in "+city);

		/*
		    I cant call a method on any object that is null
			Map<Integer,Integer> nullMap = null;
			nullMap.put(1,1);
		 */

		//.keySet will give me the set that contains all of the keys
		Set<String> keysForStudentCityLookup = studentCityLookup.keySet();
		//who all do i have cities for?
		for(String studentEmail : studentCityLookup.keySet()){
			System.out.println("I have the info for "+studentEmail);
			//i coudl get the value while i'm here
			String studentCity = studentCityLookup.get(studentEmail);
			System.out.println("They live in "+studentCity);
		}

		//have a for-each that has the key value pairs together - this is kind of weird and rarely done
		// .entrySet gives you all of the key value pairs and they are datatype Map.Entry<key datatype,value datatype>
		for (Map.Entry<String,String> kvp : studentCityLookup.entrySet()){
			System.out.println("Key: "+kvp.getKey()+" Value: "+kvp.getValue());
		}

		/* DONT LOOK UP A KEY BY USING A LOOP!!!*/
		//find lily in the list
		//THIS IS SLOW  and slowness depends on teh size of the map
		//Map.Entry contains a key value pair
		for (Map.Entry<String,String> kvp : studentCityLookup.entrySet()){
			if (kvp.getKey().equals("lily@lily.com")){
				System.out.println("Lily lives in "+kvp.getValue());
			}
		}
		//if i want to find lily in the map
		System.out.println("Lily lives in: "+studentCityLookup.get("lily@lily.com"));

		System.out.println("Map size: "+studentCityLookup.size());
		//remove an item from the map
		// sorry zach we don't care what city you live in anymore
		studentCityLookup.remove("zach@zach.com");
		System.out.println("Map size: "+studentCityLookup.size());

		if (studentCityLookup.remove("zach@zach.com")==null){
			System.out.println("I tried to remove zach again and he wasn't in the map anymore");
		}

		//1. let's create a map where the key is your SSN (feel free to make them up!) and the value is your favorite color
		// add some info to the map for your group

		//then test to see if the key 4444444444 is there and print if it is

		//2. then let's create a map where the key is your last name and the value is your quiz score for today (make it up)
		// then everyone gets a bonus +5 for the quiz


	}

}
