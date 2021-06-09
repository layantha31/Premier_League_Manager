package sample;

import org.junit.Test;

import static org.junit.Assert.*;

public class SportsClubTest {

    @Test
    public void getSportsClubName() {
        SportsClub club01 = new SportsClub("sjcb","us",111,0717171717);
        assertEquals("sjcb",club01.getSportsClubName());
    }

    @Test
    public void getSportsClubLocation() {
        SportsClub club01 = new SportsClub("sjcb","us",111,0717171717);
        assertEquals("us",club01.getSportsClubLocation());
    }

    @Test
    public void getSportsClubRegNo() {
        SportsClub club01 = new SportsClub("sjcb","us",111,0717171717);
        assertEquals(111,club01.getSportsClubRegNo());
    }

    @Test
    public void getContactNo() {
        SportsClub club01 = new SportsClub("sjcb","us",111,0717171717);
        assertEquals(0717171717,club01.getContactNo());
    }
}