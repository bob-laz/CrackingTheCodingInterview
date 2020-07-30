package chapter.four;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
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

}