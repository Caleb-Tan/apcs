import java.io.*;
import java.util.*;

public class Randp {
    public static void main(String[] args){
        Randp r = new Randp(6);
        for (int x = 0; x < 8; x++) {
            System.out.println(r.nextInt());
        }
    }

    private int[] nums;
    private int numsLeft;

    public Randp(int n){
        numsLeft = n;
        nums = new int[n];
        initNums(n);
    }

    private void initNums(int n){
        for (int i = 1; i <= n; i++){
            nums[i-1]=i;
        }
    }

    public int nextInt(){
        Random rand = new Random();
        if (numsLeft != 0){
            int n = rand.nextInt(numsLeft);
            int temp = nums[n];
            nums[n] = nums[numsLeft-1];
            numsLeft--;
            return temp;
        }
        return 0;
    }
}
