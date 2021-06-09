package sample;

import org.junit.Test;

import static org.junit.Assert.*;

public class FootBallClubTest {

    @Test
    public void getNumOfClubWins() {
        FootBallClub footBallClub = new FootBallClub(11,"sjcb","us",0711717171,12,12,12,12,12,12,12);
        assertEquals(12,footBallClub.getNumOfClubWins());
    }

    @Test
    public void getNumOfClubDefeats() {
        FootBallClub footBallClub = new FootBallClub(11,"sjcb","us",0711717171,12,12,12,12,12,12,12);
        assertEquals(12,footBallClub.getNumOfClubDefeats());
    }

    @Test
    public void getNumOfClubDraws() {
        FootBallClub footBallClub = new FootBallClub(11,"sjcb","us",0711717171,12,12,12,12,12,12,12);
        assertEquals(12,footBallClub.getNumOfClubDraws());
    }

    @Test
    public void getNumOfClubGoals() {
        FootBallClub footBallClub = new FootBallClub(11,"sjcb","us",0711717171,12,12,12,12,12,12,12);
        assertEquals(12,footBallClub.getNumOfClubGoals());
    }

    @Test
    public void getNumOfClubScores() {
        FootBallClub footBallClub = new FootBallClub(11,"sjcb","us",0711717171,12,12,12,12,12,12,12);
        assertEquals(12,footBallClub.getNumOfClubScores());
    }

    @Test
    public void getNumOfClubMatches() {
        FootBallClub footBallClub = new FootBallClub(11,"sjcb","us",0711717171,12,12,12,12,12,12,12);
        assertEquals(12,footBallClub.getNumOfClubMatches());
    }

    @Test
    public void getClubPoints() {
        FootBallClub footBallClub = new FootBallClub(11,"sjcb","us",0711717171,12,12,12,12,12,12,12);
        assertEquals(12,footBallClub.getClubPoints());
    }
}