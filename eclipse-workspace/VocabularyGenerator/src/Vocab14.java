import java.util.Arrays;
import java.util.TreeSet;

/**
 * @author Caleb Tan
 * Vocabulary 14 Homework
 * January 23rd, 2018
 */
public class Vocab14 {

    public static void main(String[] args) {
        int[] arr1 = {2, 4, 5, 8, 15, 6, 8, 17};
        int[] arr2 = {11, 14, 15, 19, 17, 2, 3, 5};
        System.out.println("Array 1: " + Arrays.toString(arr1));
        System.out.println("Array 2: " + Arrays.toString(arr2));
        System.out.println();

        double[] arr1Double = {2, 4, 5, 8, 15, 6, 8, 17};
        System.out.println("Union: " + union(arr1, arr2));
        System.out.println("Intersection: " + intersection(arr1, arr2));
        System.out.println("Set Difference: " + setDifference(arr1, arr2));
        System.out.println("Standard Deviation of Array 1: " + stdev(arr1Double));
        System.out.println();

        int k = 3;
        int power = 50;
        System.out.println("Find Binomial Coefficient of term " + k + " of (x+y)^" + power + ": " + findBinomialCoeff(power,k));
        String top = "9x^2+1";
        String bottom = "2x^2-1";
        System.out.println("Limit of " + top + "/" + bottom + ": " + limit(9,2, 1, 2,2,-1));
    }

    /**
     * adds both arr to one set. Treeset both orders it and does not allow duplicates
     * @param arr1
     * @param arr2
     * @return
     */
    public static TreeSet<Integer> union(int[] arr1, int[] arr2) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int x: arr1) {
            set.add(x);
        }
        for (int x: arr2) {
            set.add(x);
        }
        return set;
    }

    /**
     * iterates through one array and checks if
     * its element(s) is in arr2, if so, add to set
     * @param arr1
     * @param arr2
     * @return
     */
    public static TreeSet<Integer> intersection(int[] arr1, int[] arr2) {
        TreeSet<Integer> set = new TreeSet<>();

        for (int x: arr1) {
            for (int y: arr2) {
                if (x == y) {
                    set.add(x);
                    break;
                }
            }
        }
        return set;
    }

    /**
     * gets union set, same set, then iterates through union set and adds all
     * elements that are not in same set to new set
     * @param arr1
     * @param arr2
     * @return
     */
    public static TreeSet<Integer> setDifference(int[] arr1, int[] arr2) {

        TreeSet<Integer> set = new TreeSet<>();
        TreeSet<Integer> sameSet = intersection(arr1, arr2);
        TreeSet<Integer> unionSet = union(arr1, arr2);

        for (int x: unionSet) {
            if (sameSet.contains(x) == false) {
                set.add(x);
            }
        }
        return set;
    }

    /**
     * finds the limit of a horizontal asymptote of a function
     * @param topCoeff - represents coefficient of top part of equation
     * @param topPower - represents x squared to power for top of equation
     * @param topNum - represents number added to top of equation
     * @param botCoeff - represents coefficient of bottom part of equation
     * @param botPower - represents x squared to power for bottom part of equation
     * @param botNum - represents number added to bottom of equation
     * @return limit
     */
    public static double limit(double topCoeff, double topPower, double topNum, double botCoeff, double botPower, double botNum) {
        double limitCheck = 1000000000000000000000000.0;

        return (topCoeff * (Math.pow(limitCheck, topPower)+topNum))/ (botCoeff * (Math.pow(limitCheck, botPower)+botNum));
    }

    /**
     * stdev returns the standard deviation of an array
     * @param arr
     * @return standard deviation
     */

    public static double stdev(double[] arr) {

        double average = findMean(arr);

        // make new array of numbers where mean is subtracted from original number then squared
        double[] new_arr = new double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            new_arr[i] = Math.pow((arr[i] - average),2);
        }

        return Math.sqrt(findMean(new_arr));
    }

    /**
     * calculates mean
     * @param arr - array to find mean of
     * @return - mean
     */
    public static double findMean(double[] arr) {
        // get average of arr
        double sum = 0;
        for (double x: arr) {
            sum += x;
        }
        return sum/arr.length;
    }

    /**
     *
     * @param power - power
     * @param kTerm - what term to find coefficient of
     * @return - binomial coefficient of kTerm
     */
    public static int findBinomialCoeff(int power, int kTerm) {
        if (kTerm == 0) return 1;
        return (power * findBinomialCoeff(power - 1, kTerm - 1)) / kTerm;
    }

}
