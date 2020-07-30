package chapter.four;

/**
 * This binary search tree implementation allows for duplicate values and inserts them to the left.
 */
public class BinarySearchTree {

    Node root;

    // worst case time complexity O(n) where tree is completely unbalanced (all nodes on one side of root)
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

    // worst case time complexity O(n) where tree is completely unbalanced (all nodes on one side of root) and element not fond
    // average case for balanced tree O(log(n)) where log(n) = height of tree
    // best case is O(1) where root is target element
    public boolean contains(int data) {
        return recursiveContains(data, root);
    }

    public boolean recursiveContains(int data, Node n) {
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

    /**
     * Note that on a windows PC I had to run my program with the -Dfile.encoding=UTF-8 VM argument to get the box
     * drawing symbols to display correctly.
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

    private void recursivePrintHelper(StringBuilder sb, String padding, String pointer, Node node, boolean hasRightSibling) {
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
