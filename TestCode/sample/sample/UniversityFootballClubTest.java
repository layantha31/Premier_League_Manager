package sample;

import org.junit.Test;

import static org.junit.Assert.*;

public class UniversityFootballClubTest {

    @Test
    public void getUniversityName() {
        UniversityFootballClub universityFootballClub = new UniversityFootballClub(1,"sjc","uk",0771234567,1,3,2,4,5,12,13,"IIT");
        assertEquals("IIT",universityFootballClub.getUniversityName());
    }
}