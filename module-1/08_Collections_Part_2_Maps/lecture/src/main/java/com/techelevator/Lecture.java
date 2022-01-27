package com.techelevator;

import java.util.*;

public class Lecture {

	public static void main(String[] args) {

		System.out.println("####################");
		System.out.println("        SETS");
		System.out.println("####################");
		System.out.println();

		/* a set is a collection of unique values /*
		Intellisense has a set of jeywordds that iut makes blue
		Just want to keep track of jersey numbers taken/available
		Provides if it's in the set or not in the
		Can add/remove item in the set
		Can loop through and print out set.
		 */

		//Set<String> javaKeywords2 = new TreeSet<>(); //items are in order
		//Set<String> javaKeywords2 = new HashSet<>(); // no order
		Set<String> javaKeywords2= new LinkedHashSet<>(); //maintains insertion order

		javaKeywords2.add("public");
		javaKeywords2.add("static");
		javaKeywords2.add("void");
		javaKeywords2.add("main");
		javaKeywords2.add("main"); // will not work, no duplicates
		// add returns true if it was added, false if it was skipped for being a dupe

		if (javaKeywords2.add("main")){
			System.out.println("main added");
		}

		if (javaKeywords2.contains("public")){
			System.out.println("Make the word public blue");
		}

		for (String key : javaKeywords2){
			System.out.println("The string " + key);
		}

		/*
		Hashset has no order
		Linked Hashset
		 */

		System.out.println("####################");
		System.out.println("        MAPS");
		System.out.println("####################");
		System.out.println();

		//declare and initialize a map
		//let's have student email as the key, value is the city located in
		Map<String,String> studentCityLookup = new HashMap<>(); //orderless
		studentCityLookup.put("abeda@abeda.com", "NYC");
		studentCityLookup.put("cameron@cameron.com", "Panama City Beach");
		studentCityLookup.put("lily@lily.com","NYC");

		// if key is a string, strongly encourage you to use all lowercase and all uppercase

		if(studentCityLookup.containsKey("cameron@cameron.com")){
			String cameronCity = studentCityLookup.get("cameron@cameron.com");
			System.out.println("Cameron lives in " + cameronCity);
		} else {
			System.out.println("Cameron is missing from the map");
		}

		String jimCity = studentCityLookup.get("jim@jim.com");
		System.out.println("Jim lives in " + jimCity); //will return null because jim is not in map

			// Get will return null if key is not in the map.
			//Get is how we retrieve value from map

		//we can also used TreeMap or LinkedHashMap


		//Cannot call a method on any object that is null
		//Map<Integer,Integer> nullMap = null;
		//nullMap.put(1,1);

		//Map.entry will give you all the keypairs,
		//.keySet will give me the set that contains all of the keys
		Set<String> keysForStudentCityLookup = studentCityLookup.keySet();
		for (String studentEmail : studentCityLookup.keySet()){
			System.out.println("I have the info for " + studentEmail);

			String studentCity = studentCityLookup.get(studentEmail);
			System.out.println("They live in " + studentCity);

			// have for each that has key value pairs together

			for(Map.Entry<String, String> kvp : studentCityLookup.entrySet()){
				System.out.println("Key" + kvp.getKey() + "value" + kvp.getValue());

			}
			 //Don't look up a key by using a loop
			for(Map.Entry<String,String> kvp : studentCityLookup.entrySet()){
				if (kvp.getKey().equals("lilly@lilly.com")) {
					System.out.println("Lilly lives in " + kvp.getValue());
				}
			}

		}

		//Create a map taking in a key for the SS Number (Integer)
		//Value String of fav color
		//Test if 44444444 is in the map?


		Map<Integer,String> studentColorLookup = new HashMap<>();
		studentColorLookup.put(123456789, "BLUE");
		studentColorLookup.put(100000000, "Green");
		studentColorLookup.put(223456789, "Red");
		studentColorLookup.put(223456788, "Purple");

		String color4444444 = studentColorLookup.get(44444444);
		System.out.println("This color is " + color4444444);


		if(studentColorLookup.containsKey(44444444)){
			studentColorLookup.get(44444444);
			System.out.println("This color is " + color4444444);
		} else {
			System.out.println("This color is not in map");
		}

		//Next question: Create a map where the key is your last name and the vlaue is your quiz
		//score for today (make it up)
		Map<String,Integer> studentQuizLookup = new HashMap<>();
		studentQuizLookup.put("Alam", 100);
		studentQuizLookup.put("Murphy", 99);
		studentQuizLookup.put("Soliz", 90);
		studentQuizLookup.put("Snyder", 80);

/*		This does not update score in Map
		for (Integer quizScore : studentQuizLookup.values()){
			System.out.println("The name of" + studentQuizLookup.get+ "got" + quizScore +5);
		}
*/
		for (String lastName: studentQuizLookup.keySet()){
			int quizScore = studentQuizLookup.get(lastName);
			quizScore +=5;
			studentQuizLookup.put(lastName,quizScore);
		}

		//Check if the map contains a value
		//Does anyone have a favorite color of blue?

		System.out.println("Is anyones fav color blue?" + studentColorLookup.containsValue("BLUE"));
		//CASE SENSITIVE!

	}

}
