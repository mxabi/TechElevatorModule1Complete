package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordSearch {

	public static void main(String[] args) {

		try (Scanner fileScanner = new Scanner(System.in)) {

			System.out.println("Where is the file that should be searched?");

			File fileToBeSearched = new File(fileScanner.nextLine());

			System.out.println("What is the search word you are looking for?");

			String lookFor = "" + fileScanner.nextLine() + "";

			try (Scanner input = new Scanner(fileToBeSearched)) {

				System.out.println("Should the search be case sensitive? (Y/N)");

				String yesOrNo = fileScanner.nextLine().toLowerCase();
				int line = 0;

				if (yesOrNo.equals("n")) {
					while (input.hasNextLine()) {
						line++;
						String lineCheck = input.nextLine();
						if (lineCheck.contains(lookFor.toLowerCase()) || lineCheck.contains(lookFor.toUpperCase())
								|| lineCheck.contains(
								lookFor.substring(0, 1).toUpperCase() + lookFor.substring(1).toLowerCase())) {
							System.out.println(line + ")" + " " + lineCheck);
						}
					}
				}

				else if (yesOrNo.contentEquals("y")) {
					while (input.hasNextLine()) {
						line++;
						String lineCheck = input.nextLine();
						if (lineCheck.contains(lookFor)) {
							System.out.println(line + ")" + " " + lineCheck);

						}

					}

				}

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("File not found");
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Word not found");
				e.printStackTrace();

			}
		}
	}
}
