import java.util.ArrayList;
import java.util.Collections;

class DriverClass {
    public static void main(String args[]){
        double depthAverage = 0;
        for (int x = 0; x < 100; x++) {
            ArrayList<Integer> arrNodes = new ArrayList<>();
            for (int i = 1; i <= 10000; i++) arrNodes.add(i);
            Collections.shuffle(arrNodes);
            BST<Integer> tree = new BST<>(arrNodes.get(0));
            for (int n : arrNodes) {
                BST<Integer> node = new BST<>(n);
                tree.insert(node);
            }
            depthAverage+=(double) tree.depth(tree);
        }
        depthAverage /= 100;
        System.out.println(depthAverage);
    }
}

/*
    The Average depth of a 10000 node tree inserted in random order is 31-32 levels deep. 
    Algorithm Analysis:
    Search worst case order of growth: O(n). The node is at the bottom of the tree, so all elements need to be traversed.
    Search best case order of growth: O(1). The node to be searched is the root.
    Search average case order of growth: O(log n), because a binary search's average order of growth is log n.
    Insert average case order of growth: O(log n), insert method does basically the same thing as a search, except it inserts at a location below
    Printing a tree order of growth: O(n), because you have to print all the elements.
*/
public class BST<T extends Comparable<T>> {
    private T datum;
    private BST<T> left;
    private BST<T> right;

    public BST(T datum){
        this.datum = datum;
    }

    protected T getDatum(){
        return datum;
    }

    protected BST<T> getLeft(){
        return left;
    }

    protected BST<T> getRight(){
        return right;
    }

    protected int depth(BST<T> node){
        if (node == null) return 0;
        else {
            int leftTree = depth(node.left);
            int rightTree = depth(node.right);
            return Math.max(leftTree, rightTree) + 1;
        }
    }

    protected void insert(BST<T> node){
        if (node.datum.compareTo(this.datum) > 0) {
            if (right == null) right = node;
            else right.insert(node);
        } else if (node.datum.compareTo(this.datum) < 0) {
            if (left == null) left = node;
            else left.insert(node);
        }
    }

    protected boolean contains(BST<T> node){
        if (node.datum.compareTo(this.datum) < 0) {
            return left != null && left.contains(node);
        } else if (node.datum.compareTo(this.datum) > 0) {
            return right != null && right.contains(node);
        } else {
            return true;
        }
    }

    protected void printTree(){
        if (left != null) left.printTree();
        System.out.print(datum + " ");
        if (right != null) right.printTree();
    }

    public String toString(){
        return "Tree datum: " + datum;
    }
}
