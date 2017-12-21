


public class ListOfNumbers {
    public static void main(String[] args) {
        int[] arr = new int[3];
        arr[0] = 3;
        arr[1] = 0;
        arr[2] = 1;
        System.out.println("------");
        System.out.println(prev(arr, -11));
    }
    static int prev(int[] ar, int index){
        index = Math.abs(index);
        int[] newArr = new int[200];
        int counter = 0;
        for (int y = 0; y < newArr.length; y++){
            if (counter < newArr.length) {
                for (int x = 0; x < ar.length; x++) {
                    newArr[counter] = ar[x];
                    System.out.println(newArr[counter]);
                    counter++;
                }
            }
        }
        System.out.println("_____");
        System.out.println(index);
        index = Math.abs(index);
        return newArr[index];
    }

}
