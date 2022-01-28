package com.techelevator;

import java.util.Scanner;

public class DecimalToBinary {

	public static void main(String[] args) {

		try (Scanner in = new Scanner(System.in)) {
			System.out.println("Please enter in a series of decimal values (separated by spaces):");
			String values = in.nextLine();
			String[] valuesSeparated = values.split(" ");

			for (int i = 0; i < valuesSeparated.length; i++) {
				int decimalValues = Integer.parseInt(valuesSeparated[i]);
				String bin = Integer.toBinaryString(decimalValues);
				System.out.println(decimalValues + " " + "in binary is" + " " + bin);

			}

		}


	}

}
