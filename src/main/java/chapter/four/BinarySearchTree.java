package chapter.four;

/**
 * This binary search tree implementation allows for duplicate values and inserts them to the left.
 */
public class BinarySearchTree {

  Node root;

  // worst case time complexity O(n) where tree is completely unbalanced (all nodes on one side of
  // root)
  // best case for balanced tree O(log(n)) where log(n) = height of tree
  public void insert(int data) {
    root = recursiveInsert(data, root);
  }

  private Node recursiveInsert(int data, Node n) {
    if (n == null) {
      // found leaf, insert
      n = new Node(data);
    } else if (data <= n.data) {
      // recurse left
      n.left = recursiveInsert(data, n.left);
    } else {
      // recurse right
      n.right = recursiveInsert(data, n.right);
    }
    return n;
  }

  // worst case time complexity O(n) where tree is completely unbalanced (all nodes on one side of
  // root) and element not fond
  // average case for balanced tree O(log(n)) where log(n) = height of tree
  // best case is O(1) where root is target element
  public boolean contains(int data) {
    return recursiveContains(data, root);
  }

  private boolean recursiveContains(int data, Node n) {
    if (n == null) {
      // value not found, false
      return false;
    } else if (n.data == data) {
      // value found, true
      return true;
    }
    // recurse left or right depending on value
    return data <= n.data ? recursiveContains(data, n.left) : recursiveContains(data, n.right);
  }

  public void delete(int data) {
    root = recursiveDelete(data, root);
  }

  private Node recursiveDelete(int data, Node n) {
    if (n == null) {
      return n;
    }

    // found node to delete
    if (n.data == data) {
      // node has only one child or is a leaf node
      if (n.left == null) {
        return n.right;
      } else if (n.right == null) {
        return n.left;
      }
      // node has two children
      // find min value in right tree and replace value to be deleted
      n.data = minValue(n.right);
      // delete min value found in previous step from right tree
      n.right = recursiveDelete(n.data, n.right);
    }
    // recurse left
    else if (data <= n.data) {
      n.left = recursiveDelete(data, n.left);
    }
    // recurse right
    else {
      n.right = recursiveDelete(data, n.right);
    }

    return n;
  }

  private int minValue(Node n) {
    int minValue = n.data;
    while (n.left != null) {
      n = n.left;
      minValue = n.data;
    }
    return minValue;
  }

  public void preOrderTraversal() {
    recursivePreOrderTraversal(root);
  }

  private void recursivePreOrderTraversal(Node n) {
    if (n != null) {
      visit(n);
      recursivePreOrderTraversal(n.left);
      recursivePreOrderTraversal(n.right);
    }
  }

  public void postOrderTraversal() {
    recursivePostOrderTraversal(root);
  }

  private void recursivePostOrderTraversal(Node n) {
    if (n != null) {
      recursivePostOrderTraversal(n.left);
      recursivePostOrderTraversal(n.right);
      visit(n);
    }
  }

  public void inOrderTraversal() {
    recursiveInOrderTraversal(root);
  }

  private void recursiveInOrderTraversal(Node n) {
    if (n != null) {
      recursiveInOrderTraversal(n.left);
      visit(n);
      recursiveInOrderTraversal(n.right);
    }
  }

  private void visit(Node n) {
    System.out.print(n.data + " ");
  }

  /**
   * Note that on a windows PC I had to run my program with the -Dfile.encoding=UTF-8 VM argument to
   * get the box drawing symbols to display correctly.
   */
  public void printTree() {
    if (root == null) {
      System.out.println("Tree is empty");
    } else {
      StringBuilder sb = new StringBuilder();
      sb.append(root.data);

      String pointerRight = "└──";
      String pointerLeft = (root.right != null) ? "├──" : "└──";

      recursivePrintHelper(sb, "", pointerLeft, root.left, root.right != null);
      recursivePrintHelper(sb, "", pointerRight, root.right, false);

      System.out.println(sb.toString());
    }
  }

  private void recursivePrintHelper(
      StringBuilder sb, String padding, String pointer, Node node, boolean hasRightSibling) {
    if (node != null) {
      sb.append(System.lineSeparator());
      sb.append(padding);
      sb.append(pointer);
      sb.append(node.data);

      StringBuilder paddingBuilder = new StringBuilder(padding);
      if (hasRightSibling) {
        paddingBuilder.append("│  ");
      } else {
        paddingBuilder.append("   ");
      }

      String paddingForBoth = paddingBuilder.toString();
      String pointerRight = "└──";
      String pointerLeft = (node.right != null) ? "├──" : "└──";

      recursivePrintHelper(sb, paddingForBoth, pointerLeft, node.left, node.right != null);
      recursivePrintHelper(sb, paddingForBoth, pointerRight, node.right, false);
    }
  }

  // checks structural equality as well as value equality, i.e. two trees are only equal if and only
  // if they have all the same values in the exact same tree structure
  @Override
  public boolean equals(Object o) {
    if (!(o instanceof BinarySearchTree)) {
      return false;
    }
    BinarySearchTree thatTree = (BinarySearchTree) o;
    return recursiveEquals(root, thatTree.root);
  }

  public boolean recursiveEquals(Node thisTree, Node thatTree) {
    // same node or both null (reached leaf nodes for both trees)
    if (thisTree == thatTree) {
      return true;
    }
    // only one node is null or values are not equal
    else if (thisTree == null || thatTree == null || thisTree.data != thatTree.data) {
      return false;
    } else {
      // check that subtrees are equal
      return recursiveEquals(thisTree.left, thatTree.left)
          && recursiveEquals(thisTree.right, thatTree.right);
    }
  }

  @Override
  public int hashCode() {
    return recursiveHashCode(root);
  }

  public int recursiveHashCode(Node n) {
    int h = Integer.hashCode(n.data);
    if (n.left != null) {
      h = h * 31 + recursiveHashCode(n.left);
    }
    if (n.right != null) {
      h = h * 31 + recursiveHashCode(n.right);
    }
    return h;
  }

  public static class Node {
    int data;
    Node left, right;

    public Node(int data) {
      this.data = data;
      left = null;
      right = null;
    }
  }
}
