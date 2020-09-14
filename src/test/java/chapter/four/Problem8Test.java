package chapter.four;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Problem8Test {

  @Test
  public void firstCommonAncestorTest() {
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

    assertEquals(root, Problem8.firstCommonAncestor(n3, n20));
    assertEquals(n5, Problem8.firstCommonAncestor(n3, n7));
    assertEquals(n15, Problem8.firstCommonAncestor(n14, n20));
    assertEquals(n5, Problem8.firstCommonAncestor(n4, n7));
    assertEquals(root, Problem8.firstCommonAncestor(n20, root));
  }

  @Test
  public void firstCommonAncestorNoParentTest() {
    Node root = new Node(10);
    Node n5 = new Node(5);
    Node n3 = new Node(3);
    Node n2 = new Node(2);
    Node n4 = new Node(4);
    Node n7 = new Node(7);
    Node n15 = new Node(15);
    Node n14 = new Node(14);
    Node n20 = new Node(20);

    root.left = n5;
    root.right = n15;

    // left tree
    n5.left = n3;
    n5.right = n7;
    n3.left = n2;
    n3.right = n4;

    // right tree
    n15.left = n14;
    n15.right = n20;

    assertEquals(root, Problem8.firstCommonAncestorNoParent(root, n3, n20));
    assertEquals(n5, Problem8.firstCommonAncestorNoParent(root, n3, n7));
    assertEquals(n15, Problem8.firstCommonAncestorNoParent(root, n14, n20));
    assertEquals(n5, Problem8.firstCommonAncestorNoParent(root, n4, n7));
    assertEquals(root, Problem8.firstCommonAncestorNoParent(root, n20, root));
  }
}