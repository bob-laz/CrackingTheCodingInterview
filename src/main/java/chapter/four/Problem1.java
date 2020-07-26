package chapter.four;

import java.util.LinkedList;

/*
    Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
 */
public class Problem1 {

    // implementation of BFS, time complexity is dependent on number of nodes in the graph (N) and the total number of
    // edges in the graph (E), could also be referred to as the sum of the length of all the neighbor arrays. For the
    // worst case scenario (end is not found) we must check every node in the graph so O(N + E) since we must touch
    // every neighbor of every node.
    public static boolean routeBetween(Graph g, Node start, Node end) {
        if (g == null || start == null || end == null) {
            return false;
        }
        if (start == end) {
            return true;
        }

        LinkedList<Node> q = new LinkedList<>();
        for (Node n : g.nodes) {
            n.state = State.UNVISITED;
        }

        start.state = State.VISITING;
        q.add(start);
        while (!q.isEmpty()) {
            Node n = q.removeFirst();
            if (n != null) {
                for (Node x : n.neighbors) {
                    if (x.state == State.UNVISITED) {
                        if (x == end) {
                            return true;
                        } else {
                            x.state = State.VISITING;
                            q.add(x);
                        }
                    }
                }
                n.state = State.VISITED;
            }
        }
        return false;
    }

    static class Node {
        String data;
        State state;
        Node[] neighbors;

        public Node(String data) {
            this.data = data;
        }
    }

    static class Graph {
        Node[] nodes;
    }

    enum State {
        VISITED, VISITING, UNVISITED
    }
}
