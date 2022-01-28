package com.techelevator;

public class main {

    public static void main(String[] args) {
        //Create new object
        HomeworkAssignment homework1 = new HomeworkAssignment(90, "Abeda");
        //Test Getters and Setters
        homework1.getEarnedMarks();
        homework1.setEarnedMarks(90);
        System.out.println(homework1.getEarnedMarks());
        System.out.println(homework1.getLetterGrade());



    }
}
