package com.techelevator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lecture {

	public static void main(String[] args) {
		System.out.println("####################");
		System.out.println("       LISTS");
		System.out.println("####################");

		/*
		   List
		     -zero indexed
		     -an ordered set of elements accessible by the index
		     -can grow and shrink as you add and remove items
		     -add and remove items from the middle of a list
		 */
		//datatype identifier
		//List<datatype of whats in the list> identifier = new ArrayList<>();
		List<String> students = new ArrayList<>();
		students.add("Lily");
		students.add("Scott");
		students.add("Deserae");

		//instantiation - creating a  new object
		// initialization - goes in the () when you create a new object and sets some data to start out with
		List<String> studentsWithQuestions = new ArrayList<>(17);

		List<String> studentsNeedingHelp = new ArrayList<>(students);

//		List<String> notInstantiatedOnlyDeclared;
//		notInstantiatedOnlyDeclared.add("Evan");

		//List of lists
		List<List<String>> studentsInAllClasses = new ArrayList<>();
		List<String> innerList = new ArrayList<>();
		studentsInAllClasses.add(innerList);

		//a list can contain ANY OBJECTS
		//we'll create our own classes 1/27/2022
		//List<House> ourHouses = new ArrayList<>();
		//List<Student> students = new ArrayList<>();
		//List<BaseballPlayer> players = new ArrayList<>();


		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");

		//print all the items in a list
		for (int i=0; i<students.size(); i++ ){
			System.out.println(students.get(i));
		}


		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################");

		students.add("Lily");
		for (int i=0; i<students.size(); i++ ){
			System.out.println(students.get(i));
		}


		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");

		students.add(0,"Cameron");
		students.add(2,"Jim");
		for (int i=0; i<students.size(); i++ ){
			System.out.println(students.get(i));
		}


		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");

		students.remove(2);
		//DON'T REMOVE THINGS FROM A LIST AS YOU'RE ITERATING THROUGH IT

		//if we need to loop through our list of students and remove all students that start with an L
		//this logically looks like it's going to work, but we'll skip checking the next index every time we remove something
//		for (int i=0; i<students.size(); i++){
//			if (students.get(i).startsWith("L")){
//				students.remove(i);
//			}
//		}
		//instead of removing, create a new list and add it
		List<String> noLStudents = new ArrayList<>();
		for (int i=0; i<students.size(); i++){
			if (students.get(i).startsWith("L")==false){
				noLStudents.add(students.get(i));
			}
		}
		//as an alternative you can walk through the list backwards
		//since we're always removing from the end, we won't skip an index when we remove things
		for (int i=students.size()-1; i>=0; i--){
			if (students.get(i).startsWith("L")){
				students.remove(i);
			}
		}

		//find the middle of the list
		int middle = students.size() / 2;


		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");

		//is lindsey in the list?
		boolean lindseyIsInList = students.contains("Lindsey");
		System.out.println("Is Lindsey in the list?"+lindseyIsInList);

		boolean scottIsInList = students.contains("Scott");
		System.out.println("Is Scott in the list?"+scottIsInList);


		System.out.println("####################");
		System.out.println("Find index of item in List");
		System.out.println("####################");

		int indexOfScott = students.indexOf("Scott");
		System.out.println("Scott is at index: "+indexOfScott);

		int indexOfLindsey = students.indexOf("Lindsey");
		System.out.println("Lindsey is at index: "+indexOfLindsey);

		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");

		//datatype[] identifier= listName.toArray(new datatype[0]);
		String[] studentArray = students.toArray(new String[0]);

		System.out.println("List to string");
		System.out.println(students);

		System.out.println("Array to string");
		System.out.println(studentArray.toString());

		System.out.println("####################");
		System.out.println("Lists can be of objects only so how do we do primitives");
		System.out.println("####################");
		//not allowed
		//List<int> exerciseScoresForZach;
		List<Integer> exerciseScoresForZach = new ArrayList<>();
		exerciseScoresForZach.add(3);
		int scoreOnSecond = 3;
		exerciseScoresForZach.add(scoreOnSecond);
		exerciseScoresForZach.add(2);

		//get the average exercise score for zach
		//get the sum of all the scores
		int sum = 0;
		for (int i=0; i<exerciseScoresForZach.size();i++){ //for every index 0 to the size
			//get teh score at that index
			int score = exerciseScoresForZach.get(i);
			//and add it to the sum
			sum += score;
		}
		//divide the sum by the number of scores
		double average = (double)sum / exerciseScoresForZach.size();
		System.out.println("Zach's average is: "+average);

		System.out.println("####################");
		System.out.println("Lists can be sorted");
		System.out.println("####################");

		//Collections.sort(name of the list);
		Collections.sort(students);//strings will sort alphabetically by default
		Collections.sort(exerciseScoresForZach); //numbers will sort

		System.out.println("Students after sort: "+students);
		System.out.println("Exercises after sort: "+exerciseScoresForZach);

		System.out.println("####################");
		System.out.println("Lists can be reversed too");
		System.out.println("####################");

		Collections.reverse(students);
		System.out.println("Students after reverse: "+students);

		students.add("1Evan");
		students.add("11Zach");
		students.add("2Abeda");
		students.add("100Maddie");
		students.add("Kevin");

		System.out.println("Students right now: "+students);
		Collections.reverse(students);
		System.out.println("Reverse that: "+students);
		Collections.sort(students);
		System.out.println("Sort again: "+students);

		//if you reverse it, you can reverse again to get back to the original order
		//if you sort, there's no way back to the original order

		System.out.println("####################");
		System.out.println("       FOREACH");
		System.out.println("####################");
		System.out.println();

		//calculate the average exerciseScoresForZach using foreach this time
		int sumScores = 0;
		//for(datatype elementName : list/array/collection name)
		for(int score : exerciseScoresForZach){
			System.out.println("Adding "+score+" to the sum");
			sumScores += score;
		}

		//logically equivalent to
		for (int i=0; i<exerciseScoresForZach.size();i++){
			int score = exerciseScoresForZach.get(i);
			sumScores += score;
		}
		double averageB = (double)sumScores / exerciseScoresForZach.size();

		//let's loop through our students using a for-each loop
		//print out the name of the student if it starts with a 1

	}
}
