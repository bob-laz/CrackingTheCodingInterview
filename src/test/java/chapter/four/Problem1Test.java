package chapter.four;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static chapter.four.Problem1.*;

class Problem1Test {

    Node nA, nB, nC, nD, nE, nF, nG;

    @BeforeEach
    public void setup() {
        nA = new Node("A");
        nB = new Node("B");
        nC = new Node("C");
        nD = new Node("D");
        nE = new Node("E");
        nF = new Node("F");
        nG = new Node("G");
    }

    @Test
    public void routeBetweenBfsTest_connectedGraph() {
        nA.neighbors = new Node[]{nB};
        nB.neighbors = new Node[]{nC};
        nC.neighbors = new Node[]{nD, nF};
        nD.neighbors = new Node[]{nE};
        nE.neighbors = new Node[]{};
        nF.neighbors = new Node[]{nE};

        assertTrue(Problem1.routeBetweenBFS(nA, nE));
        resetNodes(nA, nB, nC, nD, nE, nF, nG);
        assertFalse(Problem1.routeBetweenBFS(nE, nA));
    }

    @Test
    public void routeBetweenBfsTest_disconnectedGraph() {
        nA.neighbors = new Node[]{nC};
        nB.neighbors = new Node[]{nA};
        nC.neighbors = new Node[]{nB};
        nD.neighbors = new Node[]{nE};
        nE.neighbors = new Node[]{nF};
        nF.neighbors = new Node[]{nD, nG};
        nG.neighbors = new Node[]{nF};

        assertFalse(Problem1.routeBetweenBFS(nA, nE));
        resetNodes(nA, nB, nC, nD, nE, nF, nG);
        assertTrue(Problem1.routeBetweenBFS(nC, nA));
        resetNodes(nA, nB, nC, nD, nE, nF, nG);
        assertTrue(Problem1.routeBetweenBFS(nD, nG));
        resetNodes(nA, nB, nC, nD, nE, nF, nG);
        assertTrue(Problem1.routeBetweenBFS(nG, nD));
    }

    @Test
    public void routeBetweenDfsTest_connectedGraph() {
        nA.neighbors = new Node[]{nB};
        nB.neighbors = new Node[]{nC};
        nC.neighbors = new Node[]{nD, nF};
        nD.neighbors = new Node[]{nE};
        nE.neighbors = new Node[]{};
        nF.neighbors = new Node[]{nE, nG};
        nG.neighbors = new Node[]{};

        assertTrue(Problem1.routeBetweenDFS(nA, nE));
        resetNodes(nA, nB, nC, nD, nE, nF, nG);
        assertTrue(Problem1.routeBetweenDFS(nA, nG));
        resetNodes(nA, nB, nC, nD, nE, nF, nG);
        assertFalse(Problem1.routeBetweenDFS(nE, nA));
    }

    @Test
    public void routeBetweenDfsTest_disconnectedGraph() {
        nA.neighbors = new Node[]{nC};
        nB.neighbors = new Node[]{nA};
        nC.neighbors = new Node[]{nB};
        nD.neighbors = new Node[]{nE};
        nE.neighbors = new Node[]{nF};
        nF.neighbors = new Node[]{nD, nG};
        nG.neighbors = new Node[]{nF};

        assertFalse(Problem1.routeBetweenDFS(nA, nE));
        resetNodes(nA, nB, nC, nD, nE, nF, nG);
        assertTrue(Problem1.routeBetweenDFS(nC, nA));
        resetNodes(nA, nB, nC, nD, nE, nF, nG);
        assertTrue(Problem1.routeBetweenDFS(nD, nG));
        resetNodes(nA, nB, nC, nD, nE, nF, nG);
        assertTrue(Problem1.routeBetweenDFS(nG, nD));
    }

    private void resetNodes(Node... nodeList) {
        for (Node node : nodeList) {
            node.state = State.UNVISITED;
        }
    }

}