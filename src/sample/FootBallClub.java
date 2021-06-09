package sample;

import java.io.Serializable;

public class FootBallClub extends SportsClub implements Serializable {
    private static final long serialVersionUID=1L;

    private int numOfClubWins;
    private int numOfClubDefeats;
    private int numOfClubDraws;
    private int numOfClubGoals;
    private int numOfClubScores;
    private int numOfClubMatches;
    private int clubPoints;

    public FootBallClub() {}

    public FootBallClub( int sportsClubRegNo,String sportsClubName, String sportsClubLocation,int contactNo ,int numOfClubWins, int numOfClubDefeats, int numOfClubDraws, int numOfClubGoals, int numOfClubScores, int numOfClubMatches, int clubPoints)  {
        super(sportsClubName,sportsClubLocation,sportsClubRegNo,contactNo);
        this.numOfClubWins = numOfClubWins;
        this.numOfClubDefeats = numOfClubDefeats;
        this.numOfClubDraws = numOfClubDraws;
        this.numOfClubGoals = numOfClubGoals;
        this.numOfClubScores = numOfClubScores;
        this.numOfClubMatches = numOfClubMatches;
        this.clubPoints = clubPoints;
    }

    public int getNumOfClubWins() { return numOfClubWins; }

    public void setNumOfClubWins(int numOfClubWins) { this.numOfClubWins = numOfClubWins; }

    public int getNumOfClubDefeats() { return numOfClubDefeats; }

    public void setNumOfClubDefeats(int numOfClubDefeats) { this.numOfClubDefeats = numOfClubDefeats; }

    public int getNumOfClubDraws() { return numOfClubDraws; }

    public void setNumOfClubDraws(int numOfClubDraws) { this.numOfClubDraws = numOfClubDraws; }

    public int getNumOfClubGoals() { return numOfClubGoals; }

    public void setNumOfClubGoals(int numOfClubGoals) { this.numOfClubGoals = numOfClubGoals; }

    public int getNumOfClubScores() { return numOfClubScores; }

    public void setNumOfClubScores(int numOfClubScores) { this.numOfClubScores = numOfClubScores; }

    public int getNumOfClubMatches() { return numOfClubMatches; }

    public void setNumOfClubMatches(int numOfClubMatches) { this.numOfClubMatches = numOfClubMatches; }

    public int getClubPoints() { return clubPoints; }

    public void setClubPoints(int clubPoints) { this.clubPoints = clubPoints; }

    @Override
    public String toString() {
        return "-----FootBall Club Details-----" +"\n"+
                "  Sports Club Name = " + super.getSportsClubName() + "\n"+
                "  Sports Club Location = " + super.getSportsClubLocation() + "\n"+
                "  Sports Club Reg No = " + super.getSportsClubRegNo() + "\n"+
                "  Contact No = " + super.getContactNo() + "\n"+
                "  Number Of Club Wins = " + numOfClubWins + "\n"+
                "  Number Of Club Defeats = " + numOfClubDefeats + "\n"+
                "  Number Of Club Draws = " + numOfClubDraws + "\n"+
                "  Number Of Club Goals = " + numOfClubGoals + "\n"+
                "  Number Of Club Scores = " + numOfClubScores + "\n"+
                "  Number Of Club Matches = " + numOfClubMatches + "\n"+
                "  Club Points = " + clubPoints + "\n"+
                "------------------------------"+ "\n";
    }
}