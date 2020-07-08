package chapter.two;

import chapter.two.list.Node;

import java.util.Stack;

/*
    Implement a function to check if a linked list is a palindrome.
 */
public class Problem6 {

    // if size is known
    // O(n) time, single iteration of loop
    // O(n) space, stack has max size of n/2 elements
    public static boolean isPalindrome(Node<Integer> n, int size) {
        if (size < 2) {
            return true;
        }
        int mid = size / 2, counter = 1, ignore = size % 2 != 0 ? mid + 1 : -1;
        Stack<Integer> stack = new Stack<>();
        while (n != null) {
            if (counter <= mid) {
                stack.push(n.getItem());
            } else if (counter != ignore && stack.pop().intValue() != n.getItem()) {
                return false;
            }
            n = n.getNext();
            counter++;
        }
        return true;
    }

    // if we do not know length of list, use fast and slow runner
    // O(n) time
    // O(n) space for stack
    public static boolean isPalindrome(Node<Integer> n) {
        Node<Integer> fast = n, slow = n;
        Stack<Integer> stack = new Stack<>();

        while (fast != null && fast.getNext() != null) {
            stack.push(slow.getItem());
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        // list length is odd, skip middle value
        if (fast != null) {
            slow = slow.getNext();
        }

        while (slow != null) {
            if (stack.pop().intValue() != slow.getItem()) {
                return false;
            }
            slow = slow.getNext();
        }
        return true;
    }
}
