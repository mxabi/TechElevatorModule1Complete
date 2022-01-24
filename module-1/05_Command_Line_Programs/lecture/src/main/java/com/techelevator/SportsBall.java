package com.techelevator;

import java.util.Scanner;

public class SportsBall  {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.util);
        //prompt the user for the number of players
        System.out.println("Welcome to the world of Sportsball! How many players are there?");
        String strPlayerCount = scanner.nextLine();
        int playerCount = Integer.parseInt(strPlayerCount);

        String[] strPlayerNames = new String[playerCount];
        double[] battingAvgs = new double[playerCount];

        //for each player
        for (int i =0; i<playerCount;i++){
            //prompt for the players name
            System.out.println("What are the players names?");
            String playerName = scanner.nextLine();
            strPlayerNames[i] = playerName;
            //prompt for the players time at bat
            System.out.println("What are the players times at bat?");
            int playerBatTime = Integer.parseInt(scanner.nextLine());
            //prompt for the players number of hits
            System.out.println("What are the players number of hits?");
            int playerHits = Integer.parseInt(scanner.nextLine());

            if(playerBatTime >0){
                double battingAvg = (double)playerHits/playerBatTime;
                battingAvgs[i] = battingAvg;
            } else {
                battingAvgs[i] =0;
            }


        }
    }
}
