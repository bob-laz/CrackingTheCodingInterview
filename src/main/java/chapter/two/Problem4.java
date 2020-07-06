package chapter.two;

import chapter.two.list.Node;

/*
    Write code to partition a linked list around a value x, such that all nodes less than x come before all nodes
    greater than or equal to x. If x is contained within the list, the values of x only need to be after the elements
    less than x (see below). The partition element x can appear anywhere in the "right partition"; it does not need to
    appear between the left and right partitions.
 */
public class Problem4 {

    // O(n) runtime since we iterate over list once
    // O(1) space, constant number of pointers created
    public static Node<Integer> partitionList(Node<Integer> n, int part) {
        Node<Integer> ltPointer = null, ltHead = null, gtePointer = null, gteHead = null;
        while (n != null && n.getItem() != null) {
            Node<Integer> next = n.getNext();
            n.setNext(null);
            if (n.getItem() < part) {
                if (ltPointer == null) {
                    ltPointer = n;
                    ltHead = n;
                } else {
                    ltPointer.setNext(n);
                    ltPointer = ltPointer.getNext();
                }
            } else {
                if (gtePointer == null) {
                    gtePointer = n;
                    gteHead = n;
                } else {
                    gtePointer.setNext(n);
                    gtePointer = gtePointer.getNext();
                }
            }
            n = next;
        }
        if (ltPointer == null) {
            return gteHead;
        }
        ltPointer.setNext(gteHead);
        return ltHead;
    }
}
