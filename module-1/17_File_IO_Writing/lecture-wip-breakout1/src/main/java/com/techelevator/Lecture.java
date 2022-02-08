package com.techelevator;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Lecture {

	public static void main(String[] args) throws IOException {

		Scanner userInput = new Scanner(System.in);

		/*
		 * The java.io.File class is a representation of file and directory path names.  It provides methods to inspect and
		 * modify file system objects.
		 *
		 * One benefit is that it compensates for differences in Windows and Unix use of '/' and '\' as directory delimiters.
		 *
		 * A new instance of File can be created from a String that contains a file system path
		 *
		 * A buffer is like a bucket that you catch water in. Once it's full, you dump it out and fill it again.
		 *
		 * Flushing a buffer means transmitting any accumulated character output toa file
		 * Forgetting to close the stream leaves it open in write mode. - good reason to use the try-with-resources block
		 */

		fileCreateDeleteDemo();

		PrintWriter pw = new PrintWriter("createAndWriteToFile.txt");//create and open the file for writing. it will REPLACE the contents of the file
		pw.println("Write more stuff in the file");
		pw.close();//flushes the buffer and closes it

		//makes life easier to use a try with resources
		try (PrintWriter anotherWriter = new PrintWriter("fileB.txt")){ //this will automatically close the file
			anotherWriter.println("here's some stuff");
		}

		//end result - there's a file in the lecture directory called numbers and it contains all the numbers 1-100 each on a separate line

		System.out.println("done");

	}

	private static void fileCreateDeleteDemo() throws IOException {
		File myFile = new File("C:\\Users\\KatieDwyer\\workspace\\instructor-code\\module-1\\14_Unit_Testing\\Testing_Defs.html");
		printFileInfo(myFile);

		File testFile = new File("test.txt");
		printFileInfo(testFile);

		File directory = new File("src/test"); //the file path and name is relative to where the pom.xml file is
		printFileInfo(directory);

		File fileNotFound = new File("fileDoesntExist"); //the file path and name is relative to where the pom.xml file is
		printFileInfo(fileNotFound);

		File directoryDoesntExist = new File("C:\\Users\\KatieDwyer\\workspace\\instructor-code\\module-1\\17_File_IO_Writing\\dira\\dirb\\dirc");
		printFileInfo(directoryDoesntExist);

		boolean createdFile = createFile("fileRightHere.txt");
		System.out.println("Created file: "+createdFile);
		createdFile = createFile("C:\\Users\\KatieDwyer\\adventofcode\\exampleFileDeleteMe.txt");
		System.out.println("Created file: "+createdFile);

		createdFile = createFile("C:\\Users\\KatieDwyer\\dira\\dirb\\dirc\\exampleFileDeleteMe.txt");
		System.out.println("Created file: "+createdFile);

		boolean createDir = createDir("newDirectoryDeleteMe");
		System.out.println("Dir was created: "+createDir);

		createDir = createDir("dir1\\dir2");
		System.out.println("Dir was created: "+createDir);

		File useDirAndNameExample = new File("C:\\Users\\KatieDwyer\\workspace\\instructor-code\\module-1\\17_File_IO_Writing\\lecture-final","NewFileName.txt");
		useDirAndNameExample.createNewFile();
		//and now delete it
		useDirAndNameExample.delete();
	}

	private static boolean createDir(String pathandname){
		//return true if it was created, false otherwise
		File newFile = new File(pathandname);
		if (newFile.exists()){
			return false;
		} else {
			try {
				return newFile.mkdir();
			} catch (Exception e) {
				System.out.println("ERROR CREATING DIR "+e.getMessage());
				//e.printStackTrace();

			}
		}
		return false; //if we get caught in the catch then it wasn't created successfully, let's return false
	}

	private static boolean createFile(String pathandname){
		//return true if it was created, false otherwise
		File newFile = new File(pathandname);
		if (newFile.exists()){
			return false;
		} else {
			try {
				return newFile.createNewFile();
			} catch (IOException e) {
				System.out.println("ERROR CREATING FILE "+e.getMessage());
				//e.printStackTrace();

			}
		}
		return false; //if we get caught in the catch then it wasn't created successfully, let's return false
	}

	private static void printFileInfo(File myFile) {
		if (myFile.exists()){
			System.out.println("The file "+ myFile.getName()+" exists.");
			System.out.println("File length: "+myFile.length());
		} else {
			System.out.println("The file "+myFile.getName()+" does not exist");
		}
		if (myFile.isFile()){
			System.out.println("Is a file");
		} else {
			System.out.println("Not a file");
		}
		System.out.println("Absolute path: "+ myFile.getAbsolutePath());
		System.out.println("Absolute file: "+ myFile.getAbsoluteFile());

		//parent info
		System.out.println("**Parent Info**");
		File parent = myFile.getParentFile();
		if (parent==null){
			System.out.println("Parent does not exist");
		} else {
			System.out.println("Parent Info: exists:"+parent.exists()+" path:"+parent.getPath());
		}
	}

}
