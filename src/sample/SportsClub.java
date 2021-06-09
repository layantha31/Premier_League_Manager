package sample;

import java.io.Serializable;

public class SportsClub implements Serializable {

    private String sportsClubName;
    private String sportsClubLocation;
    private int sportsClubRegNo;
    private int contactNo;

    public SportsClub() {}

    public SportsClub(String sportsClubName,String addressOfClub,int sportsClubRegNo,int contactNo){
        this.sportsClubName=sportsClubName;
        this.sportsClubLocation=addressOfClub;
        this.sportsClubRegNo=sportsClubRegNo;
        this.contactNo=contactNo;
    }

    public String getSportsClubName() { return sportsClubName; }

    public void setSportsClubName(String sportsClubName) { this.sportsClubName = sportsClubName; }

    public String getSportsClubLocation() { return sportsClubLocation; }

    public void setSportsClubLocation(String sportsClubLocation) { this.sportsClubLocation = sportsClubLocation; }

    public int getSportsClubRegNo() { return sportsClubRegNo; }

    public void setSportsClubRegNo(int sportsClubRegNo) { this.sportsClubRegNo = sportsClubRegNo; }

    public int getContactNo() { return contactNo; }

    public void setContactNo(int contactNo) { this.contactNo = contactNo; }

    @Override
    public String toString() {
        return "-------Sports Club Details-------" +"\n"+
                " Sports Club Name : " + sportsClubName +"\n"+
                " Sports Club Location : " + sportsClubLocation +"\n"+
                " Sports Club Reg No. : " + sportsClubRegNo +"\n"+
                " ContactNo : " + contactNo +"\n"+
                "---------------------------------"+"\n";
    }
}