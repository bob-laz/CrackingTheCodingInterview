package chapter.four;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import chapter.four.Problem6.NodeParent;
import org.junit.jupiter.api.Test;

class Problem6Test {

  @Test
  public void getSuccessorTest() {
    NodeParent root = new NodeParent(10);
    NodeParent n5 = new NodeParent(5);
    NodeParent n3 = new NodeParent(3);
    NodeParent n2 = new NodeParent(2);
    NodeParent n4 = new NodeParent(4);
    NodeParent n7 = new NodeParent(7);
    NodeParent n15 = new NodeParent(15);
    NodeParent n14 = new NodeParent(14);
    NodeParent n20 = new NodeParent(20);

    root.setLeft(n5);
    root.setRight(n15);

    // left tree
    n5.setLeft(n3);
    n5.setRight(n7);
    n3.setLeft(n2);
    n3.setRight(n4);

    // right tree
    n15.setLeft(n14);
    n15.setRight(n20);

    assertEquals(3, Problem6.getSuccessor(n2).data);
    assertEquals(4, Problem6.getSuccessor(n3).data);
    assertEquals(5, Problem6.getSuccessor(n4).data);
    assertEquals(7, Problem6.getSuccessor(n5).data);
    assertEquals(10, Problem6.getSuccessor(n7).data);
    assertEquals(14, Problem6.getSuccessor(root).data);
    assertEquals(15, Problem6.getSuccessor(n14).data);
    assertEquals(20, Problem6.getSuccessor(n15).data);
    assertNull(Problem6.getSuccessor(n20));
  }
}