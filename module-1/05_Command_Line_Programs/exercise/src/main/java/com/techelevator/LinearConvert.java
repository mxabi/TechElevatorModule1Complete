package com.techelevator;

import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("Enter the length: ");
		double len = scan.nextInt();

		System.out.println("Is this in meters or feet?");
		String length = scan.nextLine().toLowerCase();

		System.out.println("the original length was: " + len + "in " +length + " converted " +
				" length is"+ doConversion(length,len));

	}

	public static double doConversion(String length, double len) {
		double convertedLen;
		if (length.equals("meters")) {
			convertedLen = (double) len * 0.348;
			System.out.println("meters to feet conversion is: " + convertedLen);
		} else {
			convertedLen = (double) len * 3.2808399;
			System.out.println("feet to meters conversion is: " + convertedLen);
		}
		return  convertedLen;
	}

}
