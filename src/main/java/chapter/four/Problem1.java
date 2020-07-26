package chapter.four;

import java.util.LinkedList;

/*
    Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
 */
public class Problem1 {

    // implementation of BFS, time complexity is dependent on number of nodes in the graph (N) and the total number of
    // edges in the graph (E), could also be referred to as the sum of the length of all the neighbor arrays. For the
    // worst case scenario (end is not found) we must check every node in the graph so O(N + E) since we must touch
    // every neighbor of every node. Space complexity depends on node with max number of neighbors to determine q size.
    public static boolean routeBetweenBFS(Node start, Node end) {
        if (start == null || end == null) {
            return false;
        }
        if (start == end) {
            return true;
        }

        LinkedList<Node> q = new LinkedList<>();
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

    // implementation of DFS using recursion. Time and space complexity are the same as BFS. We utilize the call stack
    // instead of a queue for the space. DFS is likely to take longer than BFS in practice since it exhaustively
    // searches every path so it may go very far down the wrong path. BFS searches nearest paths so more likely to find
    // a closer target.
    public static boolean routeBetweenDFS(Node start, Node end) {
        if (start == null || end == null) {
            return false;
        } else if (start == end) {
            return true;
        }

        start.state = State.VISITED;
        boolean returnValue = false;
        for (Node n : start.neighbors) {
            if (n.state == State.UNVISITED) {
                returnValue = returnValue || routeBetweenDFS(n, end);
            }
        }
        return returnValue;
    }

    static class Node {
        String data;
        State state;
        Node[] neighbors;

        public Node(String data) {
            this.data = data;
            this.state = State.UNVISITED;
        }
    }

    enum State {
        VISITED, VISITING, UNVISITED
    }
}
