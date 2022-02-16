package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class FizzWriter {

	public static void main(String[] args) {

		String fileName = "FizzBuzz.txt";
		File newFile = new File(fileName);
		try {
			newFile.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try (PrintWriter writer = new PrintWriter(fileName)) {

			int i = 1;

			while (i <= 300) {

				if (i % 3 == 0 && i % 5 == 0) {
					writer.println("FizzBuzz");

				}

				else if (i % 3 == 0 || String.valueOf(i).contains("3")) {
					writer.println("Fizz");
				}

				else if (i % 5 == 0 || String.valueOf(i).contains("5")) {
					writer.println("Buzz");
				} else {
					writer.println(i);
				}

				i++;
			}

			System.out.println("FizzBuzz.txt has been created.");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
