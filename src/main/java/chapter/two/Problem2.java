package chapter.two;

import chapter.two.list.LinkedList;
import chapter.two.list.Node;

/*
    Implement an algorithm to find the kth to the last element of a singly linked list.

    Assuming k=0 returns the last element of the list.
 */
public class Problem2<X> extends LinkedList<X> {

    // trivial solution assuming size is already known and we have a get(index) method
    // O(n) time for traversal of list for get
    // O(1) space, no additional space used
    public X getKFromEnd(int k) {
        if (k >= size) {
            throw new IndexOutOfBoundsException("k must be < size of list");
        }
        return get(size - k - 1);
    }

    // non-trivial solution for unknown size, not using get(index) method
    // O(n) time for single traversal of list
    // O(1) space, constant amount of additional space used (2 pointers)
    public X getKFromEndTrailing(int k) {
        Node<X> cur = first;
        Node<X> trail = first;
        for (int i = 0; i < k; i++) {
            if (cur == null) {
                throw new IndexOutOfBoundsException("k must be < size of list");
            }
            cur = cur.getNext();
        }
        while (cur.getNext() != null) {
            cur = cur.getNext();
            trail = trail.getNext();
        }
        return trail.getItem();
    }
}
