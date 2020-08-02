package chapter.four;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BinarySearchTreeTest {

    @Test
    public void binarySearchTreeInsertTest() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(8);
        bst.insert(3);
        bst.insert(10);
        bst.insert(1);
        bst.insert(6);
        bst.insert(14);
        bst.insert(4);
        bst.insert(7);
        bst.insert(13);

        bst.printTree();

        BinarySearchTree bst2 = new BinarySearchTree();
        bst2.insert(8);
        bst2.insert(14);
        bst2.insert(10);
        bst2.insert(1);
        bst2.insert(6);
        bst2.insert(13);
        bst2.insert(3);
        bst2.insert(4);
        bst2.insert(7);

        bst2.printTree();
    }

    @Test
    public void binarySearchTreeContainsTest() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(8);
        bst.insert(3);
        bst.insert(10);
        bst.insert(1);
        bst.insert(6);
        bst.insert(14);
        bst.insert(4);
        bst.insert(7);
        bst.insert(13);

        assertTrue(bst.contains(8));
        assertTrue(bst.contains(3));
        assertTrue(bst.contains(10));
        assertTrue(bst.contains(1));
        assertTrue(bst.contains(6));
        assertTrue(bst.contains(14));
        assertTrue(bst.contains(4));
        assertTrue(bst.contains(7));
        assertTrue(bst.contains(13));
        assertFalse(bst.contains(146));
        assertFalse(bst.contains(152));
        assertFalse(bst.contains(999));
    }

  @Test
  public void binarySearchTreeDeleteTest() {
    BinarySearchTree bst = new BinarySearchTree();
    bst.insert(8);
    bst.insert(3);
    bst.insert(10);
    bst.insert(1);
    bst.insert(6);
    bst.insert(14);
    bst.insert(4);
    bst.insert(7);
    bst.insert(13);

    bst.printTree();

    assertTrue(bst.contains(8));
    assertTrue(bst.contains(3));
    assertTrue(bst.contains(10));
    assertTrue(bst.contains(1));
    assertTrue(bst.contains(6));
    assertTrue(bst.contains(14));
    assertTrue(bst.contains(4));
    assertTrue(bst.contains(7));
    assertTrue(bst.contains(13));

    // delete leaf node
    System.out.println("\n--- Deleting leaf node 13---\n");
    bst.delete(13);

    bst.printTree();
    assertFalse(bst.contains(13));

    // delete node with one child
    System.out.println("\n--- Deleting node with one child 10---\n");
    bst.delete(10);

    bst.printTree();
    assertFalse(bst.contains(10));

    // delete node with two children
    System.out.println("\n--- Deleting node with two children 6---\n");
    bst.delete(6);

    bst.printTree();
    assertFalse(bst.contains(6));

    // delete root node
    System.out.println("\n--- Deleting root node 8---\n");
    bst.delete(8);

    bst.printTree();
    assertFalse(bst.contains(8));

    // delete value not in tree
    System.out.println("\n--- Deleting value not in tree 999---\n");
    bst.delete(999);

    bst.printTree();
    assertFalse(bst.contains(999));
  }

  @Test
  public void binarySearchTreeEqualsTest() {
    BinarySearchTree bst1 = new BinarySearchTree();
    bst1.insert(8);
    bst1.insert(3);
    bst1.insert(10);
    bst1.insert(1);
    bst1.insert(6);
    bst1.insert(14);
    bst1.insert(4);
    bst1.insert(7);
    bst1.insert(13);

    BinarySearchTree bst2 = new BinarySearchTree();
    bst2.insert(8);
    bst2.insert(3);
    bst2.insert(10);
    bst2.insert(1);
    bst2.insert(6);
    bst2.insert(14);
    bst2.insert(4);
    bst2.insert(7);
    bst2.insert(13);

    assertEquals(bst1, bst2);
    assertEquals(bst1.hashCode(), bst2.hashCode());

    bst2.insert(5);
    assertNotEquals(bst1, bst2);
    assertNotEquals(bst1.hashCode(), bst2.hashCode());
  }

  @Test
  public void binarySearchTreeTraversalTest() {
    BinarySearchTree bst = new BinarySearchTree();
    bst.insert(8);
    bst.insert(3);
    bst.insert(10);
    bst.insert(1);
    bst.insert(6);
    bst.insert(14);
    bst.insert(4);
    bst.insert(7);
    bst.insert(13);

    bst.printTree();
    System.out.println("Pre-order:");
    bst.preOrderTraversal();
    System.out.println("\nPost-order:");
    bst.postOrderTraversal();
    System.out.println("\nIn-order:");
    bst.inOrderTraversal();
  }

}