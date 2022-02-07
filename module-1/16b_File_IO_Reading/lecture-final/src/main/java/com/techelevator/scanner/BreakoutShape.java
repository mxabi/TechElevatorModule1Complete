package com.techelevator.scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class BreakoutShape {
    public static void main(String[] args)  {
        File shapeFile= new File("shapes.txt");//create an abstract representation of the file
        if (shapeFile.exists() && shapeFile.isFile()) {
            try (Scanner fileRead = new Scanner(shapeFile)) {
                while (fileRead.hasNextLine()) {
                    String line = fileRead.nextLine();
                    if (line.toLowerCase().contains("blue")) {
                        System.out.println("Line " + line + " contains a blue shape");
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace(); //since i checked that the file exists, i shouldn't be gettign this exception
            }
        } else {
            System.out.println("Bad file");
        }
    }
}
