package chapter.four;

/**
 * Implement a function to check if a binary tree is balanced. For the purposes of this question, a
 * balanced tree is defined to be a tree such that the heights of the two subtrees of any node never
 * differ by more than one.
 */
public class Problem4 {

  public static boolean isBalanced(Node root) {
    return checkHeight(root) != Integer.MIN_VALUE;
  }

  private static int checkHeight(Node root) {
    // reached a leaf node, base case
    if (root == null) return -1;
    // calculate height of left subtree
    int leftHeight = checkHeight(root.left);
    // if left subtree is unbalanced, propagate error code
    if (leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;
    // calculate height of right subtree
    int rightHeight = checkHeight(root.right);
    // if right subtree is unbalanced, propagate error code
    if (rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;
    // check if this nodes subtrees are unbalanced
    if (Math.abs(leftHeight - rightHeight) > 1) return Integer.MIN_VALUE;
    // return height of this tree
    return Math.max(leftHeight, rightHeight) + 1;
  }
}
