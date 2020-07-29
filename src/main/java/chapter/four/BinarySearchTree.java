package chapter.four;

public class BinarySearchTree {

    Node root;

    public void insert(int data) {
        if (root == null) root = new Node(data);
        else searchAndInsert(data, root);
    }

    private void searchAndInsert(int data, Node n) {
        if (data <= n.data) {
            if (n.left == null) {
                n.left = new Node(data);
            } else {
                searchAndInsert(data, n.left);
            }
        } else {
            if (n.right == null) {
                n.right = new Node(data);
            } else {
                searchAndInsert(data, n.right);
            }
        }
    }

    private String traversePreOrder(Node root) {
        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(root.data);

        String pointerRight = "└──";
        String pointerLeft = (root.right != null) ? "├──" : "└──";

        traverseNodes(sb, "", pointerLeft, root.left, root.right != null);
        traverseNodes(sb, "", pointerRight, root.right, false);

        return sb.toString();
    }
    private void traverseNodes(StringBuilder sb, String padding, String pointer, Node node,
                               boolean hasRightSibling) {
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

            traverseNodes(sb, paddingForBoth, pointerLeft, node.left, node.right != null);
            traverseNodes(sb, paddingForBoth, pointerRight, node.right, false);
        }

    }

    public void print() {
        System.out.println(traversePreOrder(root));
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
