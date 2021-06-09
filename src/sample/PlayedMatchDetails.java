package sample;

import java.io.Serializable;

public class PlayedMatchDetails implements Serializable {
    private static final long serialVersionUID=1L;

    private int team01;
    private int team02;
    private int team01score;
    private int team02score;
    private Date date;

    public PlayedMatchDetails(){ }

    public PlayedMatchDetails(int team01, int team02, int team01score, int team02score, Date date) {
        this.team01 = team01;
        this.team02 = team02;
        this.team01score = team01score;
        this.team02score = team02score;
        this.date = date;
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

    public Date getPlayedMatchDate() {
        return date;
    }

    public void setPlayedMatchDate(Date playedMatchDate) {
        this.date = playedMatchDate;
    }

    @Override
    public String toString() {
        return "-----Played Match Details-----" +
                " Team 01 : " + team01 +
                " Team 02 : " + team02 +
                " Team 01 score : " + team01score +
                " Team 02 score : " + team02score +
                " Date : " + date +
                "-----------------------------";
    }
}