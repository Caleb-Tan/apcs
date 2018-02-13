class Driver {
    public static void main(String args[]){
        int[] arrNodes = {7, 3, 6, 1, 3, 10, 8, 11, 10};
        BST<Integer> tree = new BST<>(arrNodes[0]);
        for (int n: arrNodes){
            BST<Integer> node = new BST<>(n);
            tree.insert(node);
        }
        tree.printTree();
        System.out.println();
        System.out.println(tree.depth(tree));
    }
}

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

    protected void printTree(){
        if (left != null) left.printTree();
        System.out.print(datum + " ");
        if (right != null) right.printTree();
    }

    public String toString(){
        return "Tree datum: " + datum;
    }
}
