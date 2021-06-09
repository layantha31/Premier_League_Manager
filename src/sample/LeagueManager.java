package sample;

import java.io.IOException;

public interface LeagueManager {
    public void addFootBallClub ();
    public void deleteFootBallClub ();
    public void displayStatistics();
    public void displayTable ();
    public void addPlayedMatch ();
    public void storeDataInFile () throws IOException;
    public void restoreData () throws IOException;
    public void storeDataInFile2 () throws IOException;
    public void restoreData2 () throws IOException;
    public void storeDataInFile3 () throws IOException;
    public void restoreData3 () throws IOException;
    public void graphicUserInterface ();
}
