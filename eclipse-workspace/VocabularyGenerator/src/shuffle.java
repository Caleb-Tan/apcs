/*
ID: calebta1
LANG: JAVA
TASK: milk2
*/

import java.io.*;
import java.util.*;

class shuffle {
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("milk2.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
        int farmerCount = Integer.parseInt(br.readLine());
        ArrayList<String[]> farmerTimes = new ArrayList<>();

        for (int x = 1; x <= farmerCount; x++){
            String[] farmerT = br.readLine().split(" ");
            farmerTimes.add(farmerT);
        }

        int highestMilk = 0;
        int highestMilkSingle = 0;
        int noMilking = 0;

        if (farmerTimes.size() == 1){
            highestMilk = Integer.parseInt(farmerTimes.get(0)[1]) - Integer.parseInt(farmerTimes.get(0)[0]);
        } else {

            for (int a = 0; a < farmerTimes.size() - 1; a++) {
                if (Integer.parseInt(farmerTimes.get(a + 1)[0]) <= Integer.parseInt(farmerTimes.get(a)[1])) {
                    if (a == 0) {
                        highestMilk += Integer.parseInt(farmerTimes.get(a + 1)[1]) - Integer.parseInt(farmerTimes.get(a)[0]);
                    } else {
                        highestMilk += Integer.parseInt(farmerTimes.get(a + 1)[1]) - Integer.parseInt(farmerTimes.get(a + 1)[0]);
                    }
                }
                if (Integer.parseInt(farmerTimes.get(a)[1]) - Integer.parseInt(farmerTimes.get(a)[0]) > highestMilkSingle) {
                    highestMilkSingle = Integer.parseInt(farmerTimes.get(a)[1]) - Integer.parseInt(farmerTimes.get(a)[0]);
                }
                if (Integer.parseInt(farmerTimes.get(a + 1)[0]) > Integer.parseInt(farmerTimes.get(a)[1])) {
                    noMilking = Integer.parseInt(farmerTimes.get(a + 1)[0]) - Integer.parseInt(farmerTimes.get(a)[1]);
                }
            }
        }
        if (highestMilk < highestMilkSingle){
            highestMilk = highestMilkSingle;
        }
        out.write(highestMilk + " " + noMilking);
        out.write("\n");
        out.close();
    }
}
