package sample;

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.Scanner;

public class FXMain extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Scanner sc = new Scanner(System.in);

        //create a object
        PremierLeagueManager premierLeagueManager = new PremierLeagueManager();

        //Recovering existing data into a new program
        try {
            premierLeagueManager.restoreData();
            premierLeagueManager.restoreData2();
            premierLeagueManager.restoreData3();
        } catch (Exception e) {
            System.out.println("Data store file is empty");
        }

        try {
            //Things user can do in this program
            while (true) {
                System.out.println("******************************************************************** Premier League Manager ********************************************************************");
                System.out.println("Add football club - 1");
                System.out.println("Delete football club - 2");
                System.out.println("Club Statistics with reg no. - 3");
                System.out.println("Premier League Table - 4");
                System.out.println("Add a played match - 5");
                System.out.println("Open graphic user interface - 6");
                System.out.println("Enter 7 For Store Data and Exit Program");

                //Choose what the user wants to do
                System.out.println("Please choose your option :");
                int o = sc.nextInt();

                if (o == 1) {
                    premierLeagueManager.addFootBallClub();
                } else if (o == 2) {
                    premierLeagueManager.deleteFootBallClub();
                } else if (o == 3) {
                    premierLeagueManager.displayStatistics();
                } else if (o == 4) {
                    premierLeagueManager.displayTable();
                } else if (o == 5) {
                    premierLeagueManager.addPlayedMatch();
                } else if (o == 6) {
                    premierLeagueManager.graphicUserInterface();
                } else if (o == 7) {
                    premierLeagueManager.storeDataInFile();
                    premierLeagueManager.storeDataInFile2();
                    premierLeagueManager.storeDataInFile3();
                    System.out.println("Data store in file Successfully");
                    break;
                } else {
                    //This message is displayed if the user has entered incorrect input
                    System.out.println("Please enter 1,2,3,4,5 or 6");
                }
            }
        } catch (Exception e) {
            //This message is displayed if the user has entered incorrect input
            System.out.println("Please enter valid input");
        }
    }
}