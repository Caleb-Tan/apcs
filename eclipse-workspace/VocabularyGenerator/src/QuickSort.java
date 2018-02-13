import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class QuickSort {
    /**
     * @author - Caleb Tan
     * @arr = arraylist of numbers (MUST BE OF AN ODD SIZE)
     * @leftIndex = highest index (starting from 1) of left partition
     * @middleIndex = index (starting from 1) of the middle of the arr
     */
    static ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1,9,4,2,0,-2,5,0,-1,-5,-9));
    static int leftIndex = 0;
    final static int middleIndex =(arr.size()+1)/2;

    /* driver method */
    public static void main(String[] args) {
        System.out.println(findMedian(arr));
    }

    /**
     * takes in array and either partitions it or returns it
     * @param arr
     * @return - returns array
     */
    public static ArrayList<Integer> findMedian(ArrayList<Integer> arr){
        ArrayList<Integer> newArr = partition(arr);
        if (newArr.size() == 1) return newArr; // Basecase 1: array is of size 1
        else if (checkDistinct(newArr)) return new ArrayList<>(Arrays.asList(newArr.get(0))); // Basecase 2: array contains only same values
        else return findMedian(newArr); // findMedian() for remaining array
    }


    /**
     *
     * @param arr - array to be partitioned
     * @return - either returns Left partition or Right partition
     */
    public static ArrayList<Integer> partition(ArrayList<Integer> arr){
        int partitionValue = arr.get(arr.size()-1);
        ArrayList<Integer> pLeft = new ArrayList<>();
        ArrayList<Integer> pRight = new ArrayList<>();

        // If value is the largest in array or not the smallest in array, puts in right partition. Otherwise, puts value in left partition
        if (partitionValue == Collections.max(arr) || partitionValue != Collections.min(arr)) pRight.add(partitionValue);
        else pLeft.add(partitionValue);

        arr.remove(arr.size()-1); // remove value from array
        for (int x: arr){
            if (x >= partitionValue){
                pRight.add(x);
            } else {
                pLeft.add(x);
            }
        }
        System.out.print(pLeft);
        System.out.print(pRight);
        System.out.println();
        // returns left or right partition based on which contains the median
        int pLeftIndex = leftIndex + pLeft.size();
        if (middleIndex > pLeftIndex) {
            leftIndex = pLeftIndex;
            return pRight;
        } else {
            return pLeft;
        }
    }

    /**
     * checkDistinct() checks to see if all the array's values are the same, if they are, it returns true
     * @param arr - array to check distinct values
     * @return - whether array is distinct
     */
    public static boolean checkDistinct(ArrayList<Integer> arr){
        boolean nonDistinct = true;
        for (int x: arr){
            if (x != arr.get(0)){
                nonDistinct = false;
                break;
            }
        }
        return nonDistinct;
    }
}
