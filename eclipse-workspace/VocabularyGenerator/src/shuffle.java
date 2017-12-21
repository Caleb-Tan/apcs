/*
ID: calebta1
LANG: JAVA
TASK: shuffle
*/
import java.io.*;
import java.util.*;

public class shuffle {
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("/Users/Caleb/Documents/Java Projects/apcs/eclipse-workspace/VocabularyGenerator/src/ride.txt"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("shuffle.txt")));

        Integer shuffles = 0;
        Map<String, String> cow = new HashMap();
        String order = "";
        String ids = "";

        for (int x = 0; x < 3; x++){
            if (x == 0) shuffles = Integer.parseInt(br.readLine());
            else if (x == 1) order = br.readLine();
            else if (x == 2) ids = br.readLine();
        }

        String[] orders = order.split(" ");
        String[] idList = ids.split(" ");

        for (int x = 0; x < shuffles; x++){
            cow.put(orders[x], idList[x]);
        }
        for (int x = 1; x <= shuffles; x++){
            out.println(cow.get(Integer.toString(x)));
        }
        out.close();

    }
}
