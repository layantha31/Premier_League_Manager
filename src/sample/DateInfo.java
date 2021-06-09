package sample;

import java.io.Serializable;

public class DateInfo implements Serializable {
    private static final long serialVersionUID=1L;

    private int team01;
    private int team02;
    private int team01score;
    private int team02score;
    private int matchPlayDay;
    private int matchPlayMonth;
    private int matchPlayYear;

    public DateInfo() {
        this.team01 = team01;
        this.team02 = team02;
        this.team01score = team01score;
        this.team02score = team02score;
        this.matchPlayDay = matchPlayDay;
        this.matchPlayMonth = matchPlayMonth;
        this.matchPlayYear = matchPlayYear;
    }

    public int getTeam01() {
        return team01;
    }

    public void setTeam01(int team01) {
        this.team01 = team01;
    }

    public int getTeam02() {
        return team02;
    }

    public void setTeam02(int team02) {
        this.team02 = team02;
    }

    public int getTeam01score() {
        return team01score;
    }

    public void setTeam01score(int team01score) {
        this.team01score = team01score;
    }

    public int getTeam02score() {
        return team02score;
    }

    public void setTeam02score(int team02score) {
        this.team02score = team02score;
    }

    public int getMatchPlayDay() {
        return matchPlayDay;
    }

    public void setMatchPlayDay(int matchPlayDay) {
        this.matchPlayDay = matchPlayDay;
    }

    public int getMatchPlayMonth() {
        return matchPlayMonth;
    }

    public void setMatchPlayMonth(int matchPlayMonth) {
        this.matchPlayMonth = matchPlayMonth;
    }

    public int getMatchPlayYear() {
        return matchPlayYear;
    }

    public void setMatchPlayYear(int matchPlayYear) {
        this.matchPlayYear = matchPlayYear;
    }

    @Override
    public String toString() {
        return "------Match Information------" +"\n"+
                " Team 01 : " + team01 +"\n"+
                " Team 02 : " + team02 +"\n"+
                " Team 01 score : " + team01score +"\n"+
                " Team 02 score : " + team02score +"\n"+
                " Match played Day : " + matchPlayDay +"\n"+
                " Match played Month : " + matchPlayMonth +"\n"+
                " Match played Year : " + matchPlayYear +
                "----------------------------";
    }
}
