package chapter.four;

/**
 * Write an algorithm to find the "next" node (i.e. in-order successor) of a given node in a binary
 * search tree. You may assume that each node has a link to its parent.
 */
public class Problem6 {

  /**
   * Runtime: O(log(n)), worst case scenario will be traversing one path of the tree from leaf to
   * root which is the height of the tree
   *
   * Space: O(1), no additional space used
   */
  public static NodeParent getSuccessor(NodeParent n) {
    if (n == null) {
      return null;
    }

    // get the left-most node of the right subtree
    if (n.right != null) {
      n = n.right;
      while (n.left != null) {
        n = n.left;
      }
    } else { // no right subtree, go back up tree
      int cur = n.data;
      if (n.parent != null) {
        n = n.parent;
      } else {
        return null;
      }
      while (n.data < cur) {
        if (n.parent == null) { // reached root node
          return null;
        } else {
          n = n.parent;
        }
      }
    }
    return n;
  }

  public static class NodeParent {

    int data;
    NodeParent left, right, parent;

    public NodeParent(int data) {
      this.data = data;
      parent = null;
      left = null;
      right = null;
    }

    public void setLeft(NodeParent left) {
      this.left = left;
      left.parent = this;
    }

    public void setRight(NodeParent right) {
      this.right = right;
      right.parent = this;
    }
  }

}
