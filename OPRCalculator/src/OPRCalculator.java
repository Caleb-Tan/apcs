import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;


class Driver {
    public static void main(String[] args){
        OPRCalculator calc = new OPRCalculator(matchFile, teamFile);
    }
}

public class OPRCalculator {
    ArrayList<Integer> teamList;
    ArrayList<Integer> scoreList;
    ArrayList<ArrayList<Integer>> matches;
    public OPRCalculator(File matchFile, File teamFile){
        try {
            BufferedReader brTeam = new BufferedReader(new FileReader(teamFile));
            BufferedReader brMatch = new BufferedReader(new FileReader(matchFile));
            BufferedReader brScore = new BufferedReader(new FileReader(matchFile));
            initTeamsList(brTeam);
            initMatchMatrix(brMatch);
            initScoreList(brScore);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initTeamsList(BufferedReader br) throws IOException {
        String st;
        teamList = new ArrayList<>();
        while ((st = br.readLine()) != null) {
            teamList.add(Integer.parseInt(st));
        }
    }

    public void initMatchMatrix(BufferedReader br) throws IOException {
        String st;
        matches = new ArrayList<>();
        while ((st = br.readLine()) != null) {
            String[] blueTeams = st.split(",")[1].split(" ");
            ArrayList<Integer> match = new ArrayList<>();
            for (int team: teamList) {
                for (String blueTeam: blueTeams) {
                    if (team == Integer.parseInt(blueTeam)) {
                        match.add(1);
                        break;
                    }
                }
                match.add(0);
            }
            matches.add(match);
        }
    }

    public void initScoreList(BufferedReader br) throws IOException {
        String st;
        scoreList = new ArrayList<>();
        while ((st = br.readLine()) != null) {
            String[] data = st.split(",");
            scoreList.add(Integer.parseInt(data[3]));
        }
    }


}
