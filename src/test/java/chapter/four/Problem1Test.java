package chapter.four;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static chapter.four.Problem1.*;

class Problem1Test {

    @Test
    public void routeBetweenTest1_connectedGraph() {
        Graph g = new Graph();
        Node nA = new Node("A");
        Node nB = new Node("B");
        Node nC = new Node("C");
        Node nD = new Node("D");
        Node nE = new Node("E");
        Node nF = new Node("F");

        nA.neighbors = new Node[]{nB};
        nB.neighbors = new Node[]{nC};
        nC.neighbors = new Node[]{nD, nF};
        nD.neighbors = new Node[]{nE};
        nE.neighbors = new Node[]{};
        nF.neighbors = new Node[]{nE};

        g.nodes = new Node[]{nA, nB, nC, nD, nE, nF};

        assertTrue(Problem1.routeBetween(g, nA, nE));
        assertFalse(Problem1.routeBetween(g, nE, nA));
    }

    @Test
    public void routeBetweenTest_disconnectedGraph() {
        Graph g = new Graph();
        Node nA = new Node("A");
        Node nB = new Node("B");
        Node nC = new Node("C");
        Node nD = new Node("D");
        Node nE = new Node("E");
        Node nF = new Node("F");
        Node nG = new Node("G");

        nA.neighbors = new Node[]{nC};
        nB.neighbors = new Node[]{nA};
        nC.neighbors = new Node[]{nB};
        nD.neighbors = new Node[]{nE};
        nE.neighbors = new Node[]{nF};
        nF.neighbors = new Node[]{nD, nG};
        nG.neighbors = new Node[]{nF};

        g.nodes = new Node[]{nA, nB, nC, nD, nE, nF, nG};

        assertFalse(Problem1.routeBetween(g, nA, nE));
        assertTrue(Problem1.routeBetween(g, nC, nA));
        assertTrue(Problem1.routeBetween(g, nD, nG));
        assertTrue(Problem1.routeBetween(g, nG, nD));
    }

}