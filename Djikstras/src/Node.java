public class Node {
    private int identifier;
    public Node(int identifier) {
        this.identifier = identifier;
    }
    public int getIdentifier() {
        return identifier;
    }

    @Override
    public String toString() {
        return "Node " + identifier;
     }

    // override hashcodes
    @Override
    public boolean equals(Object obj){
        return obj instanceof Node && hashCode() == obj.hashCode();
    }
    @Override
    public int hashCode() {
        return Integer.hashCode(identifier);
    }
}
