package com.techelevator;

import java.util.Locale;
import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("Welcome to Temp Converter");

		System.out.println("Enter temperature in Fahrenheit: ");
		int temp = scan.nextInt();
		scan.nextLine();

		System.out.println("Is the temperature in F or C? ");
		String fOrC = scan.nextLine();

		System.out.println(temp + "is old temperature" + doConversion(temp,fOrC) +fOrC);
	}

	public static int doConversion(int temp, String fOrC) {

		if (fOrC.toUpperCase().startsWith("F")) {
			int tempC = (int) ((temp - 32) / 1.8);
			return tempC;
		} else {
			int tempF = ((int) (temp * 1.8 + 32));
			return tempF;
		}
	}
}

