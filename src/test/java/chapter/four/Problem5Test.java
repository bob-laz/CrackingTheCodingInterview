package chapter.four;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Problem5Test {
  Node root, node1, node2, node3, node4, node6, node7, node8, node9, node10;

  @BeforeEach
  public void setup() {
    root = new Node(5);
    node1 = new Node(1);
    node2 = new Node(2);
    node3 = new Node(3);
    node4 = new Node(4);
    node6 = new Node(6);
    node7 = new Node(7);
    node8 = new Node(8);
    node9 = new Node(9);
    node10 = new Node(10);
  }

  @Test
  public void checkBSTUnbalancedValidTree(){
    // unbalanced but valid binary search tree
    root.left = node4;
    node4.left = node3;
    node3.left = node2;
    node2.left = node1;

    assertTrue(Problem5.checkBST(root));
    assertTrue(Problem5.checkBSTArray(root));
  }

  @Test
  public void checkBSTBalancedValidTree(){
    // balanced and valid binary search tree
    root.left = node3;
    root.right = node7;

    node3.left = node2;
    node3.right = node4;

    node7.left = node6;
    node7.right = node8;

    assertTrue(Problem5.checkBST(root));
    assertTrue(Problem5.checkBSTArray(root));
  }

  @Test
  public void checkBSTBalancedInvalidTree1(){
    // invalid binary tree
    root.left = node3;
    root.right = node7;

    node3.left = node2;
    node3.right = node4;

    node7.left = node8; // left > current
    node7.right = node6; // right < current

    assertFalse(Problem5.checkBST(root));
    assertFalse(Problem5.checkBSTArray(root));
  }

  @Test
  public void checkBSTBalancedInvalidTree2(){
    // invalid binary tree, leaf on left is > parent object
    root.left = node3;
    root.right = node7;

    node3.left = node2;
    node3.right = node9; // right is > current but not < root

    node7.left = node6;
    node7.right = node8;

    assertFalse(Problem5.checkBST(root));
    assertFalse(Problem5.checkBSTArray(root));
  }

}