package sample;

import org.junit.Test;

import static org.junit.Assert.*;

public class SchoolFootballClubTest {

    @Test
    public void getSchoolName() {
        SchoolFootballClub club01 = new SchoolFootballClub(123,"sjc","us",07712121277,12,13,1,12,124,19,125,"bmv");
        assertEquals("bmv",club01.getSchoolName());
    }
}