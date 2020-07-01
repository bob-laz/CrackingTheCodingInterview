package chapter.two;

import chapter.two.list.LinkedList;
import chapter.two.list.Node;

import java.util.HashSet;
import java.util.Set;

/*
    Write code to remove duplicates from an unsorted linked list.
 */
public class Problem1<X> extends LinkedList<X> {

    // O(n) run time since we iterate over the list once
    // O(n) space since we create a map potentially equal to the size of the list
    public void removeDuplicates() {
        if (size == 0) return;

        Set<X> seenBefore = new HashSet<>();
        Node<X> current = first;
        seenBefore.add(first.getItem());

        while (current.getNext() != null) {
            if (seenBefore.contains(current.getNext().getItem())) {
                current.setNext(current.getNext().getNext());
                size--;
            } else {
                seenBefore.add(current.getNext().getItem());
                current = current.getNext();
            }
        }
    }

    // implementation using a trailing value instead of a lookahead value
    public void removeDuplicatesPrevious() {
        Set<X> seenBefore = new HashSet<>();
        Node<X> prev = null, cur = first;
        while (cur != null) {
            if (seenBefore.contains(cur.getItem())) {
                prev.setNext(cur.getNext());
                size--;
            } else {
                seenBefore.add(cur.getItem());
                prev = cur;
            }
            cur = cur.getNext();
        }
    }

    // O(n^2) time but O(1) space
    public void removeDuplicatesNoBuffer() {
        Node<X> cur = first;
        while (cur != null) {
            Node<X> runner = cur;
            while (runner.getNext() != null) {
                if (runner.getNext().getItem().equals(cur.getItem())) {
                    runner.setNext(runner.getNext().getNext());
                    size--;
                } else {
                    runner = runner.getNext();
                }
            }
            cur = cur.getNext();
        }
    }
}
