import java.util.HashMap;
import java.util.Map;

class DriverClass {
    public static void main(String[] args){
        Graph g = new Graph();
        g.addEdge(new Node("a"), new Node("c"), 17);
        g.addEdge(new Node("c"), new Node("b"), 13);
        g.printNodes();
    }
}

public class Graph {
    HashMap<Node, HashMap<Node, Integer>> graph = new HashMap<>();

    public void addEdge(Node a, Node b, int d) {
        if (!graph.isEmpty() && graph.containsKey(a)) {
            graph.get(a).put(b, d);
        } else {
            HashMap<Node, Integer> nodeBConnection = new HashMap<>();
            nodeBConnection.put(b, d);
            graph.put(a, nodeBConnection);
        }
        if (!graph.containsKey(b)) {
            HashMap<Node, Integer> nodeAConnection = new HashMap<>();
            nodeAConnection.put(a, d);
            graph.put(b, nodeAConnection);
        }
    }

    public void printNodes() {
        if (graph == null) System.out.println("Graph is empty.");
        else {
            for (Node node : graph.keySet()) {
                System.out.print(node.getName() + " ");
                // inner for loop appears to make it O(n^2) time but it is guaranteed that there will only be one key value pair in the inner hashmap
                for (Node connectedNode : graph.get(node).keySet()){
                    System.out.print(connectedNode.getName() + " " + graph.get(node).get(connectedNode));
                }
                System.out.println();
            }
        }
    }
}


