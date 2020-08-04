package chapter.four;

import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class Problem3Test {

  private static BinarySearchTree bst;
  @BeforeAll
  public static void setup() {
    // problem does not call for binary search tree, just binary tree but we already have this
    // implementation and it will work fine, easier to build than manually constructing a binary
    // tree from Nodes
    bst = new BinarySearchTree();
    bst.insert(3);
    bst.insert(4);
    bst.insert(5);
    bst.insert(1);
    bst.insert(8);
    bst.insert(2);
    bst.insert(1);

    bst.printTree();
  }

  @Test
  public void listOfDepthsDFSTest() {
    System.out.println("DFS Implementation");
    List<LinkedList<Node>> list = Problem3.listOfDepthsDFS(bst.root);
    for (int i = 0; i < list.size(); i++) {
      System.out.println("Level " + i + ": " + list.get(i));
    }
  }

  @Test
  public void listOfDepthsBFSTest() {
    System.out.println("BFS Implementation");

    List<LinkedList<Node>> list = Problem3.listOfDepthsBFS(bst.root);
    for (int i = 0; i < list.size(); i++) {
      System.out.println("Level " + i + ": " + list.get(i));
    }
  }
}
