package sample;

public class UniversityFootballClub extends FootBallClub {

    String universityName;

    public UniversityFootballClub(String universityName) { this.universityName = universityName; }

    public UniversityFootballClub(int sportsClubRegNo, String sportsClubName, String sportsClubLocation, int contactNo, int numOfClubWins, int numOfClubDefeats, int numOfClubDraws, int numOfClubGoals, int numOfClubScores, int numOfClubMatches, int clubPoints, String universityName) {
        super(sportsClubRegNo, sportsClubName, sportsClubLocation, contactNo, numOfClubWins, numOfClubDefeats, numOfClubDraws, numOfClubGoals, numOfClubScores, numOfClubMatches, clubPoints);
        this.universityName = universityName;
    }

    public String getUniversityName() { return universityName; }

    @Override
    public String toString() {
        return "-----University Football Club----"+"\n" +
               " University Name : " + universityName +"\n"+
               "----------------------------------"+"\n"; }
}