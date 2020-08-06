package chapter.four;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class Problem4Test {

  @Test
  public void balancedTreeTest() {
    BinarySearchTree bst = new BinarySearchTree();
    bst.insert(5);
    bst.insert(4);
    bst.insert(3);
    bst.insert(2);
    bst.insert(1);

    System.out.println("Unbalanced tree:");
    bst.printTree();

    assertFalse(Problem4.isBalanced(bst.root));

    bst = new BinarySearchTree();
    bst.insert(5);

    bst.insert(3);
    bst.insert(4);
    bst.insert(2);

    bst.insert(7);
    bst.insert(6);
    bst.insert(8);

    System.out.println("Balanced tree:");
    bst.printTree();

    assertTrue(Problem4.isBalanced(bst.root));
  }

}