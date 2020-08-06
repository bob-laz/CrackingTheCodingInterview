package chapter.four;

import java.util.ArrayList;
import java.util.List;

/**
 * Implement a function to check if a binary tree is a binary search tree.
 */
public class Problem5 {

  /**
   * solution using an array and in-order traversal, limitation is cannot properly handle duplicates
   * BST property must be: left < current < right O(n)
   *
   * runtime for traversing the tree as well as iterating over the array
   *
   * O(n) space for array, recursive call stack is O(log(n)) so negligible
   */
  public static boolean checkBSTArray(Node root) {
    List<Integer> ary = new ArrayList<>();
    checkBSTArray(root, ary);
    for (int i = 1; i < ary.size(); i++) {
      if (ary.get(i) <= ary.get(i - 1)) {
        return false;
      }
    }
    return true;
  }

  private static void checkBSTArray(Node n, List<Integer> ary) {
    if (n != null) {
      checkBSTArray(n.left, ary);
      ary.add(n.data);
      checkBSTArray(n.right, ary);
    }
  }

  /**
   * solution using definition of binary search tree passing down min/max value as we traverse tree
   *
   * O(n) runtime for traversing the tree
   *
   * O(log(n)) space for recursive call stack
   */
  public static boolean checkBST(Node root) {
    return checkBSTRecursive(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  private static boolean checkBSTRecursive(Node n, int min, int max) {
    if (n == null) {
      return true;
    }
    if (min > n.data || max < n.data) {
      return false;
    }
    return checkBSTRecursive(n.left, min, n.data) && checkBSTRecursive(n.right, n.data, max);
  }
}
