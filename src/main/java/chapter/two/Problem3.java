package chapter.two;

import chapter.two.list.Node;

/*
    Implement an algorithm to delete a node in the middle (i.e., any node but the first and last node, not necessarily
    the exact middle) of a singly linked list, given only access to that node.
 */
public class Problem3<X> {

    // O(1) time, O(1) space
    public void deleteMiddleNode(Node<X> n) {
        if (n == null || n.getNext() == null) {
            throw new IllegalArgumentException("Node cannot be null or last element in list");
        }

        n.setItem(n.getNext().getItem());
        n.setNext(n.getNext().getNext());
    }
}
