package com.techelevator;

public class Examples {

	public static void main(String[] args) {
		int x;
		int y;

		System.out.println("*******************************************");
		System.out.println("**** INCREMENT AND DECREMENT OPERATORS ****");
		System.out.println("*******************************************");
		System.out.println();

		/* The ++ operator increments a variable by 1 (i.e. adds one to the
		 * value of the variable and assigns the result to the variable) */
		x = 1;
		System.out.println("x == " + x);
		x++; //x = x + 1;
		System.out.println("x++ == " + x);
		System.out.println();

		/* The -- operator decrements a variable by 1 (i.e. subtracts one from the
		 * value of the variable and assigns the result to the variable) */
		x = 1;
		System.out.println("x == " + x);
		x--;
		System.out.println("x-- == " + x);
		System.out.println();

		// when the ++ is used as a postfix operator the increment is performed after evalutation
		System.out.println("x = 1");
		x = 1;
		System.out.println("y = x++");
		y = x++; //take the current value of x and set y to it and THEN increment x
		//y=x++; vs y=++x;
		System.out.println("x == " + x);
		System.out.println("y == " + y);
		System.out.println();

		// when the ++ is used as a prefix operator the increment is performed before evalutation
		System.out.println("x = 1");
		x = 1;
		System.out.println("y = ++x");
		y = ++x;
		System.out.println("y == " + y);
		System.out.println("x == " + x);
		System.out.println();

		System.out.println("****************************************");
		System.out.println("**** SHORTHAND ASSIGNMENT OPERATORS ****");
		System.out.println("****************************************");
		System.out.println();

		/* The "shorthand operators" are ( += -= *= ).  They have the
		 * effect of applying the arithmetic operator on the variable
		 * on the left and the expression on the right and then assigning
		 * the result to the variable on the left.
		 *
		 * So, this:
		 *
		 *     x = x + 2;
		 *
		 * Is equivalent to this:
		 *
		 *     x += 2;
		 */
		System.out.println("x = 0");
		x = 0;
		System.out.println("y = 0");
		y = 0;

		System.out.println("x += 5");
		x += 5;
		System.out.println("x == " + x);

		// the right hand side of the operator can be an expression
		System.out.println("y += x * 2 + 3");
		y += x * 2 + 3;
		System.out.println("y == " + y);
		System.out.println();

		System.out.println("*******************");
		System.out.println("**** FOR LOOPS ****");
		System.out.println("*******************");
		System.out.println();


		//FOR LOOP SYNTAX
		// for(init action; continuation condition; end of iteration action) {
		//    stuff in the for loop
		// }
		//for (;;){} //is an infinite for loop

		System.out.println("Displaying the numbers 0 - 9 using a for loop");

		for (int ix = 0; ix < 10; ix++) { //ix is scoped to the for loop
			System.out.println(ix);
		}
		System.out.println();

		// Print whether each number between 1 and 10 (inclusive) is even or odd
		for (int ix = 1; ix <= 5; ix++) {
			if (ix % 2 == 0) {
				System.out.println(ix + " is even");
			} else {
				System.out.println(ix + " is odd");
			}
		}
		System.out.println();

		// loops can be nested
		System.out.println("Displaying the numbers 1 - 5, five times, using nested for loops");
		for (int ix = 0; ix < 5; ix++) {
			for (int jx = 1; jx <= 5; jx++) {
				System.out.println(jx);
			}
		}  //ix is 0; jx is 1, jx is 2, jx is 3, jx is 4, jx is 5, jx is 6 kick out of innner loop; ix is 1, jx is 1
		System.out.println();

		//better double for loop
		for (int i=0; i<5; i++){
			for (int j=10; j<20; j+=2){
				System.out.println("i: "+i+" j: "+j);
			}
		}

		//does my array contain duplicates?
		int[] array = {1,2,29,1,4,-9,453,4523,3,3,456,2};
		//for each element, compare it to every other element
		boolean hasDups = false; //assume that there are no dups until I find one
		for(int i=0; i<array.length; i++){
			for (int j= i+1; j< array.length; j++ ){
				if (array[i]==array[j]){ //found a dup!
					hasDups = true;
					//bail on the loop
					//break; //leave the  loop immediately
					//continue; // go to the end of this iteration
				}
			}
		}
		System.out.println("Does the array have dups?"+hasDups);

		//demo break and continue
		System.out.println("DEMO Continue vs break");
		System.out.println("START OF CONTINUE LOOP");
		for (int i=0; i<10; i++){ //only going to print even numbers
			if (i%2==1){
				continue;//skips the rest of the loop guts and goes to the end
			}
			System.out.println(i);
		}
		System.out.println("END OF CONTINUE LOOP");
		System.out.println("START OF BREAK LOOP");
		for (int i=0; i<10; i++){ //loop will end at the first odd number
			if (i%2==1){
				break;
			}
			System.out.println(i);
		}
		System.out.println("END OF BREAK LOOP");

		System.out.println("****************");
		System.out.println("**** ARRAYS ****");
		System.out.println("****************");
		System.out.println();

		//to declare and initialize an array
		//datatype[] nameOfTheArray = new datatype[sizeOfTheArray];

		//static initialization
		//datatype[] nameOfTheArray = {comma, separated, element, list};
		int[] arrayDemo = { 80, 8080, 443 }; //static initialization
		//logically equivalent to
        /*
          int[] array = new int[3];
          array[0] = 80;
          array[1] = 8080;
          array[2] = 443;
         */

		//arrays are reference variables so when i pass it into a method or assign another variable, i'm using a reference.
		double[] myArrayofDoubles = {1.1,2.4,34,343.2};
		double[] refVarExample = myArrayofDoubles;

		//THESE REFERENCE THE SAME PLACE IN MEMORY
		refVarExample[0]=99;
		System.out.println("REFERENCE EXAMPLE:" + myArrayofDoubles[0]);//this will print 99!

		int[] arrayOfInts = new int[3];
		arrayOfInts[0]= (int) myArrayofDoubles[0];

		int demo = 1;
		int demoCopy = demo;
		demoCopy = 99; ///i have not changed demo

		// the following line declares an array of Strings with 4 elements
		String[] fruit = new String[4];
		fruit[0] = "Apple";
		fruit[1] = "Orange";
		fruit[2] = "Banana";
		fruit[3] = "Pear";
		System.out.println("I have " + fruit.length + " fruits!");
		for (int index = 0; index < fruit.length; index++) {
			System.out.println(fruit[index]);
		}
		System.out.println();

		// the following array has length 3 even when no values have been assigned.
		String[] trees = new String[3];
		System.out.println("I have room for " + trees.length + " trees!");
		trees[1] = "Maple";
		System.out.println(trees[1]);

		int[] intArray = new int[] { 1, 2, 3 }; // this is how we declare an array literal
		for (int ix = 0; ix < intArray.length; ix++) {
			System.out.print(intArray[ix]);
		}
		System.out.println();
		System.out.println();

		// The same literal syntax would apply to an array of Strings
		String[] stooges = new String[] { "Larry", "Curly", "Moe" };

		/* Arrays are Objects, so they are "passed by reference".  In other words. when assigning
		 * the value of one array variable to another array variable, we are assigning a reference
		 * to the same array to both */
		char[] firstArray = new char[] { 'a', 'b', 'c' };
		char[] secondArray = firstArray;

		secondArray[0] = 'z';
		System.out.println("firstArray[0]: " + firstArray[0]);
		System.out.println("secondArray[0]: " + secondArray[0]);

		//still in main method - this is what unit tests are doing
		int[] myArray = new int[3];
		myArray[0]=99;
		myArray[1]=100;
		myArray[2] = 101;
		int mid = getMiddleElement(myArray);

		System.out.println(mid);

		//print the whole array
		for(int i=0; i<myArray.length; i++){
			System.out.println("Element of myArray at index "+i+" is "+myArray[i]);
		}

		//if we don't know how mnay times to do the loop - use a while
		// while (continuation-condition) {
		//   guts of the loop
		//}

		/* WILL ALWAYS GO INTO THE LOOP ONCE
		 do {

		 } while (continuation-condition);
		 */
	}

	public static int getMiddleElement(int[] array){
		//find the middle index
		int mid = array.length / 2;
		//return the element that's at the middle index
		return array[mid];
	}

}
