package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class HomeworkAssignment {

    //Create Instance Variables
    public int earnedMarks;
    public int possibleMarks;



    public String submitterName;
    public String letterGrade;



    //Create Getters and Setters

    // Can get and set Earned Marks
    public int getEarnedMarks(){
        return this.earnedMarks;
    }

    public void setEarnedMarks(int earnedMarks) {
        this.earnedMarks = earnedMarks;
    }
    //Can get Possible Marks but not set
    public int getPossibleMarks() {
        return possibleMarks;
    }
    // Can get submitterName
    public String getSubmitterName() {
        return submitterName;
    }

    //Keep track of all submitters & earned marks
    private List<Integer> scores = new ArrayList<>();


    // Can get letterGrade (derived)
    public String getLetterGrade() {
        int result = (earnedMarks)*100/possibleMarks;
        if ( result >= 90){
            return "A";
        }
        if ( result >=80 && result <=89){
            return "B";
        }
        if (result >=70 && result <=79){
            return "C";
        }
        if (result >=60 && result <=69){
            return "D";
        }
        else {
            return "F";
        }
    }

    //Create constructor
    public HomeworkAssignment(int possibleMarks, String submitterName){
        this.possibleMarks = possibleMarks;
        this.submitterName = submitterName;
    }

}
