package com.techelevator;

public class Lecture {

	public static void main(String[] args) {
		
		/*
		1. Create a variable to hold an int and call it numberOfExercises.
			Then set it to 26.
		*/
		int numberOfExercises = 26;
		System.out.println(numberOfExercises);

		/*
		2. Create a variable to hold a double and call it half.
			Set it to 0.5.
		*/
		double half = 0.5;
		System.out.println(half);

		/*
		3. Create a variable to hold a String and call it name.
			Set it to "TechElevator".
		*/
		String name = "TechElevator";
		System.out.println(name);

		/*
		4. Create a variable called seasonsOfFirefly and set it to 1.
		*/

		int seasonsOfFirefly = 1;
		System.out.println(seasonsOfFirefly);

		/*
		5. Create a variable called myFavoriteLanguage and set it to "Java".
		*/
		String myFavoriteLanguage = "Java";
		System.out.println(myFavoriteLanguage);
		/*
		6. Create a variable called pi and set it to 3.1416.
		*/
		double pi = 3.1416;
		System.out.println(pi);

		/*
		7. Create and set a variable that holds your name.
		*/
		String myName = "Abeda";
		System.out.println(myName);
		/*
		8. Create and set a variable that holds the number of buttons on your mouse.
		*/

		int numOfButtons = 3;
		System.out.println(numOfButtons);

		/*
		9. Create and set a variable that holds the percentage of battery left on
		your phone.
		*/
		int batteryLife = 90;
		System.out.println(batteryLife + "%");

		/*
		10. Create an int variable that holds the difference between 121 and 27.
		*/
		int difference = 121-27;
		System.out.println(difference);
		/*
		11. Create a double that holds the addition of 12.3 and 32.1.
		*/
		double addition = 12.3 +32.1;
		System.out.println(addition);
		/*
		12. Create a String that holds your full name.
		*/
		String myFullName = "Abeda Alam";
		System.out.println(myFullName);
		/*
		13. Create a String that holds the word "Hello, " concatenated onto your
		name from above.
		*/
		String greeting = "Hello, " + myFullName;
		System.out.println(greeting);
		/*
		14. Add a " Esquire" onto the end of your full name and save it back to
		the same variable.
		*/

		myFullName = myFullName + " Esquire";
		System.out.println(myFullName);

		/*
		15. Now do the same as exercise 14, but use the += operator.
		*/
		myFullName += " Esquire";
		System.out.println(myFullName);
		/*
		16. Create a variable to hold "Saw" and add a 2 onto the end of it.
		*/
		String saw2 = "Saw " + "2";
		System.out.println(saw2);
		/*
		17. Add a 0 onto the end of the variable from exercise 16.
		*/
		saw2+= 0;
		System.out.println(saw2);
		/*
		18. What is 4.4 divided by 2.2?
		*/
		double div = 4.4/2.2;
		System.out.println(div);

		/*
		19. What is 5.4 divided by 2?
		*/
		double divBy2 = 5.4/2;
		System.out.println(divBy2);
		/*
		20. What is 5 divided by 2?
		*/
		int anotherDiv = 5/2;
		System.out.println(anotherDiv);
		/*
		21. What is 5.0 divided by 2?
		*/
		double div3 = 5.0/2;
		System.out.println(div3);
		/*
		22. What is 66.6 divided by 100? Is the answer you get right or wrong?
		*/
		float div4 = 66.6F/100; //literal suffix is same as explicit cast of literal
		System.out.println(div4);

		/*
		23. If I divide 5 by 2, what's my remainder?
		*/
		double remainder = 5%2;
		System.out.println(remainder);
		/*
		24. What is 1,000,000,000 * 3?
		*/
		double multiply = 100000000*3;
		System.out.println(multiply);

		long mult = (long)1000000000*3;
		System.out.println(mult);
		/*
		25. Create a variable that holds a boolean called doneWithExercises and
		set it to false.
		*/
		boolean doneWithExercises = false;
		/*
		26. Now set doneWithExercise to true.
		*/

		doneWithExercises = true;
		System.out.println(doneWithExercises);
		
	}

}
