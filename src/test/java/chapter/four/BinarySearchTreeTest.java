package chapter.four;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class BinarySearchTreeTest {

    @BeforeAll
    public static void setup() {
        System.setProperty("file.encoding", "UTF-8");
    }

    @Test
    public void binaryTreeTest() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(5);
        bst.insert(6);
        bst.insert(4);
        bst.insert(10);
        bst.insert(1);

        bst.print();
    }

}