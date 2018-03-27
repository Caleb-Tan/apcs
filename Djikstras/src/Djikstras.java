import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class Djikstras {
    public static void main(String[] args){
        Graph g = new Graph();
        g.addEdge(new Node(1), new Node(6), 14);
        g.addEdge(new Node(1), new Node(3), 9);
        g.addEdge(new Node(1), new Node(2), 7);
        g.addEdge(new Node(2), new Node(1), 7);
        g.addEdge(new Node(2), new Node(3), 10);
        g.addEdge(new Node(2), new Node(4), 10);
        g.addEdge(new Node(3), new Node(1), 9);
        g.addEdge(new Node(3), new Node(2), 10);
        g.addEdge(new Node(3), new Node(4), 11);
        g.addEdge(new Node(3), new Node(6), 2);
        g.addEdge(new Node(4), new Node(2), 10);
        g.addEdge(new Node(4), new Node(3), 11);
        g.addEdge(new Node(4), new Node(5), 6);
        g.addEdge(new Node(5), new Node(4), 6);
        g.addEdge(new Node(5), new Node(6), 9);
        g.addEdge(new Node(6), new Node(1), 14);
        g.addEdge(new Node(6), new Node(3), 2);
        g.addEdge(new Node(6), new Node(5), 9);
        g.printNodes();

        Djikstras djikstras = new Djikstras();
        Node start = new Node(1);
        Node goal = new Node(5);
        djikstras.djikstra(g, start, goal);
    }

    private void djikstra(Graph g, Node start, Node goal) {
        HashSet<Node> visitedNodes = new HashSet<>();
        HashMap<Node, Integer> distances = new HashMap<>();
        HashMap<Node, Node> prevs = new HashMap<>();
        HashMap<Node, HashMap<Node, Integer>> graph = g.getGraph();
        if (!graph.keySet().contains(start)) {
            System.out.println("Start node does not exist.");
            return; // return if the start node does not exist
        } else if (!graph.keySet().contains(goal)) {
            System.out.println("Goal node does not exist.");
            return;
        }
        Node current = start;
        for (Node node: graph.keySet()) {
            if (node.getIdentifier() == start.getIdentifier()) {
                visitedNodes.add(current);
                distances.put(current, 0);
            } else distances.put(node, Integer.MAX_VALUE);
        }

        while (current.getIdentifier() != goal.getIdentifier()) {
            for (Node node : graph.get(current).keySet()) {
                int distFromStart = graph.get(current).get(node) + distances.get(current);
                if (distFromStart < distances.get(node) && !visitedNodes.contains(node)) {
                    prevs.put(node, current);
                    distances.put(node, distFromStart);
                }
            }
            Node least = null;
            for (Node node : distances.keySet()) {
                if ((least == null || distances.get(node) < distances.get(least)) && !visitedNodes.contains(node)) least = node;
            }
            visitedNodes.add(least);
            current = least;
        }

        System.out.println("Path from start node to goal node: " + getPreviousList(prevs, start, goal));
        System.out.println("Distance: " + distances.get(goal));
    }

    private ArrayList<Node> getPreviousList(HashMap<Node, Node> prevs, Node start, Node goal) {
        ArrayList<Node> path = new ArrayList<>();
        Node next = goal;
        path.add(0, next);
        while (next != start) {
            next = prevs.get(next);
            path.add(0, next);
        }
        return path;
    }
}