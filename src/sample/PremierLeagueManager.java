package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Random;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.ArrayList;

public class PremierLeagueManager implements LeagueManager{

    //Introducing the scenes to use
    Scene sceneMain,sceneRand,sceneRandDone,sceneSearch3;

    //Create an arraylist to use

    //Arraylist to store clubs data
    ArrayList<FootBallClub> arrayList = new ArrayList();
    //Arraylist to played matches data
    ArrayList<PlayedMatchDetails> playedMatchArrayList = new ArrayList<>();
    //Arraylist to store played random match data
    ArrayList<PlayedMatchDetails> randomMatchArray = new ArrayList<>();
    //Arraylist to store matches data with date
    ArrayList<DateInfo> matchDateInfo = new ArrayList<>();

    @Override
    //Method for adding new football club
    public void addFootBallClub(){
        Scanner sc = new Scanner(System.in);

        //Create a object to store data
        FootBallClub footBallClub = new FootBallClub();

        //get football club details
        try{
            //take Football club Reg no.
            System.out.println("Enter Sports Club Reg No. : ");
            int clubRegNo = sc.nextInt();
            footBallClub.setSportsClubRegNo(clubRegNo);

            //take Football club name
            System.out.println("Enter Sports Club Name : ");
            String clubName = sc.next();
            footBallClub.setSportsClubName(clubName);

            //take Football club location
            System.out.println("Enter Sports Club Address : ");
            String clubLocation = sc.next();
            footBallClub.setSportsClubLocation(clubLocation);

            //take Football club contact number
            System.out.println("Enter Sports Club Contact No. : ");
            int contactNo = sc.nextInt();
            footBallClub.setContactNo(contactNo);

            //take number of wins matches
            System.out.println("Enter Number Of Wins : ");
            int clubWins = sc.nextInt();
            footBallClub.setNumOfClubWins(clubWins);

            //take number of defeats matches
            System.out.println("Enter Number Of Defeats : ");
            int clubDefeats = sc.nextInt();
            footBallClub.setNumOfClubDefeats(clubDefeats);

            //take number of draws matches
            System.out.println("Enter Number Of Draws : ");
            int clubDraws = sc.nextInt();
            footBallClub.setNumOfClubDraws(clubDraws);

            //take Number Of Received Goals
            System.out.println("Enter Number Of Received Goals : ");
            int clubGoals = sc.nextInt();
            footBallClub.setNumOfClubGoals(clubGoals);

            //take total scores
            System.out.println("Enter Scores : ");
            int clubScores = sc.nextInt();
            footBallClub.setNumOfClubScores(clubScores);

            //calculate the total number of matches from the data previously entered by the user
            footBallClub.setNumOfClubMatches(footBallClub.getNumOfClubWins()+footBallClub.getNumOfClubDefeats()+footBallClub.getNumOfClubDraws());
            System.out.println("Number Of Matches : " + footBallClub.getNumOfClubMatches());

            //calculate the total number of points from the data previously entered by the user
            footBallClub.setClubPoints(footBallClub.getNumOfClubDraws()+(footBallClub.getNumOfClubWins()*3));
            System.out.println("Number Of Points : " + footBallClub.getClubPoints());

            //add football clubs details to arraylist
            arrayList.add(footBallClub);

            //This message will be displayed if the user has entered all the data correctly
            System.out.println("Sports Club details added successfully.");
        } catch (Exception e) {
            //This message is displayed if the user has entered incorrect data
            System.out.println("Please enter correct details");
        }
    }

    @Override
    //Method for deleting football club
    public void deleteFootBallClub() {
        Scanner scanner = new Scanner(System.in);

        //take a football club reg no. user want to delete
        System.out.println("Enter Club Reg. No You Want To Delete : ");
        int delRegNo = scanner.nextInt();

        int delete = 0;
        SportsClub sportsClub = null;

        for (int i = 0; i < arrayList.size(); i++) {
            //Check if the Reg no. to delete is in the arraylist
            if (delRegNo == arrayList.get(i).getSportsClubRegNo()) {
                sportsClub = arrayList.get(i);
                arrayList.remove(i);
                delete = 1;
            }
        }

        //This message appears when the number to delete is not found
        if (delete == 0) {
            System.out.println("Cannot find the Reg No you want to delete.");

        //This message will be displayed after deleting the football club
        } else if (delete == 1){
            System.out.println("Sports Club details Delete Successful.");
        }
    }

    @Override
    //Method for display statistics
    public void displayStatistics(){
        Scanner scanner = new Scanner(System.in);

        //take a football club reg no. user want to get statistics
        System.out.println("Enter Club Reg No You Want To Search : ");
        int searchDetails = scanner.nextInt();

        for (int i = 0; i < arrayList.size(); i++ ) {
            FootBallClub footBallClub = arrayList.get(i);

            //Check if the Reg no. to search is in the arraylist
            if(footBallClub.getSportsClubRegNo()==(searchDetails)) {

                //Display statistics
                System.out.println(footBallClub.toString());
            }
        }
    }

    @Override
    //Method for display table
    public void displayTable() {

        //Sort arraylist with points
        Comparator clubComparator = Comparator.comparing(FootBallClub::getClubPoints).thenComparing(FootBallClub::getNumOfClubGoals);
        Collections.sort(arrayList,clubComparator);
        //convert it to descending order
        Collections.reverse(arrayList);

        //print table in console
        System.out.println("********************************************************************  Premier League Table  *********************************************************************");
        System.out.format("%-25s%-15s%15s%15s%15s%15s%20s%20s%20s%n","| Reg No |","| Name |","| Points |","| Wins |","| Defeats |","| Draws |","| Received Goals |","| Scores |","| Matches |");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------");

        //add data in to table
        for (FootBallClub footBallClub : arrayList){
            System.out.format("%-25s%-15s%15s%15s%15s%15s%20s%20s%20s%n",footBallClub.getSportsClubRegNo(),footBallClub.getSportsClubName(),
                    footBallClub.getClubPoints(),footBallClub.getNumOfClubWins(),footBallClub.getNumOfClubDefeats(),
                    footBallClub.getNumOfClubDraws(),footBallClub.getNumOfClubGoals(),footBallClub.getNumOfClubScores(),footBallClub.getNumOfClubMatches());
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }
    }

    @Override
    //Method for add played match
    public void addPlayedMatch() {
        Scanner sc = new Scanner(System.in);

        DateInfo matchDetailswithDate = new DateInfo();
        try{
            //take team 01 reg no.
            System.out.println("Enter Team 1 Sports Club Reg No. : ");
            int clubRegNo1 = sc.nextInt();

            //take team 02 reg no.
            System.out.println("Enter Team 2 Sports Club Reg No. : ");
            int clubRegNo2 = sc.nextInt();

            FootBallClub team1 = null;
            FootBallClub team2 = null;

            for (int i = 0; i < arrayList.size(); i++ ) {
                //check the team no.01 is on the arraylist
                if (arrayList.get(i).getSportsClubRegNo() == (clubRegNo1) )  {
                    team1 = arrayList.get(i);
                    break;
                }
            }

            for (int i = 0; i < arrayList.size(); i++ ) {
                //check the team no.02 is on the arraylist
                if (arrayList.get(i).getSportsClubRegNo() == (clubRegNo2))  {
                    team2 = arrayList.get(i);
                    break;
                }
            }

            if (team1 == null || team2 == null){
                //This message appears when the number of team is not found
                System.out.println("Please enter valid Reg No.");
            } else if (team1 == team2){
                //This message appears when team numbers are same
                System.out.println("Team reg numbers are same");
            } else {
                //take team 01 score
                System.out.println("Enter Team 1 Score : ");
                int team1Score = sc.nextInt();
                //update team 01 score
                team1.setNumOfClubScores(team1.getNumOfClubScores()+team1Score);
                //update number of matches in team 01
                team1.setNumOfClubMatches(team1.getNumOfClubMatches()+1);

                //take team 02 score
                System.out.println("Enter Team 2 Score : ");
                int team2Score = sc.nextInt();
                //update team 02 score
                team2.setNumOfClubScores(team2.getNumOfClubScores()+team2Score);
                //update number of matches in team 02
                team2.setNumOfClubMatches(team2.getNumOfClubMatches()+1);

                //update number of received goals in team 02
                team2.setNumOfClubGoals(team2.getNumOfClubGoals()+team1Score);
                //update number of received goals in team 01
                team1.setNumOfClubGoals(team1.getNumOfClubGoals()+team2Score);

                //team 01 win the match
                if (team1Score > team2Score){
                    //update team 01 wins
                    team1.setNumOfClubWins(team1.getNumOfClubWins()+1);
                    //update team 02 defeats
                    team2.setNumOfClubDefeats(team2.getNumOfClubDefeats()+1);
                    //update team 01 points
                    team1.setClubPoints((int) team1.getClubPoints()+3);
                }
                //team 02 win the match
                else if (team2Score > team1Score){
                    //update team 01 defeats
                    team1.setNumOfClubDefeats(team1.getNumOfClubDefeats()+1);
                    //update team 02 wins
                    team2.setNumOfClubWins(team2.getNumOfClubWins()+1);
                    //update team 02 points
                    team2.setClubPoints((int) team2.getClubPoints()+3);
                }
                //draw the match
                else if (team1Score == team2Score){
                    //update team 01 draws
                    team1.setNumOfClubDraws(team1.getNumOfClubDraws()+1);
                    //update team 02 draws
                    team2.setNumOfClubDraws(team2.getNumOfClubDraws()+1);
                    //update team 01 points
                    team1.setClubPoints((int) team1.getClubPoints()+1);
                    //update team 02 points
                    team2.setClubPoints((int) team2.getClubPoints()+1);
                }

                //create a object for date
                Date date = new Date();

                while (true) {
                    try {
                        //take a match played date
                        System.out.print("Enter date(DD-MM-YYYY) :");
                        String day = sc.nextLine();

                        //create a date format
                        String[] dateArraySplit = day.split("-", 3);
                        int date1 = Integer.parseInt(dateArraySplit[0]);
                        int month1 = Integer.parseInt(dateArraySplit[1]);
                        int year1 = Integer.parseInt(dateArraySplit[2]);

                        //validation for date
                        if (date1 > 0 && date1 < 32 && month1 > 0 && month1 < 13 && year1 > 2019 && year1 < 10000) {
                            date.setDay(date1);
                            date.setMonth(month1);
                            date.setYear(year1);

                            //add date to matchDateInfo arraylist
                            matchDetailswithDate.setMatchPlayDay(date1);
                            matchDetailswithDate.setMatchPlayMonth(month1);
                            matchDetailswithDate.setMatchPlayYear(year1);
                            break;
                        } else {
                            //This message is displayed if the user has entered invalid date
                            System.out.println("Please enter valid date.");
                        }
                    }catch (NumberFormatException e){
                        //This message is displayed if the user has entered invalid date format
                        System.out.println("Please enter valid date.");
                    }
                }
                //This message will be displayed after adding played match details
                System.out.println("Played match details added successfully.");

                //create a object
                PlayedMatchDetails matchDetails = new PlayedMatchDetails();

                //add data to playedMatchArrayList arraylist
                matchDetails.setTeam01(clubRegNo1);
                matchDetails.setTeam02(clubRegNo2);
                matchDetails.setTeam01score(team1Score);
                matchDetails.setTeam02score(team2Score);
                matchDetails.setPlayedMatchDate(date);
                playedMatchArrayList.add(matchDetails);

                //add data to matchDateInfo arraylist
                matchDetailswithDate.setTeam01(clubRegNo1);
                matchDetailswithDate.setTeam02(clubRegNo2);
                matchDetailswithDate.setTeam01score(team1Score);
                matchDetailswithDate.setTeam02score(team2Score);
                matchDateInfo.add(matchDetailswithDate);
            }
        } catch (Exception e) {
            //This message is displayed if the user has entered incorrect details
            System.out.println("Please enter correct details");
        }
    }

    @Override
    //Method for store data in file
    public void storeDataInFile () throws IOException {
        File file1 = new File("clubInformation.txt");
        file1.createNewFile();

        FileOutputStream fileOut = new FileOutputStream(file1);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);

        out.writeObject(arrayList);
        out.flush();
        out.close();
        fileOut.close();
    }

    @Override
    //Method for restore previous data into program
    public void restoreData () throws IOException {
        FileInputStream fileIn = new FileInputStream("clubInformation.txt");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        try {
            arrayList = (ArrayList<FootBallClub>) in.readObject();
            System.out.println("--------------------------------");
            //This message is displayed if the previous data restore in the program
            System.out.println("Previous club Data is in the Program.");
            in.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException e) {
            //This message is displayed when not in the previous data program
            System.out.println("Data can not found");
        }
    }

    @Override
    //Method for open graphical user interface
    public void graphicUserInterface() {
        //create new stage
        Stage stageHome = new Stage();
        //set title
        stageHome.setTitle("Premier League Manager");
        //the trick is not to change the size
        stageHome.setResizable(false);

        //get new anchorpane
        AnchorPane anc01 = new AnchorPane();

        //set background image
        Image image01 = new Image("image01.png");
        ImageView viewImage01 = new ImageView();
        viewImage01.setImage(image01);
        viewImage01.setFitHeight(500);
        viewImage01.setFitWidth(700);

        //set topic
        Label labl01 = new Label("Premier League Manager");
        labl01.setLayoutX(127);
        labl01.setLayoutY(15);
        labl01.setStyle("-fx-font-size: 40;-fx-text-alignment: center");

        //button for table(Descending Order Of Points)
        Button bt01 = new Button("Descending Order Of Points");
        bt01.setLayoutX(205);
        bt01.setLayoutY(90);
        bt01.setStyle("-fx-font-size: 20;-fx-text-alignment: center; -fx-background-radius: 20; -fx-background-color: #7FFFD4");
        bt01.setPrefHeight(30);
        bt01.setPrefWidth(290);
        //set action for button
        bt01.setOnAction(event -> {
            //get new stage for table
            Stage stage01 = new Stage();
            //set title for table window
            stage01.setTitle("Descending Order Of Points");

            //create a table view
            TableView tab01 = new TableView();

            //column for sports club reg no.
            TableColumn<Integer, FootBallClub> col01 = new TableColumn<>("Sports Club Reg No.");
            //add value for reg no. column
            col01.setCellValueFactory(new PropertyValueFactory<>("SportsClubRegNo"));

            //column for sports club name
            TableColumn<String, FootBallClub> col02 = new TableColumn<>("Sports Club Name");
            //add value for name column
            col02.setCellValueFactory(new PropertyValueFactory<>("SportsClubName"));

            //column for sports club location
            TableColumn<String, FootBallClub> col03 = new TableColumn<>("Sports Club Address");
            //add value for location column
            col03.setCellValueFactory(new PropertyValueFactory<>("SportsClubLocation"));

            //column for sports club contact no.
            TableColumn<Integer, FootBallClub> col04 = new TableColumn<>("Contact No.");
            //add value for contact no. column
            col04.setCellValueFactory(new PropertyValueFactory<>("ContactNo"));

            //column for number of win matches
            TableColumn<Integer, FootBallClub> col05 = new TableColumn<>("Number Of Wins");
            //add value for wins column
            col05.setCellValueFactory(new PropertyValueFactory<>("NumOfClubWins"));

            //column for number of defeat matches
            TableColumn<Integer, FootBallClub> col06 = new TableColumn<>("Number Of Defeats");
            //add value for defeats column
            col06.setCellValueFactory(new PropertyValueFactory<>("NumOfClubDefeats"));

            //column for numbers of draw matches
            TableColumn<Integer, FootBallClub> col07 = new TableColumn<>("Number Of Draws");
            //add value for draws column
            col07.setCellValueFactory(new PropertyValueFactory<>("NumOfClubDraws"));

            //column for number of received goals
            TableColumn<Integer, FootBallClub> col08 = new TableColumn<>("Number Of Received Goals");
            //add value for goals column
            col08.setCellValueFactory(new PropertyValueFactory<>("NumOfClubGoals"));

            //column for number of score
            TableColumn<Integer, FootBallClub> col09 = new TableColumn<>("Number Of Score");
            //add value for score column
            col09.setCellValueFactory(new PropertyValueFactory<>("NumOfClubScores"));

            //column for number of matches
            TableColumn<Integer, FootBallClub> col10 = new TableColumn<>("Number Of Matches");
            //add value for number of matches column
            col10.setCellValueFactory(new PropertyValueFactory<>("NumOfClubMatches"));

            //column for number of points
            TableColumn<Integer, FootBallClub> col11 = new TableColumn<>("Number Of Points");
            //add value for club points column
            col11.setCellValueFactory(new PropertyValueFactory<>("ClubPoints"));

            //add columns for table
            tab01.getColumns().addAll(col01,col02,col03,col04,col05,col06,col07,col08,col09,col10,col11);

            //sort table with points
            Comparator clubComparator = Comparator.comparing(FootBallClub::getClubPoints);
            Collections.sort(arrayList,clubComparator);
            Collections.reverse(arrayList);

            //add items to table with arraylist
            for (FootBallClub footBall : arrayList){
                tab01.getItems().add(footBall);
            }

            //add table to scene
            stage01.setScene(new Scene(tab01, 1600, 500));
            stage01.showAndWait();
        });

        //button for table(Descending Order Of goals)
        Button bt02 = new Button("Descending Order Of Goals");
        bt02.setLayoutX(205);
        bt02.setLayoutY(150);
        bt02.setStyle("-fx-font-size: 20;-fx-text-alignment: center; -fx-background-radius: 20; -fx-background-color: #7FFFD4");
        bt02.setPrefHeight(35);
        bt02.setPrefWidth(290);
        //set action for button
        bt02.setOnAction(event -> {
            //get new stage for table
            Stage stage02 = new Stage();
            //set title for table window
            stage02.setTitle("Descending Order Of Goals");

            //create a table view
            TableView tab02 = new TableView();

            //column for sports club reg no.
            TableColumn<Integer, FootBallClub> col01 = new TableColumn<>("Sports Club Reg No.");
            //add value for reg no. column
            col01.setCellValueFactory(new PropertyValueFactory<>("SportsClubRegNo"));

            //column for sports club name
            TableColumn<String, FootBallClub> col02 = new TableColumn<>("Sports Club Name");
            //add value for name column
            col02.setCellValueFactory(new PropertyValueFactory<>("SportsClubName"));

            //column for sports club location
            TableColumn<String, FootBallClub> col03 = new TableColumn<>("Sports Club Address");
            //add value for location column
            col03.setCellValueFactory(new PropertyValueFactory<>("SportsClubLocation"));

            //column for sports club contact no.
            TableColumn<Integer, FootBallClub> col04 = new TableColumn<>("Contact No.");
            //add value for contact no. column
            col04.setCellValueFactory(new PropertyValueFactory<>("ContactNo"));

            //column for number of win matches
            TableColumn<Integer, FootBallClub> col05 = new TableColumn<>("Number Of Wins");
            //add value for wins column
            col05.setCellValueFactory(new PropertyValueFactory<>("NumOfClubWins"));

            //column for number of defeat matches
            TableColumn<Integer, FootBallClub> col06 = new TableColumn<>("Number Of Defeats");
            //add value for defeats column
            col06.setCellValueFactory(new PropertyValueFactory<>("NumOfClubDefeats"));

            //column for numbers of draw matches
            TableColumn<Integer, FootBallClub> col07 = new TableColumn<>("Number Of Draws");
            //add value for draws column
            col07.setCellValueFactory(new PropertyValueFactory<>("NumOfClubDraws"));

            //column for number of received goals
            TableColumn<Integer, FootBallClub> col08 = new TableColumn<>("Number Of Received Goals");
            //add value for goals column
            col08.setCellValueFactory(new PropertyValueFactory<>("NumOfClubGoals"));

            //column for number of score
            TableColumn<Integer, FootBallClub> col09 = new TableColumn<>("Number Of Score");
            //add value for score column
            col09.setCellValueFactory(new PropertyValueFactory<>("NumOfClubScores"));

            //column for number of matches
            TableColumn<Integer, FootBallClub> col10 = new TableColumn<>("Number Of Matches");
            //add value for number of matches column
            col10.setCellValueFactory(new PropertyValueFactory<>("NumOfClubMatches"));

            //column for number of points
            TableColumn<Integer, FootBallClub> col11 = new TableColumn<>("Number Of Points");
            //add value for club points column
            col11.setCellValueFactory(new PropertyValueFactory<>("ClubPoints"));

            //add columns for table
            tab02.getColumns().addAll(col01,col02,col03,col04,col05,col06,col07,col08,col09,col10,col11);

            //sort table with goals
            Comparator clubComparator1 = Comparator.comparing(FootBallClub::getNumOfClubGoals);
            Collections.sort(arrayList,clubComparator1);
            Collections.reverse(arrayList);

            //add items to table with arraylist
            for (FootBallClub footBall : arrayList){
                tab02.getItems().add(footBall);
            }
            //add table to scene
            stage02.setScene(new Scene(tab02, 1600, 500));
            stage02.showAndWait();
        });

        //button for table(Descending Order Of wins)
        Button bt03 = new Button("Descending Order Of Wins");
        bt03.setLayoutX(205);
        bt03.setLayoutY(210);
        bt03.setStyle("-fx-font-size: 20;-fx-text-alignment: center; -fx-background-radius: 20; -fx-background-color: #7FFFD4");
        bt03.setPrefHeight(40);
        bt03.setPrefWidth(290);
        //set action for button
        bt03.setOnAction(event -> {
            //get new stage for table
            Stage stage03 = new Stage();
            //set title for table window
            stage03.setTitle("Descending Order Of Wins");

            //create a table view
            TableView tab03 = new TableView();

            //column for sports club reg no.
            TableColumn<Integer, FootBallClub> col01 = new TableColumn<>("Sports Club Reg No.");
            //add value for reg no. column
            col01.setCellValueFactory(new PropertyValueFactory<>("SportsClubRegNo"));

            //column for sports club name
            TableColumn<String, FootBallClub> col02 = new TableColumn<>("Sports Club Name");
            //add value for name column
            col02.setCellValueFactory(new PropertyValueFactory<>("SportsClubName"));

            //column for sports club location
            TableColumn<String, FootBallClub> col03 = new TableColumn<>("Sports Club Address");
            //add value for location column
            col03.setCellValueFactory(new PropertyValueFactory<>("SportsClubLocation"));

            //column for sports club contact no.
            TableColumn<Integer, FootBallClub> col04 = new TableColumn<>("Contact No.");
            //add value for contact no. column
            col04.setCellValueFactory(new PropertyValueFactory<>("ContactNo"));

            //column for number of win matches
            TableColumn<Integer, FootBallClub> col05 = new TableColumn<>("Number Of Wins");
            //add value for wins column
            col05.setCellValueFactory(new PropertyValueFactory<>("NumOfClubWins"));

            //column for number of defeat matches
            TableColumn<Integer, FootBallClub> col06 = new TableColumn<>("Number Of Defeats");
            //add value for defeats column
            col06.setCellValueFactory(new PropertyValueFactory<>("NumOfClubDefeats"));

            //column for numbers of draw matches
            TableColumn<Integer, FootBallClub> col07 = new TableColumn<>("Number Of Draws");
            //add value for draws column
            col07.setCellValueFactory(new PropertyValueFactory<>("NumOfClubDraws"));

            //column for number of received goals
            TableColumn<Integer, FootBallClub> col08 = new TableColumn<>("Number Of Received Goals");
            //add value for goals column
            col08.setCellValueFactory(new PropertyValueFactory<>("NumOfClubGoals"));

            //column for number of score
            TableColumn<Integer, FootBallClub> col09 = new TableColumn<>("Number Of Score");
            //add value for score column
            col09.setCellValueFactory(new PropertyValueFactory<>("NumOfClubScores"));

            //column for number of matches
            TableColumn<Integer, FootBallClub> col10 = new TableColumn<>("Number Of Matches");
            //add value for number of matches column
            col10.setCellValueFactory(new PropertyValueFactory<>("NumOfClubMatches"));

            //column for number of points
            TableColumn<Integer, FootBallClub> col11 = new TableColumn<>("Number Of Points");
            //add value for club points column
            col11.setCellValueFactory(new PropertyValueFactory<>("ClubPoints"));

            //add columns for table
            tab03.getColumns().addAll(col01,col02,col03,col04,col05,col06,col07,col08,col09,col10,col11);

            //sort table with points
            Comparator clubComparator2 = Comparator.comparing(FootBallClub::getNumOfClubWins);
            Collections.sort(arrayList,clubComparator2);
            Collections.reverse(arrayList);

            //add items to table with arraylist
            for (FootBallClub footBall : arrayList){
                tab03.getItems().add(footBall);
            }
            //add table to scene
            stage03.setScene(new Scene(tab03, 1600, 500));
            stage03.showAndWait();
        });

        //button for random match
        Button bt04 = new Button("Random Match");
        bt04.setLayoutX(205);
        bt04.setLayoutY(270);
        bt04.setStyle("-fx-font-size: 20;-fx-text-alignment: center; -fx-background-radius: 20; -fx-background-color: #7FFFD4");
        bt04.setPrefHeight(40);
        bt04.setPrefWidth(290);
        //set action for button
        bt04.setOnAction(event -> {
            //get new stage for random match window
            Stage stageRandom = new Stage();
            //set title for table random match window
            stageRandom.setTitle("Premier League Manager");

            //get new anchorpane
            AnchorPane ancRandom = new AnchorPane();

            //button for play random match
            Button btPlayMatch = new Button("Play Random Match");
            btPlayMatch.setLayoutX(230);
            btPlayMatch.setLayoutY(180);
            btPlayMatch.setStyle("-fx-font-size: 20;-fx-text-alignment: center; -fx-background-radius: 20; -fx-background-color: #7FFFD4");
            btPlayMatch.setPrefHeight(40);
            btPlayMatch.setPrefWidth(240);
            //set action for button
            btPlayMatch.setOnAction(event1 -> {
                //get new stage
                Stage stageRandomDone = new Stage();
                //set title for random match
                stageRandomDone.setTitle("Random Match Played Successful");

                //get new anchorpane
                AnchorPane ancRandomDone = new AnchorPane();

                //create a object
                DateInfo matchDetailswithDate2 = new DateInfo();

                //set background image
                Image imageBall = new Image("ball.png");
                ImageView viewImageBall = new ImageView();
                viewImageBall.setImage(imageBall);
                viewImageBall.setFitHeight(320);
                viewImageBall.setFitWidth(640);

                //set Random Match Played Successful label
                Label lblMatchTopic = new Label("Random Match Played Successful.");
                lblMatchTopic.setLayoutX(20);
                lblMatchTopic.setLayoutY(112);
                lblMatchTopic.setStyle("-fx-font-size: 40;-fx-text-alignment: center");

                //set close button
                Button btCloseWindow = new Button("Close");
                btCloseWindow.setLayoutX(430);
                btCloseWindow.setLayoutY(230);
                btCloseWindow.setStyle("-fx-font-size: 20;-fx-text-alignment: center; -fx-background-color: #90EE90");
                btCloseWindow.setPrefHeight(40);
                btCloseWindow.setPrefWidth(150);
                //set action for back button
                btCloseWindow.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        Stage stage = (Stage) btCloseWindow.getScene().getWindow();
                        stage.close();
                    }
                });

                //random match details
                Random randomMatch = new Random();

                //get random number for team 1
                int randNo01 = randomMatch.nextInt(4);
                //get random number for team 2
                int randNo02 = randomMatch.nextInt(4);

                if (randNo01 == randNo02) {
                    do {
                        randNo01 = randomMatch.nextInt(4);
                        randNo02 = randomMatch.nextInt(4);
                    } while (randNo01 != randNo02);
                } else {
                    //set random number 1 for club number 1
                    FootBallClub clubNum01 = arrayList.get(randNo01);
                    int clubRegNo01 = clubNum01.getSportsClubRegNo();

                    //set random number 2 for club number 2
                    FootBallClub clubNum02 = arrayList.get(randNo02);
                    int clubRegNo02 = clubNum02.getSportsClubRegNo();

                    //get random number for team 1 score
                    int clubNo01Goals = randomMatch.nextInt(20);
                    //get random number for team 2 score
                    int clubNo02Goals = randomMatch.nextInt(20);

                    //get random number for year
                    int startYear = 2020;
                    int endYear =2023;
                    int randomYear = randomMatch.nextInt(endYear-startYear) + startYear;

                    //get random number for month
                    int startMonth = 1;
                    int endMonth =13;
                    int randomMonth = randomMatch.nextInt(endMonth-startMonth) + startMonth;

                    //get random number for day
                    int startDay = 1;
                    int endDay =31;
                    int randomDay = randomMatch.nextInt(endDay-startDay) + startDay;

                    //create a object for random date
                    Date randomDate = new Date();

                    //create format for random date
                    String matchDate = (randomDay+"-" +randomMonth+"-"+randomYear);
                    String[] dateArraySplit = matchDate.split("-", 3);
                    int ranDate = Integer.parseInt(dateArraySplit[0]);
                    int ranMonth = Integer.parseInt(dateArraySplit[1]);
                    int ranYear = Integer.parseInt(dateArraySplit[2]);

                    //set validation for date
                    if (ranDate > 0 && ranDate < 32 && ranMonth > 0 && ranMonth < 13 && ranYear > 2019 && ranYear < 10000) {
                        randomDate.setDay(ranDate);
                        randomDate.setMonth(ranMonth);
                        randomDate.setYear(ranYear);

                        //add date details for arrraylist
                        matchDetailswithDate2.setMatchPlayDay(ranDate);
                        matchDetailswithDate2.setMatchPlayMonth(ranMonth);
                        matchDetailswithDate2.setMatchPlayYear(ranYear);
                    }
                    //This message is displayed if the random match played successful
                    System.out.println("Random Match Played Successful");

                    //update club 01 score
                    clubNum01.setNumOfClubScores(clubNum01.getNumOfClubScores()+clubNo01Goals);
                    //update club 02 score
                    clubNum02.setNumOfClubScores(clubNum02.getNumOfClubScores()+clubNo02Goals);

                    //update club 01 number of matches
                    clubNum01.setNumOfClubMatches(clubNum01.getNumOfClubMatches()+1);
                    //update club 02 number of matches
                    clubNum02.setNumOfClubMatches(clubNum02.getNumOfClubMatches()+1);

                    //update club 01 number of goals
                    clubNum01.setNumOfClubGoals(clubNum01.getNumOfClubGoals()+clubNo01Goals);
                    //update club 02 number of goals
                    clubNum02.setNumOfClubGoals(clubNum02.getNumOfClubGoals()+clubNo01Goals);

                    //team 01 win the match
                    if (clubNo01Goals > clubNo02Goals){
                        //update team 01 wins
                        clubNum01.setNumOfClubWins(clubNum01.getNumOfClubWins()+1);
                        //update team 02 defeats
                        clubNum02.setNumOfClubDefeats(clubNum02.getNumOfClubDefeats()+1);
                        //update team 01 points
                        clubNum01.setClubPoints((int) clubNum01.getClubPoints()+3);
                    }
                    //team 02 win the match
                    else if (clubNo02Goals > clubNo01Goals){
                        //update team 01 defeats
                        clubNum02.setNumOfClubWins(clubNum02.getNumOfClubWins()+1);
                        //update team 02 wins
                        clubNum01.setNumOfClubDefeats(clubNum01.getNumOfClubDefeats()+1);
                        //update team 02 points
                        clubNum02.setClubPoints((int) clubNum02.getClubPoints()+3);
                    }
                    //draw the match
                    else if (clubNo01Goals == clubNo02Goals){
                        //update team 01 draws
                        clubNum01.setNumOfClubDraws(clubNum01.getNumOfClubDraws()+1);
                        //update team 02 draws
                        clubNum02.setNumOfClubDraws(clubNum02.getNumOfClubDraws()+1);
                        //update team 01 points
                        clubNum01.setClubPoints((int) clubNum01.getClubPoints()+1);
                        //update team 02 points
                        clubNum02.setNumOfClubDraws((int) clubNum02.getClubPoints()+1);
                    }

                    //create a object
                    PlayedMatchDetails randomMatchDetails = new PlayedMatchDetails();
                    //add data to playedMatchArrayList arraylist
                    randomMatchDetails.setTeam01(clubRegNo01);
                    randomMatchDetails.setTeam02(clubRegNo02);
                    randomMatchDetails.setTeam01score(clubNo01Goals);
                    randomMatchDetails.setTeam02score(clubNo02Goals);
                    randomMatchDetails.setPlayedMatchDate(randomDate);

                    //add data to matchDateInfo arraylist
                    matchDetailswithDate2.setTeam01(clubRegNo01);
                    matchDetailswithDate2.setTeam02(clubRegNo02);
                    matchDetailswithDate2.setTeam01score(clubNo01Goals);
                    matchDetailswithDate2.setTeam02score(clubNo02Goals);

                    matchDateInfo.add(matchDetailswithDate2);
                    playedMatchArrayList.add(randomMatchDetails);
                    randomMatchArray.add(randomMatchDetails);
                }

                //add childrens for anchorpane
                ancRandomDone.getChildren().addAll(viewImageBall,lblMatchTopic,btCloseWindow);

                //add anchorpane to scene
                sceneRandDone = new Scene(ancRandomDone, 640, 320);
                stageRandomDone.setScene(sceneRandDone);
                stageRandomDone.showAndWait();
            });

            //button for random match information table
            Button btMatchStatus = new Button("Random Match Information");
            btMatchStatus.setLayoutX(230);
            btMatchStatus.setLayoutY(250);
            btMatchStatus.setStyle("-fx-font-size: 20;-fx-text-alignment: center; -fx-background-radius: 20; -fx-background-color: #7FFFD4");
            btMatchStatus.setPrefHeight(40);
            btMatchStatus.setPrefWidth(240);
            //set action for button
            btMatchStatus.setOnAction(event1 -> {
                //get new stage for table
                Stage stageMatch = new Stage();
                //set title for table window
                stageMatch.setTitle("Random Match Information");

                //create a table view
                TableView tabMatch = new TableView();

                //column for sports club 01 reg no.
                TableColumn<Integer, PlayedMatchDetails> colm01 = new TableColumn<>("First team Reg No.");
                //add value for reg no. column
                colm01.setCellValueFactory(new PropertyValueFactory<>("Team01"));

                //column for sports club 02 reg no.
                TableColumn<Integer, PlayedMatchDetails> colm02 = new TableColumn<>("Second team Reg No.");
                //add value for reg no. column
                colm02.setCellValueFactory(new PropertyValueFactory<>("Team02"));

                //column for number of team 01 score
                TableColumn<Integer, PlayedMatchDetails> colm03 = new TableColumn<>("First team Score");
                //add value for score column
                colm03.setCellValueFactory(new PropertyValueFactory<>("Team01score"));

                //column for number of team 02 score
                TableColumn<Integer, PlayedMatchDetails> colm04 = new TableColumn<>("Second team Score");
                //add value for score column
                colm04.setCellValueFactory(new PropertyValueFactory<>("Team02score"));

                //column for match played date
                TableColumn<Integer, PlayedMatchDetails> colm05 = new TableColumn<>("Match Played Date");
                //add value for date column
                colm05.setCellValueFactory(new PropertyValueFactory<>("PlayedMatchDate"));

                //add columns for table
                tabMatch.getColumns().addAll(colm01,colm02,colm03,colm04,colm05);

                //add items to table with randomMatchArray arraylist
                for (PlayedMatchDetails playedMatchDetails : randomMatchArray){
                    tabMatch.getItems().add(playedMatchDetails);
                }
                //add table to scene
                stageMatch.setScene(new Scene(tabMatch, 730, 500));
                stageMatch.showAndWait();
            });

            //set background image
            Image imageSky = new Image("sky.png");
            ImageView viewImageSky = new ImageView();
            viewImageSky.setImage(imageSky);
            viewImageSky.setFitHeight(500);
            viewImageSky.setFitWidth(700);

            //back button
            Button btCloseWin = new Button("Back");
            btCloseWin.setLayoutX(500);
            btCloseWin.setLayoutY(430);
            btCloseWin.setStyle("-fx-font-size: 20;-fx-text-alignment: center; -fx-background-color: #90EE90");
            btCloseWin.setPrefHeight(40);
            btCloseWin.setPrefWidth(150);
            btCloseWin.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    Stage stage = (Stage) btCloseWin.getScene().getWindow();
                    stage.close();
                }
            });
            //add childrens  to anchorpane
            ancRandom.getChildren().addAll(viewImageSky,btPlayMatch,btMatchStatus,btCloseWin);

            //add anchorpane to scene
            sceneRand = new Scene(ancRandom, 700, 500);
            stageRandom.setScene(sceneRand);
            stageRandom.showAndWait();
        });

        //button for table(Ascending Order Of Date)
        Button bt05 = new Button("Ascending Order Of Date");
        bt05.setLayoutX(205);
        bt05.setLayoutY(330);
        bt05.setStyle("-fx-font-size: 20;-fx-text-alignment: center; -fx-background-radius: 20; -fx-background-color: #7FFFD4");
        bt05.setPrefHeight(40);
        bt05.setPrefWidth(290);
        //set action for button
        bt05.setOnAction(event -> {
            //get new stage for table
            Stage stageDate = new Stage();
            //set title for table window
            stageDate.setTitle("Ascending Order Of Date");

            //create a table view
            TableView tabDate = new TableView();

            //column for sports club 01 reg no.
            TableColumn<Integer, PlayedMatchDetails> colm01 = new TableColumn<>("First team Reg No.");
            //add value for reg no. column
            colm01.setCellValueFactory(new PropertyValueFactory<>("Team01"));

            //column for sports club 02 reg no.
            TableColumn<Integer, PlayedMatchDetails> colm02 = new TableColumn<>("Second team Reg No.");
            //add value for reg no. column
            colm02.setCellValueFactory(new PropertyValueFactory<>("Team02"));

            //column for sports club 01 score
            TableColumn<Integer, PlayedMatchDetails> colm03 = new TableColumn<>("First team Score");
            //add value for team 01 score column
            colm03.setCellValueFactory(new PropertyValueFactory<>("Team01score"));

            //column for sports club 02 score
            TableColumn<Integer, PlayedMatchDetails> colm04 = new TableColumn<>("Second team Score");
            //add value for team 02 score column
            colm04.setCellValueFactory(new PropertyValueFactory<>("Team02score"));

            //column for match played year
            TableColumn<Integer, PlayedMatchDetails> colm05 = new TableColumn<>("Match Played Year");
            //add value for year column
            colm05.setCellValueFactory(new PropertyValueFactory<>("MatchPlayYear"));

            //column for match played month
            TableColumn<Integer, PlayedMatchDetails> colm06 = new TableColumn<>("Match Played Month");
            //add value for month column
            colm06.setCellValueFactory(new PropertyValueFactory<>("MatchPlayMonth"));

            //column for match played day
            TableColumn<Integer, PlayedMatchDetails> colm07 = new TableColumn<>("Match Played Day");
            //add value for day column
            colm07.setCellValueFactory(new PropertyValueFactory<>("MatchPlayDay"));

            //add columns for table
            tabDate.getColumns().addAll(colm01,colm02,colm03,colm04,colm05,colm06,colm07);

            //sort table with date
            Comparator clubComparator3 = Comparator.comparing(DateInfo::getMatchPlayYear).thenComparing(DateInfo::getMatchPlayMonth).thenComparing(DateInfo::getMatchPlayDay);
            Collections.sort(matchDateInfo,clubComparator3);

            //add items to table with arraylist
            for (DateInfo playedMatchDetails : matchDateInfo){
                tabDate.getItems().add(playedMatchDetails);
            }

            //add table to scene
            stageDate.setScene(new Scene(tabDate, 1020, 500));
            stageDate.showAndWait();
        });

        //button for search
        Button bt06 = new Button("Search");
        bt06.setLayoutX(205);
        bt06.setLayoutY(390);
        bt06.setStyle("-fx-font-size: 20;-fx-text-alignment: center; -fx-background-radius: 20; -fx-background-color: #7FFFD4");
        bt06.setPrefWidth(290);
        bt06.setPrefHeight(40);
        //set action for button
        bt06.setOnAction(event -> {
            //get new stage for table
            Stage stageSearch = new Stage();
            //set title for window
            stageSearch.setTitle("Search");

            //get new anchorpane
            AnchorPane ancSearch = new AnchorPane();

            //set background image
            Image imageSearch = new Image("imageSearch.png");
            ImageView viewImageSearch = new ImageView();
            viewImageSearch.setImage(imageSearch);
            viewImageSearch.setFitHeight(480);
            viewImageSearch.setFitWidth(680);

            //set label for topic
            Label lbSearchTopic = new Label("Search Statistics");
            lbSearchTopic.setLayoutX(200);
            lbSearchTopic.setLayoutY(15);
            lbSearchTopic.setStyle("-fx-font-size: 40;-fx-text-alignment: center");

            //year label
            Label lbl01 = new Label("Enter Year :");
            lbl01.setLayoutX(40);
            lbl01.setLayoutY(120);
            lbl01.setStyle("-fx-font-size: 30;-fx-text-alignment: center");

            //month label
            Label lbl02 = new Label("Enter Month :");
            lbl02.setLayoutX(40);
            lbl02.setLayoutY(168);
            lbl02.setStyle("-fx-font-size: 30;-fx-text-alignment: center");

            //day label
            Label lbl03 = new Label("Enter Day :");
            lbl03.setLayoutX(40);
            lbl03.setLayoutY(213);
            lbl03.setStyle("-fx-font-size: 30;-fx-text-alignment: center");

            //textfield for year
            TextField tf01 = new TextField();
            tf01.setLayoutX(230);
            tf01.setLayoutY(125);
            tf01.setPrefWidth(230);
            tf01.setStyle("-fx-background-color : aqua");

            //textfield for month
            TextField tf02 = new TextField();
            tf02.setLayoutX(230);
            tf02.setLayoutY(175);
            tf02.setPrefWidth(230);
            tf02.setStyle("-fx-background-color : aqua");

            //textfield for day
            TextField tf03 = new TextField();
            tf03.setLayoutX(230);
            tf03.setLayoutY(225);
            tf03.setPrefWidth(230);
            tf03.setStyle("-fx-background-color : aqua");

            //button for search
            Button btSearch = new Button("Search");
            btSearch.setLayoutX(230);
            btSearch.setLayoutY(290);
            btSearch.setStyle("-fx-font-size: 20;-fx-text-alignment: center; -fx-background-radius: 20; -fx-background-color: #7FFFD4");
            btSearch.setPrefHeight(40);
            btSearch.setPrefWidth(240);
            //set action for button
            btSearch.setOnAction(event1 -> {
                //get new stage for search result
                Stage stageSearch3 = (Stage) btSearch.getScene().getWindow();

                //get new anchorpane for search details
                AnchorPane ancPane02 = new AnchorPane();

                //set background image
                Image imageSearch02 = new Image("imageSearch02.png");
                ImageView viewImageSearch02 = new ImageView();
                viewImageSearch02.setImage(imageSearch02);
                viewImageSearch02.setFitHeight(500);
                viewImageSearch02.setFitWidth(620);

                //topic
                Label lbManager = new Label("Premier League Manager");
                lbManager.setLayoutX(80);
                lbManager.setLayoutY(20);
                lbManager.setStyle("-fx-font-size: 42;-fx-text-alignment: center");

                //team 01 reg no. label
                Label lb02_1 = new Label("Team 01 Reg No. :");
                lb02_1.setLayoutX(40);
                lb02_1.setLayoutY(120);
                lb02_1.setStyle("-fx-font-size: 20;-fx-text-alignment: center");

                //team 02 reg no. label
                Label lb02_2 = new Label("Team 02 Reg No. :");
                lb02_2.setLayoutX(40);
                lb02_2.setLayoutY(180);
                lb02_2.setStyle("-fx-font-size: 20;-fx-text-alignment: center");

                //team 01 score label
                Label lb02_3 = new Label("Team 01 Score :");
                lb02_3.setLayoutX(40);
                lb02_3.setLayoutY(240);
                lb02_3.setStyle("-fx-font-size: 20;-fx-text-alignment: center");

                //team 02 score label
                Label lb02_4 = new Label("Team 02 Score :");
                lb02_4.setLayoutX(40);
                lb02_4.setLayoutY(300);
                lb02_4.setStyle("-fx-font-size: 20;-fx-text-alignment: center");

                //match played date label
                Label lb02_5 = new Label("Match Played Date :");
                lb02_5.setLayoutX(40);
                lb02_5.setLayoutY(360);
                lb02_5.setStyle("-fx-font-size: 20;-fx-text-alignment: center");

                //textfield for team 01 reg no.
                TextField tf02_1 = new TextField();
                tf02_1.setLayoutX(320);
                tf02_1.setLayoutY(120);
                tf02_1.setPrefWidth(200);

                //textfield for team 02 reg no.
                TextField tf02_2 = new TextField();
                tf02_2.setLayoutX(320);
                tf02_2.setLayoutY(180);
                tf02_2.setPrefWidth(200);

                //textfield for team 01 score
                TextField tf02_3 = new TextField();
                tf02_3.setLayoutX(320);
                tf02_3.setLayoutY(240);
                tf02_3.setPrefWidth(200);

                //textfield for team 02 score
                TextField tf02_4 = new TextField();
                tf02_4.setLayoutX(320);
                tf02_4.setLayoutY(300);
                tf02_4.setPrefWidth(200);

                //textfield for match played date
                TextField tf02_5 = new TextField();
                tf02_5.setLayoutX(320);
                tf02_5.setLayoutY(360);
                tf02_5.setPrefWidth(200);

                //get year,month and day of the match, user want to search
                String inputYear = tf01.getText();
                String inputMonth = tf02.getText();
                String inputDay = tf03.getText();

                for (int i=0;i<matchDateInfo.size();i++){
                    //search details with match played date
                    String year = Integer.toString(matchDateInfo.get(i).getMatchPlayYear());
                    String month = Integer.toString(matchDateInfo.get(i).getMatchPlayMonth());
                    String day = Integer.toString(matchDateInfo.get(i).getMatchPlayDay());

                    if (inputYear.equals(year)&&inputMonth.equals(month)&&inputDay.equals(day)){

                        //set match details for textfields
                        if (matchDateInfo.get(i) instanceof DateInfo ) {
                            int ftTeam01 = matchDateInfo.get(i).getTeam01();
                            tf02_1.setText(String.valueOf(ftTeam01));
                            int ftTeam02 = matchDateInfo.get(i).getTeam02();
                            tf02_2.setText(String.valueOf(ftTeam02));
                            int ftTeam01Score = matchDateInfo.get(i).getTeam01score();
                            tf02_3.setText(String.valueOf(ftTeam01Score));
                            int ftTeam02Score = matchDateInfo.get(i).getTeam02score();
                            tf02_4.setText(String.valueOf(ftTeam02Score));
                            String playedDate = matchDateInfo.get(i).getMatchPlayYear()+ "/" +matchDateInfo.get(i).getMatchPlayMonth()+ "/" + matchDateInfo.get(i).getMatchPlayDay();
                            tf02_5.setText(playedDate);
                        }
                    }
                }

                //back button for search result
                Button btBack = new Button("Back");
                btBack.setLayoutX(490);
                btBack.setLayoutY(420);
                btBack.setStyle("-fx-font-size: 20;-fx-text-alignment: center; -fx-background-radius: 20; -fx-background-color: #7FFFD4");
                btBack.setPrefHeight(40);
                btBack.setPrefWidth(90);
                //set action for button
                btBack.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        Stage stage = (Stage) btBack.getScene().getWindow();
                        stage.close();
                    }
                });

                //add childrens for search result anchorpane
                ancPane02.getChildren().addAll(viewImageSearch02,lbManager,lb02_1,lb02_2,lb02_3,lb02_4,lb02_5,tf02_1,tf02_2,tf02_3,tf02_4,tf02_5,btBack);

                //add anchorpane to sceneSearch
                sceneSearch3=new Scene(ancPane02, 620, 500);
                stageSearch.setScene(sceneSearch3);
                stageSearch.setTitle("Search");
                stageSearch.show();
            });

            //back button for search
            Button btCloseSearch = new Button("Back");
            btCloseSearch.setLayoutX(450);
            btCloseSearch.setLayoutY(400);
            btCloseSearch.setStyle("-fx-font-size: 20;-fx-text-alignment: center; -fx-background-color: #90EE90");
            btCloseSearch.setPrefHeight(40);
            btCloseSearch.setPrefWidth(150);
            //set action for button
            btCloseSearch.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    Stage stage = (Stage) btCloseSearch.getScene().getWindow();
                    stage.close();
                }
            });

            //add childrens for anchorpane
            ancSearch.getChildren().addAll(viewImageSearch,lbSearchTopic,lbl01,lbl02,lbl03,tf01,tf02,tf03,btSearch,btCloseSearch);

            //add anchorpane to sceneSearch
            stageSearch.setScene(new Scene(ancSearch, 680, 480));
            stageSearch.showAndWait();
        });

        //exit button
        Button bt07 = new Button("Exit");
        bt07.setLayoutX(520);
        bt07.setLayoutY(440);
        bt07.setStyle("-fx-font-size: 20;-fx-text-alignment: center; -fx-background-color: #90EE90");
        bt07.setPrefHeight(40);
        bt07.setPrefWidth(150);
        //set action for button
        bt07.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = (Stage) bt07.getScene().getWindow();
                stage.close();
            }
        });

        //add childrens for anchorpane
        anc01.getChildren().addAll(viewImage01,labl01,bt01,bt02,bt03,bt04,bt05,bt06,bt07);

        //add anchorpane to scene
        sceneMain = new Scene(anc01, 680, 480);
        stageHome.setScene(sceneMain);
        stageHome.showAndWait();
    }

    @Override
    //Method for store data in file
    public void storeDataInFile2 () throws IOException {
        //create a file
        File file1 = new File("matchInformation.txt");
        file1.createNewFile();

        FileOutputStream fileOut = new FileOutputStream(file1);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);

        out.writeObject(matchDateInfo);
        out.flush();
        out.close();
        fileOut.close();
    }

    @Override
    //Method for restore previous data into program
    public void restoreData2 () throws IOException {
        FileInputStream fileIn = new FileInputStream("matchInformation.txt");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        try {
            matchDateInfo = (ArrayList<DateInfo>) in.readObject();
            //This message is displayed if the previous data restore in the program
            System.out.println("Previous match Data is in the Program.");
            System.out.println("--------------------------------");
            in.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException e) {
            //This message is displayed when not in the previous data program
            System.out.println("Data can not found");
        }
    }

    @Override
    //Method for store data in file
    public void storeDataInFile3 () throws IOException {
        //create a file
        File file1 = new File("matchInformation2.txt");
        file1.createNewFile();

        FileOutputStream fileOut = new FileOutputStream(file1);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);

        out.writeObject(playedMatchArrayList);
        out.flush();
        out.close();
        fileOut.close();
    }

    @Override
    //Method for restore previous data into program
    public void restoreData3 () throws IOException {
        FileInputStream fileIn = new FileInputStream("matchInformation2.txt");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        try {
            playedMatchArrayList = (ArrayList<PlayedMatchDetails>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException e) {
            //This message is displayed when not in the previous data program
            System.out.println("Data can not found");
        }
    }
}