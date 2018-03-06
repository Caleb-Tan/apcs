import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Caleb
 */
class DriverClass {
    public static void main(String[] args) {
        SetMethods setMethods = new SetMethods();
        System.out.println("Return 17: " + setMethods.ret17());
        System.out.println("Get 0th element: " + setMethods.zerothElement(new ArrayList<>(Arrays.asList(10,2,5,8))));
        System.out.println("Contains: " + setMethods.contains(5, new int[]{5, 23, 1}));
        System.out.println("Any Contains: " + setMethods.anyContains(new int[]{10, 2, 6}, new int[]{-10, 3, 13, -5}));
        System.out.println("Union: " + Arrays.toString(setMethods.union(new int[]{10, 2, 6}, new int[]{-10, 3, 13, -5})));
        System.out.println("Intersect: " + Arrays.toString(setMethods.intersect(new int[]{10, 5, 23, 9, 1}, new int[]{1, 5, 9, 21, -10})));
        System.out.println("Nearest Unvisted Node: " + setMethods.nearestUnvisitedNode(new boolean[]{true,false,true,false}, new int[]{4,3,2,1}, new String[]{"A", "B", "C", "D"}));
        System.out.println("Listify: " + setMethods.listify(6, 10, -5));
        System.out.println("Add Edge: " + setMethods.addEdge(new ArrayList<>(Arrays.asList(new ArrayList<Object>(Arrays.asList(1,2,3)))), 4, 6, 7));
        ArrayList<ArrayList<Integer>> nodes = new ArrayList<>();
        nodes.add(new ArrayList<>(Arrays.asList(1,2,5,6)));
        nodes.add(new ArrayList<>(Arrays.asList(2,9,19)));
        System.out.println("Collect Nodes: " + setMethods.collectNodes(nodes));
        System.out.println("Set Infinity: " + setMethods.setInfinity(4, 2));
    }
}

public class SetMethods {

    /**
     * @return - ArrayList containing 17
     */
    public ArrayList<Integer> ret17() {
        return new ArrayList<Integer>(Arrays.asList(17));
    }

    /**
     * @param al - ArrayList containing integers
     * @return - zeroeth element in arraylist
     */
    public Integer zerothElement(ArrayList<Integer> al){
        return al.get(0);
    }

    /**
     * @param a - integer to look for
     * @param ar - array of integers
     * @return - true if array contains integer a, false if it does not
     */
    public boolean contains(int a, int[] ar){
        for (int x: ar) if (x == a) return true;
        return false;
    }

    /**
     * @param a - first array
     * @param b - second array
     * @return - true if an integer in a is also in b
     */
    public boolean anyContains(int[] a, int[] b){
        for (int x: a){
            for (int y: b){
                if (x == y) return true;
            }
        }
        return false;
    }

    /**
     * unions the two arrays by looping through arrays and adding elements that are not contained in a list to the list
     * @param a - first array
     * @param b - second array
     * @return - unioned array
     */
    public int[] union(int[] a, int[] b){
        ArrayList<Integer> list = new ArrayList<>();
        for (int x: a){
            if (!list.contains(x)) list.add(x);
        }
        for (int x: b){
            if (!list.contains(x)) list.add(x);
        }
        int[] newArr = new int[list.size()];
        for (int x = 0; x < newArr.length; x++){
            newArr[x] = list.get(x);
        }
        return newArr;
    }

    /**
     * finds intersection of two arrays by looping through the elements in the first array and adding all similar elements to a new arraylist
     * @param a - first array
     * @param b - second array
     * @return - intersection of two arrays
     */
    public int[] intersect(int[] a, int[] b){
        ArrayList<Integer> arr = new ArrayList<>();
        for (int x: a){
            for (int y: b){
                if (x == y && !arr.contains(x)) arr.add(x);
            }
        }
        int[] newArr = new int[arr.size()];
        for (int x = 0; x < newArr.length; x++){
            newArr[x] = arr.get(x);
        }
        return newArr;
    }

    /**
     * finds the nearest unvisited node by looping through nodes and storing the index of the current nearest node
     * @param visited - array of booleans corresponding to nodes that have been visited; true is visited and false is unvisited
     * @param distance - array of edge distances corresponding to nodes
     * @param nodeName - String name of node
     * @return - String name of nearest unvisited node
     */
    public String nearestUnvisitedNode(boolean[] visited, int[] distance, String[] nodeName){
        int shortestIndex = -1; // stores the index of the current nearest node
        for (int i = 0; i < visited.length; i++) {
            // if not visited, and the shortest index is -1 or the distance of the current node is less than the distance of the current shortest index node, sets the shortestIndex to be the new index
            if (!visited[i] && (shortestIndex == -1 || distance[i] < distance[shortestIndex])) {
                shortestIndex = i;
            }
        }
        return shortestIndex == -1 ? "" : nodeName[shortestIndex]; // returns empty string if no shortest node has been found (ex visited is all true), otherwise returns the name of the node
    }

    /**
     * converts three integers to a list
     * @param a - first int
     * @param b - second int
     * @param c - third int
     * @return - new list
     */
    public ArrayList<Object> listify(int a, int b, int c){
        ArrayList<Object> newArr = new ArrayList<>(Arrays.asList(a, b, c));
        return newArr;
    }

    /**
     * adds an array of ints to a multi dimensional array
     * @param graph - multi dimensional array
     * @param a - first int
     * @param b - second int
     * @param c - third int
     * @return - updated multi dimensional array
     */
    public ArrayList<ArrayList<Object>> addEdge(ArrayList<ArrayList<Object>> graph, int a, int b, int c){
        ArrayList<Object> newArr = new ArrayList<>(Arrays.asList(a,b,c));
        graph.add(newArr);
        return graph;
    }

    /**
     * returns new arraylist that contains the union of all integers that appears in the first two elements of each arraylist in the multi dimensional array
     * @param edgelist - arraylist of arraylist of integers
     * @return - arraylist containing the union
     */
    public ArrayList<Integer> collectNodes(ArrayList<ArrayList<Integer>> edgelist){
        ArrayList<Integer> newArr = new ArrayList<>();
        for (ArrayList<Integer> innerArr: edgelist) {
            int counter = 0;
            for (int elem: innerArr){
                counter++;
                if (counter < 3 && !newArr.contains(elem)) newArr.add(elem);
            }
        }
        return newArr;
    }

    /**
     * creates an arraylist with elements of Integer.MAX_VALUE, and sets the element at index start to 0
     * @param n - length of arraylist with Integer.MAX_VALUE
     * @param start - index of element with 0
     * @return - new arraylist
     */
    public ArrayList<Integer> setInfinity(int n, int start){
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) arr.add(Integer.MAX_VALUE);
        arr.set(start, 0);
        return arr;
    }
}
