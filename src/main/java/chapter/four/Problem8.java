package chapter.four;

/**
 * Design an algorithm and write code to find the first common ancestor of two nodes in a binary
 * tree. Avoid storing additional nodes in a data structure. NOTE: This is not necessarily a binary
 * search tree.
 */
public class Problem8 {

  /**
   * Assumes both nodes exist in tree and that every node has a link to its parent.
   *
   * Runtime: O(d) where d is the depth of the tree Space: O(1) no additional space used
   */
  public static NodeParent firstCommonAncestor(NodeParent n1, NodeParent n2) {
    int d1 = calculateDepth(n1);
    int d2 = calculateDepth(n2);

    if (d1 > d2) {
      while (d1 > d2) {
        n1 = n1.parent;
        d1--;
      }
    } else if (d2 > d1) {
      while (d2 > d1) {
        n2 = n2.parent;
        d2--;
      }
    }

    while (n1 != n2) {
      n1 = n1.parent;
      n2 = n2.parent;
    }
    return n1;
  }

  private static int calculateDepth(NodeParent n) {
    int depth = 0;
    while (n.parent != null) {
      n = n.parent;
      depth++;
    }
    return depth;
  }

  public static Node firstCommonAncestorNoParent(Node root, Node n1, Node n2) {
    if (!dfs(root, n1) || !dfs(root, n2)) {
      return null;  // one or both nodes not in tree
    }

    return firstCommonAncestorRecursive(root, n1, n2);
  }

  private static Node firstCommonAncestorRecursive(Node root, Node n1, Node n2) {
    if (root == null || root == n1 || root == n2) {
      return root;
    }

    boolean foundN1 = dfs(root.left, n1);
    boolean foundN2 = dfs(root.left, n2);
    if (foundN1 != foundN2) {
      return root; // found FCA if we find one node but not the other
    }
    Node subtree = foundN1 ? root.left : root.right;
    return firstCommonAncestorRecursive(subtree, n1, n2);
  }

  private static boolean dfs(Node root, Node n) {
    if (root == null) {
      return false;
    }
    if (root == n) {
      return true;
    }
    return dfs(root.left, n) || dfs(root.right, n);
  }

}
