public class Sort {
    public static void main(String[] args){
        int[] unsorted1 = {5, 3, 6, 10, 21, 18, 23};
        int[] unsorted2 = {10, 23, 3, 78, 2, 11, 3};
        int[] unsorted3 = {21, 82, 80, 3, 11, 95, 68};
        // bubble
        printArray(bubbleSort(unsorted1));
        // insertion
        printArray(insertionSort(unsorted2));
        // selection
        printArray(selectionSort(unsorted3));
    }
    public static void printArray(int[] array){
        for (int x = 0; x < array.length; x++){
            System.out.print(array[x] + ",");
        }
        System.out.println();
    }

    /* The bubble sort method loops through the array for the amount of elements there are,
    * and for each loop, it passes through the array (2nd for loop) and swaps elements
    * that are in the wrong place */
    public static int[] bubbleSort(int[] array){
        for (int i = 0; i < array.length; i++) {
            boolean sorted = true; // used to break out of for loop if array is already sorted
            for (int j = 0; j < array.length-1; j++) {
                if (array[j] > array[j + 1]) {  // if current is greater than next, switch them
                    int nextSwitchValue = array[j + 1]; // swap code
                    int prevSwitchValue = array[j];
                    array[j] = nextSwitchValue;
                    array[j + 1] = prevSwitchValue;
                    sorted = false;  // sets sorted to false if a sort took place
                }
            }
            if (sorted == true){
                break;
            }
        }
        return array;
    }

    /* The insertion sort method loops through the array, starting from the second element,
    * and places that element in the correct place on the area of the remaining array */
    public static int[] insertionSort(int[] array){
        int j, key, temp;   // j is the counter, temp is used as a temporary variable for swap code
        for (int i = 1; i < array.length; i++) {
            key = array[i]; // key is the variable to be switched
            j = i-1;        // j starts at the element spot before the current element
            while (j >= 0 && key < array[j]){
                temp = array[j];    // swap code
                array[j] = array[j+1];
                array[j+1] = temp;
                j--;
            }
        }
        return array;
    }

    /* The selection sort method loops through the array's elements and brings the smallest
    element to the front, then moves on to the remaining elements and repeats the process */
    public static int[] selectionSort(int[] array){
        for (int i = 0; i < array.length-1; i++){
            int minKey = i; // minKey is the id of the smallest element
            for (int j = minKey; j < array.length; j++){
                if (array[minKey] > array[j]){
                    minKey = j; // updates the minKey whenever a new smallest element is found
                }
            }
            int temp = array[minKey];   // swap code
            array[minKey] = array[i];
            array[i] = temp;
        }
        return array;
    }
}