package chapter.two;

import chapter.two.list.Node;

/*
    Given two (singly) linked lists, determine if the two lists intersect. Return the intersecting node. Note that the
    intersection is defined based on reference, not value. That is, if the kth node of the first linked list is the
    exact same node (by reference) as the jth node of the second linked list, then they are intersecting.
 */
public class Problem7 {

    // O(n) time, iterating over each list once
    // O(1) space, constant amount of extra space used for pointers and counting length
    public static Node<Integer> intersection(Node<Integer> aHead, Node<Integer> bHead) {
        if (aHead == null || bHead == null) {
            return null;
        }
        int aLength = 1, bLength = 1;
        Node<Integer> aTail = aHead, bTail = bHead;
        while (aTail.getNext() != null) {
            aLength++;
            aTail = aTail.getNext();
        }
        while (bTail.getNext() != null) {
            bLength++;
            bTail = bTail.getNext();
        }
        if (aTail != bTail) {
            return null;
        } else {
            if (aLength > bLength) {
                for (int i = 0; i < aLength - bLength; i++) {
                    aHead = aHead.getNext();
                }
            } else if (bLength > aLength) {
                for (int i = 0; i < bLength - aLength; i++) {
                    bHead = bHead.getNext();
                }
            }
            while (aHead != bHead) {
                aHead = aHead.getNext();
                bHead = bHead.getNext();
            }
            return aHead;
        }
    }
}
