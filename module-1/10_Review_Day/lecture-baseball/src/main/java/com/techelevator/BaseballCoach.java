package com.techelevator;

import java.util.Locale;
import java.util.Scanner;

public class BaseballCoach {
    public static void main(String[] args){

        String myStr = "Test";
        String allLower = myStr.toLowerCase(); //this RETURNS A NEW STRING, it doesn't modify myStr

        Scanner scanner = new Scanner(System.in);

        //prompt the user for the number of players
        System.out.println("Welcome to the baseball app! How many players?");
        String strPlayerCount = scanner.nextLine();
        int playerCount = Integer.parseInt(strPlayerCount);

 //       String[] playerNames = new String[playerCount];
 //       double[] battingAverages = new double[playerCount];

        //don't want to have seperate arrays:
        //  int[] playerAge;
        //int[] playerJersey;

        //instead create a baseball player class
        //use that code

        //int[] timesAtBat  = new int[playerCount];
        //int[] hits = new int[playerCount];

        BaseBallPlayer [] players = new BaseBallPlayer[playerCount];
        //for each player
        for (int i=0; i<playerCount; i++) {
            //  prompt for the players name
            System.out.println("Enter player "+i+" name: ");
            String playerName = scanner.nextLine();
            //playerNames[i] = playerName;

            //  prompt for the players times at bat
            //todo - the number of atbats must be positive
            System.out.println("How many times has "+playerName+" been at bat?");
            String strBats = scanner.nextLine();
            int bats = Integer.parseInt(strBats);

            //  prompt for the players number of hits
            int hits = -1;
            while(hits<0 || hits>bats) { //if hits is negative or more than times at bat, keep prompting
                System.out.println("How many hits does " + playerName + " have (must be > 0 and <= times at bat)?");
                String strHits = scanner.nextLine();
                hits = Integer.parseInt(strHits);
            }
                /*
            if (bats>0){
                double battingAverage = (double)hits/bats;
                //battingAverages[i] = battingAverage;
            } else {
                battingAverages[i]=0;
            }
                */
            //once i have all the info, create a player and add it to the array
            BaseBallPlayer player = new BaseBallPlayer(playerName, bats,hits);
            players[i] =player;
        }


        System.out.println("Thank you. Here are your results: ");

        //after all the data has been gathered
        //for each player
        for(int i = 0; i<playerCount; i++) {
            // print the players name and batting average (hits/at bat, 3 decimal places)
            //todo format this nicer
           //System.out.println("Name: "+playerNames[i]+" Batting Average: "+battingAverages[i]);
            System.out.println("Name " + players[i].getName() + " Batting Average: " + players[i].getPrettyBattingAvg());
        }

        //print the name of the player with the best batting average

    }
}
