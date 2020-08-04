package chapter.four;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
   Given a binary tree, design an algorithm which creates a linked list of all the nodes at each depth (e.g., if you
   have a tree with depth D, you'll have D linked lists).
*/
public class Problem3 {

  // O(n) time because we must traverse the tree and touch every element
  // O(n) space for storing the return value (O(log(n) call stack space insignificant)
  public static List<LinkedList<Node>> listOfDepthsDFS(Node root) {
    List<LinkedList<Node>> list = new ArrayList<>();
    listOfDepthsDFSRecursive(root, 0, list);
    return list;
  }

  private static void listOfDepthsDFSRecursive(Node n, int depth, List<LinkedList<Node>> list) {
    if (n != null) {
      if (list.size() == depth) {
        list.add(new LinkedList<>());
      }
      list.get(depth).add(n);
      listOfDepthsDFSRecursive(n.left, depth + 1, list);
      listOfDepthsDFSRecursive(n.right, depth + 1, list);
    }
  }

  // alternative implementation using BFS
  // also O(n) time and O(n) space
  public static List<LinkedList<Node>> listOfDepthsBFS(Node root) {
    List<LinkedList<Node>> retVal = new ArrayList<>();
    LinkedList<Node> cur = new LinkedList<>();
    if (root != null) {
      cur.add(root);
    }
    while (cur.size() > 0) {
      retVal.add(cur);
      LinkedList<Node> parents = cur;
      cur = new LinkedList<>();
      for (Node parent : parents) {
        if (parent.left != null) {
          cur.add(parent.left);
        }
        if (parent.right != null) {
          cur.add(parent.right);
        }
      }
    }
    return retVal;
  }
}
