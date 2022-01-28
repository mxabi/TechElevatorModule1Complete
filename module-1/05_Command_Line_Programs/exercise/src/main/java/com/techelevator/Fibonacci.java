package com.techelevator;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int x = 0;
			int numberBefore = 0;
			int numberAfter = 1;
			System.out.println("Please insert a value:");

			x = in.nextInt();

			for (int i = 1; i < x; i++) {
				int sum = numberBefore + numberAfter;
				numberBefore = numberAfter;
				numberAfter = sum;
				i = numberAfter;
				System.out.print(numberBefore + " ");

			}

		}


	}
}

