package com.techelevator;

import java.util.Scanner;

public class MainProgram {

	public static void main(String[] args) {
		System.out.println("\'5\' cast to an int is: "+((int)'5'));

		Scanner input = new Scanner(System.in);

		//ask the user for a file name
		System.out.println("Enter file to encrypt:");
		String fileName = input.nextLine();

		//ask the user for the shift
		int shift = 0;
		while(shift==0) {
			System.out.println("Caesar Shift:");
			String strShift = input.nextLine();
			try {
				shift = Integer.parseInt(strShift);
			} catch (Exception e) {
				System.out.println("You have entered an invalid shift. It must be a whole number != 0");
			}
		}
		//ask the user for the result file name
		System.out.println("Enter resulting file name:");
		String resultFile = input.nextLine();

		CaesarCipher cc = new CaesarCipher();
		//do it
		if (cc.encryptFile(fileName,resultFile,shift)){
			System.out.println("Your file has been encrypted!");
		} else {
			System.out.println("There was an error encrypting your file.");
		}


	}

}
