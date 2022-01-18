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
		//we already have a variable named name above, we cannot declare two variables with the same name
		String myName = "Katie";

		/*
		8. Create and set a variable that holds the number of buttons on your mouse.
		*/
		int numMouseButtons = 3;

		/*
		9. Create and set a variable that holds the percentage of battery left on
		your phone.
		*/
		int percentBatteryLeft = 85;
		System.out.println(percentBatteryLeft + "%");
		//my phone doesn't have decimals, since it's percent we can leave it as a whole number
		//if we made it a double to hold eigthy five and a half percent would it be 85.5 or .855?
		//    hint: it doesn't matter as long as our variable name indicates what to expect for the value

		/*
		10. Create an int variable that holds the difference between 121 and 27.
		*/
		int num10Diff = 121 - 27;

		/*
		11. Create a double that holds the addition of 12.3 and 32.1.
		*/
		double addition = 12.3 + 32.1;

		/*
		12. Create a String that holds your full name.
		*/
		String fullName = "Katie Dwyer";

		/*
		13. Create a String that holds the word "Hello, " concatenated onto your
		name from above.
		*/
		String greeting = "Hello, "+fullName;
		System.out.println(greeting);

		/*
		14. Add a " Esquire" onto the end of your full name and save it back to
		the same variable.
		*/
		fullName = fullName + " Esquire";
		System.out.println("Greeting: "+greeting + "\n"+ "Full name: "+fullName);

		/*
		15. Now do the same as exercise 14, but use the += operator.
		*/
		// x = x +5
		// x += 5
		// THESE ARE EXACTLY THE SAME
		fullName += " Esquire";

		/*
		16. Create a variable to hold "Saw" and add a 2 onto the end of it.
		*/
		String movieTitle = "Saw"+" 2";

		/*
		17. Add a 0 onto the end of the variable from exercise 16.
		*/
		movieTitle += 0; //implicitly converting the 0 to a string
		System.out.println(movieTitle);

		/*
		18. What is 4.4 divided by 2.2?
		*/
		double num18Div = 4.4 / 2.2;
		//double / double => double
		int tryIntVar = (int) (4.4 / 2.2);  //narrowing going from a double to an int; i CAN explicitly convert it if i want to

		/*
		19. What is 5.4 divided by 2?
		*/
		double num19Div = 5.4 / 2;
		//double / int => double

		/*
		20. What is 5 divided by 2?
		*/
		double num20Div = 5 / 2; //integer division
		System.out.println("The result of integer division is always an integer, even if I assign it to a double: "+num20Div);

		/*
		21. What is 5.0 divided by 2?
		*/
		double num21Div = 5.0 / 2;
		//double / int => double

		/*
		22. What is 66.6 divided by 100? Is the answer you get right or wrong?
		*/
		double num22Div = 66.6 / 100;
		System.out.println("22: "+num22Div);

		//literal suffix as an alternate to an explicit cast of a literal
		float f = 66.6F;

		/*
		23. If I divide 5 by 2, what's my remainder?
		*/
		int num23Remainder = 5 % 2;

		/*
		24. What is 1,000,000,000 * 3?
		*/
		int a = 1000000000;
		int b = 3;
		long aTimesB = (long)a * b;
		System.out.println(aTimesB);

		long mult = 1000000000 * 3L;
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

//		boolean boolExp;
//		System.out.println(boolExp);
		
	}

}
