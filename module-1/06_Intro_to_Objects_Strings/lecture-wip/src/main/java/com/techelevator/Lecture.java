package com.techelevator;

import java.util.Locale;

public class Lecture {

	public static void exampleMethod(int theFirstParam, String theSecondParam){}

	public static void isStringNull(String testStr){
		if (testStr==null){
			System.out.println("String is null");
		}
	}

	public static void main(String[] args) {

		//House class - data and behavior; countBedrooms, countBathrooms; paint()
		//instantiating the class, creating an object, instantiating an object
		// House katiesHouse = new House(3,1,"2217 Highland Ave");
		String instructorName = new String("Katie");
		//equiv to
		String instructorNameB = "Katie";
		String empty = new String(); //in initialization data => empty paranthese

		exampleMethod(1,"b");
		String nullString ; //this is set to null
		//isStringNull(nullString);

		int x; //undefined
		String strx; //null

		System.out.println("************************************");
		System.out.println("****** MAKING A STRING OBJECT ******");
		System.out.println("************************************");

		/* The String class gets special treatment in the Java language.  One
		 * example of this is that there is a literal representation of a
		 * String (i.e. characters appearing between two double quotes.  This
		 * is not the case for most classes */

		/* create an new instance of String using a literal */
		String exampleUsingLiteral = "literal";
		String oneLetter = "a";
		char chrOneLetter = 'a';

		char convertOneLetterToChar = oneLetter.charAt(0);
		//i can compare characters (and all prmitves with ==)
		//BUT i must compare objects with .equals

		int[] array1 = new int[1];
		int[] array2 = new int[5];
		if (array1[0]==array2[0]){
			System.out.println("int array compare - same");
		}

		String[] strArray = new String[1];
		String[] strArray2 = new String[1];
		if (strArray[0]!= null) {
			if (strArray[0].equals(strArray2[0])) { //if the elements of the array are strings or other objects use .equals
				System.out.println("int array compare - same");
			}
		}

		int[] thisArrayIsNull;

		//to call a method on an object
		//objectname.method();
		String someString = "test";
		boolean areEqual = someString.equals("test");

		System.out.println("This is a method called println");
		
		System.out.println();
		System.out.println("******************************");
		System.out.println("****** MEMBER METHODS ******");
		System.out.println("******************************");
		System.out.println();

		String lowerCase = "this string is in all lowercase";
		String upperCase = lowerCase.toUpperCase();

		String strEx = "test";
		strEx = strEx.toUpperCase();

		/* Other commonly used methods:
		 *
		 * endsWith
		 * startsWith
		 * indexOf
		 * lastIndexOf
		 * length
		 * substring
		 * toLowerCase
		 * toUpperCase
		 * trim
		 * split
		 * equals
		 * equalsIgnoreCase
		 * String.join()
		 */

		String strExample = "this is my test string";
		System.out.println("My string is length "+strExample.length());

		//where is the first m in my string?
		int indexOfFirstM = strExample.indexOf('m');
		System.out.println("the first m is at index "+indexOfFirstM);

		System.out.println("The last s is at "+strExample.lastIndexOf('s'));

		//find the first capital S
		int indexOfFirstCapS = strExample.indexOf('S');
		//find the first s or S
		int indexOfFirstAnyS = strExample.toLowerCase().indexOf('s');

		int indexOfFirstSStartingAtIndexFour = strExample.indexOf('s',4);
		System.out.println("Index of can have an offset of where you start looking. this should be 6: "+indexOfFirstSStartingAtIndexFour);

		//let's demo getCharAt vs substring
		char charFirstChar = strExample.charAt(0);
		String strFirstChar = strExample.substring(0,1);

		//is the first character a t?
		boolean checkChar = charFirstChar=='t' || charFirstChar=='T';
		boolean checkStr = strFirstChar.equalsIgnoreCase("T");

		//ends with and starts with
		boolean testBool = strExample.startsWith(strFirstChar);
		if (testBool){
			System.out.println("It's true!");
		} else {
			System.out.println("It's false!");
		}

		System.out.println("Does "+strExample+" end with a . ? "+strExample.endsWith("."));

		System.out.println();
		System.out.println("**********************");
		System.out.println("****** EQUALITY ******");
		System.out.println("**********************");
		System.out.println();

        char[] helloArray = new char[] { 'H', 'e', 'l', 'l', 'o' };
        String hello1 = new String(helloArray);
        String hello2 = new String(helloArray);

		/* Double equals will compare to see if the two variables, hello1 and
		 * hello2 point to the same object in memory. Are they the same object? */
		if (hello1 == hello2) {
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello2);
		}

		String hello3 = hello1;
		if (hello1 == hello3) {
			System.out.println("hello1 is the same reference as hello3");
		}

		/* So, to compare the values of two objects, we need to use the equals method.
		 * Every object type has an equals method */
		if (hello1.equals(hello2)) {
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello2);
		}

	}

	//Do characters 3-5 in s1 match characters 3-5 in s2?
	//s1 = "0123456789", s2="0123456789" =>yes
	//s1 = "0123456789", s2="9993456789" =>yes
	//s1 = "0123456789", s2="0124456789" =>no
	public static boolean doStringMiddlesMatch (String s1, String s2, boolean caseSensitive){
		String s1Sub = s1.substring(3,6);
		String s2sub = s2.substring(3,6);
		if (caseSensitive && s1Sub == s2sub){
			return true;
		}
		return s1.equalsIgnoreCase(s2)
;	}
}
