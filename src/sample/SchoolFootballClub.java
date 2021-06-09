package sample;

public class SchoolFootballClub extends FootBallClub{

    String schoolName;

    public SchoolFootballClub(String schoolName) {
        this.schoolName = schoolName;
    }

    public SchoolFootballClub(int sportsClubRegNo, String sportsClubName, String sportsClubLocation, int contactNo, int numOfClubWins, int numOfClubDefeats, int numOfClubDraws, int numOfClubGoals, int numOfClubScores, int numOfClubMatches, int clubPoints, String schoolName) {
        super(sportsClubRegNo, sportsClubName, sportsClubLocation, contactNo, numOfClubWins, numOfClubDefeats, numOfClubDraws, numOfClubGoals, numOfClubScores, numOfClubMatches, clubPoints);
        this.schoolName = schoolName;
    }

    public String getSchoolName() { return schoolName; }

    public void setSchoolName(String schoolName) { this.schoolName = schoolName; }

    @Override
    public String toString() {
        return "-----School Football Club----"+"\n" +
               " School Name : " + schoolName +"\n" +
                "-----------------------------"+"\n"; }
}