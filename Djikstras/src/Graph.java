import java.util.*;

public class Graph {
    private HashMap<Node, HashMap<Node, Integer>> graph = new HashMap<>();

    public void addEdge(Node a, Node b, int d) {
        for (Node node : graph.keySet()) {
            for (Node connectedNode : graph.get(node).keySet())
            if (connectedNode.getIdentifier() == a.getIdentifier() && node.getIdentifier() == b.getIdentifier())
                graph.get(node).put(connectedNode, d);
        }
        if (graph.containsKey(a) && (a.getIdentifier() != b.getIdentifier())) {
            graph.get(a).put(b,d);
        } else {
            HashMap<Node, Integer> nodeBConnection = new HashMap<>();
            nodeBConnection.put(b, d);
            if (a.getIdentifier() != b.getIdentifier()) graph.put(a, nodeBConnection);
        }
    }

    public void printNodes() {
        if (graph == null) System.out.println("Graph is empty.");
        else {
            for (Node node : graph.keySet()) {
                System.out.print(node.getIdentifier() + ": ");
                // inner for loop appears to make it O(n^2) time but it is guaranteed that there will only be one key value pair in the inner hashmap
                for (Node connectedNode : graph.get(node).keySet()){
                    System.out.print(connectedNode.getIdentifier() + " " + graph.get(node).get(connectedNode) + ", ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public HashMap<Node, HashMap<Node, Integer>> getGraph() {
        return graph;
    }
}


