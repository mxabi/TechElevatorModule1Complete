package com.techelevator.scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BasicFileRead {
    /*
      Methods exist to read in all of the text of a file. But that all goes into memory so is bad
      A stream refers to a sequence of byes that can read or write to some kind of backing data store/
        - like an assembly line, where you process things as they come thru
      File - there's a class in java.io called file, which is an abstract representation of a file
     */
    public static void main(String[] args)  {

        File inputFile = new File("test.txt");
        Scanner inputFileScanner = null;

        try {
            inputFileScanner = new Scanner(inputFile);
            //while there are lines left to read
            while(inputFileScanner.hasNextLine()){
                //read a line and print to the console and its length
                String line = inputFileScanner.nextLine();
                System.out.print(line + " Length: "+line.length());
                //does the line have the letter a?
                if (line.contains("a"))
                {
                    System.out.println(" Contains an a");
                } else {
                    System.out.println(" Does not contain an a");
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Could not open file");
        } finally {
            inputFileScanner.close(); //this is a bit of a pain
        }

        //try-with-resources  -> this will automatically close it
        //try ( init resource) { ...}
        File rtnFile = new File("rtn.txt");
        try (Scanner inputRtnFile = new Scanner(rtnFile)) {//this try-with-resources will automatically close the scanner at the end of the try
            //while there's stuff to read
            while(inputRtnFile.hasNextLine()){
                //read it
                String line = inputRtnFile.nextLine();
                //do something with it
                //is it greater than 3000?
                System.out.print("Line "+line);
                //try parsing to an int
                boolean parseSuccess = true;
                int lineInt=0;
                try {
                     lineInt = Integer.parseInt(line);
                } catch (NumberFormatException e){
                    System.out.println(" is not a number");
                    parseSuccess = false;
                }
                if (parseSuccess) {
                    if (lineInt > 3000) {
                        System.out.println(" is greater than 3000");
                    } else {
                        System.out.println(" is NOT greater than 3000");
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        System.out.println("end");

    }
}
