/*
ID: calebta1
LANG: JAVA
TASK: measurement
*/
import java.io.*;
import java.util.*;

public class measurement {
    static Map<String, Integer> current = new HashMap<String, Integer>();
    static int counter = 0;
    static int[] billboard = {};
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("measurement.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));
        current.put("Mildred", 7);
        current.put("Elsie", 7);
        current.put("Bessie", 7);

        int measurements = 0;
        measurements = Integer.parseInt(br.readLine());
        String[] inputs = new String[measurements];

        for (int x = 0; x <= measurements; x++){
            if (x == 0) continue;
            else inputs[x-1] = br.readLine();
        }

        Map<Integer, Map<String, Integer>> map = new HashMap<Integer, Map<String, Integer>>();

        for (int x = 0; x < inputs.length; x++){
            String[] temp = inputs[x].split(" ");
            Map<String, Integer> valSetThree = new HashMap<String, Integer>();
            int day = Integer.parseInt(temp[0]);
            int change = Integer.parseInt(temp[2]);
            valSetThree.put(temp[1],change);
            map.put(day,valSetThree);
        }


        Map<String, Integer> map2 = new HashMap<String, Integer>();
        map2.put("Elsie", 7);

        map2.put("Mildred", 7);
        map2.put("Bessie", 7);
        for (int key1 : map.keySet()) {
            Map innerMap = map.get(key1);
            for (Object key2: innerMap.keySet()) {
                map2.put(key2.toString(), map2.get(key2) + Integer.parseInt(innerMap.get(key2).toString()));
                checkSpots(map2);
            }
        }
        out.println(counter);
        out.close();
    }

    static List<String> oldList = new ArrayList<String>();
    public static void checkSpots(Map<String, Integer> map2){
        List<String> myList = new ArrayList<String>();

        int greatest = 7;
        String person = "";
        for (Object value: map2.keySet()){
            if (Integer.parseInt(map2.get(value).toString()) > greatest){
                greatest = Integer.parseInt(map2.get(value).toString());
                person = value.toString();
            }
        }
        myList.add(person);
        for (Object value: map2.keySet()){
            if (Integer.parseInt(map2.get(value).toString()) == greatest && myList.contains(value.toString()) == false){
                myList.add(value.toString());
            }
        }

        if (myList.equals(oldList) == false){
            System.out.println(oldList == myList);
            oldList = myList;
            counter++;
        }

    }

}
