package com.techelevator;

import java.util.*;

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
		 */
		//datatype identifier
		//List<datatype of whats in the list> identifier = new ArrayList<>();
		//Declare and instantiate list
		List<String> students = new ArrayList<>();
		students.add("Lily");
		students.add("Scott");
		students.add("Deserae");
		students.add("Abeda");
		students.add("Jim");
//		List<String> notInstantiatedList;// Will get error when you try to use list, null. Declared but not instantiated
//		notInstantiatedList.add("Evan");

		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");


		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################");


		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");


		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");

		students.remove(2);

		// this logically looks like it will work, but it will skip checking next index everytime we removei t.
		for (int i =0; i<students.size(); i++){
			if(students.get(i).startsWith("L")){
				students.remove(i);
			}
		}
		//instead of removing, create a new list, and add it
		List<String> noLStudents = new ArrayList<>();
		for (int i =0; i<students.size(); i++){
			if(students.get(i).startsWith("L") == false){
				noLStudents.add(students.get(i));
			}
		}

		for ( int i = students.size() - 1; i>=0;i--){

		}

		//middle of the list
		int middle = students.size() /2;

		// is lindsey in the list?
		boolean isLindseyinList = students.contains("Lindsey");
		boolean isScottinList = students.contains("Scott");
		System.out.println("Is Lindsey in the list? " + isLindseyinList);
		System.out.println("Is Scott in the list? " + isScottinList);

		//as an alternative you can walk through the list backwards


		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");


		System.out.println("####################");
		System.out.println("Find index of item in List");
		System.out.println("####################");
		 int indexOfScott = students.indexOf("Scott");
		System.out.println("This is the index of " + indexOfScott);

		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");

		String[] studentArray = students.toArray(new String[0]);

		//Lists can be of objects so how do we do primitives?
		//List<int> exerciseScoresForZach;

		List<Integer> exerciseScoresForZach = new ArrayList<>();
		exerciseScoresForZach.add(3);
		int scoreOnSecond =3;
		exerciseScoresForZach.add(scoreOnSecond);
		exerciseScoresForZach.add(2);

		//get average score for Zach

		// get sum of all scores in list
		//divide sum by number of scores
		int sum =0;
		for (int i =0; i<exerciseScoresForZach.size();i++){
			//get score at that index and add it to the sum
			sum+=exerciseScoresForZach.get(i);
		}
		double average = (double)sum/exerciseScoresForZach.size();
		System.out.println("Zachs scores are " + average);

		System.out.println("####################");
		System.out.println("Lists can be sorted");
		System.out.println("####################");

		Collections.sort(students);
		Collections.sort(exerciseScoresForZach);

		System.out.println("Students after sort" + students);
		System.out.println("Students after sort" + exerciseScoresForZach);

		System.out.println("####################");
		System.out.println("Lists can be reversed too");
		System.out.println("####################");

		Collections.reverse(students);
		System.out.println("Students after reverse" + students);

		System.out.println("####################");
		System.out.println("       FOREACH");
		System.out.println("####################");
		System.out.println();
		 int sumScores = 0;
		// for(datatype elementName : list/array/collectionName) {
		for (int score: exerciseScoresForZach) {
			sumScores+=score;
		}

		double avgScore = (double)sumScores/exerciseScoresForZach.size();
		System.out.println(avgScore);

			//print out hte name of the student if it starts with 1
		List<String> names = new ArrayList<String>(Arrays.asList("1Abeda", "Sean", "11Zach", "Kevin"));
		for(String name : names){
			if (name.startsWith("1") == true){
				System.out.println(name);
			}
		}

	}
	public static void stack_and_queue(){
	//let's pretend that we're a browser keeping track of sites visited
		Stack<String> sitesVisted = new Stack();
		sitesVisted.push("www.techelevator.com");
		sitesVisted.push("www.youtube.com");
		sitesVisted.push("www.patriots.com");
		sitesVisted.push("www.clubpenguin.com");

		sitesVisted.peek(); //this will always be clubpenguin.com
		String last = sitesVisted.peek();
		String pop = sitesVisted.pop(); // clubpenguin.com
		pop = sitesVisted.pop(); //patriots.com

		while (sitesVisted.size() >0){
			String popNext = sitesVisted.pop();
			System.out.println(popNext);
		}

		Queue<String> ticketMasterLine = new LinkedList<>();
		ticketMasterLine.offer("Jim");
		ticketMasterLine.offer("Abeda");
		ticketMasterLine.offer("Lindsey");
		ticketMasterLine.offer("Yehudis");
		ticketMasterLine.offer("Kevin");

		//start giving people tickets

		while( ticketMasterLine.size() >0){
			String nowServing = ticketMasterLine.poll(); // gets who is next in line and removes form line
			System.out.println("Now Serving: " + nowServing);
		}

	}

}

