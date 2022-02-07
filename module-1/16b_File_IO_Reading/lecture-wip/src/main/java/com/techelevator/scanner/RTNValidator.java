package com.techelevator.scanner;

import jdk.jshell.spi.ExecutionControlProvider;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RTNValidator {
	
	private static final int[] CHECKSUM_WEIGHTS = new int[] { 3, 7, 1, 3, 7, 1, 3, 7, 1 };
	private static Scanner userInput = new Scanner(System.in); //the scanner that's initialized to System.in should only be created ONCE

	public static void main(String[] args) throws FileNotFoundException {

		printApplicationBanner(); //prints a fancy message
		
		File inputFile = getInputFileFromUser();
		if (inputFile ==null){
			System.out.println("Can't do anything with a bad file");
		}
		else {
			try (Scanner fileScanner = new Scanner(inputFile)) {
				while (fileScanner.hasNextLine()) {
					String line = fileScanner.nextLine();
					try {
						String rtn = line.substring(0, 9);

						if (checksumIsValid(rtn) == false) {
							System.out.println(line);
						}
					} catch (StringIndexOutOfBoundsException e){
						System.out.println(line+" is not length 10. Skipping...");
					} catch (NumberFormatException e){
						System.out.println(line + " contains non-numeric characters");
					}
				}
			}
		}
	}

	private static void printApplicationBanner() {
		System.out.println("******************");
		System.out.println("RTN Validator 9000");
		System.out.println("******************");
		System.out.println();
	}

	@SuppressWarnings("resource")
	private static File getInputFileFromUser() {

		System.out.print("Please enter path to input file >>> ");
		String path = userInput.nextLine();
		
		File inputFile = new File(path);
		if(inputFile.exists() == false) { // checks for the existence of a file
			System.out.println(path+" does not exist");
			//System.exit(1); // Ends the program
			//return null for bad stuff
			inputFile = null;
		} else if(inputFile.isFile() == false) {
			System.out.println(path+" is not a file");
			//System.exit(1); // Ends the program
			inputFile = null;
		}
		return inputFile;
	}

	private static boolean checksumIsValid(String routingNumber) {
		int checksum = 0;
		for(int i = 0; i < 9; i++) {
			int digit = Integer.parseInt(routingNumber.substring(i, i+1));
			checksum += digit * CHECKSUM_WEIGHTS[i];
		}
		return checksum % 10 == 0;
	}
}
