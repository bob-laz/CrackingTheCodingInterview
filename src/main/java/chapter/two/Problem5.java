package chapter.two;

import chapter.two.list.Node;

/*
    You have two numbers represented by a linked list, where each node contains a single digit. The digits are stored in
    reverse order, such that the 1's digit is at the head of the list. Write a function that adds the two numbers and
    returns the sum as a linked list.
 */
public class Problem5 {

    // O(n) time, single list iteration
    // O(1) space, constant amount of additional space used (ish)
    public static Node<Integer> sumLists(Node<Integer> num1, Node<Integer> num2) {
        Node<Integer> sumList = null, currentSum = null;
        int carry = 0;
        while (num1 != null || num2 != null) {
            int sum = carry;
            if (num1 != null) {
                sum += num1.getItem();
                num1 = num1.getNext();
            }
            if (num2 != null) {
                sum += num2.getItem();
                num2 = num2.getNext();
            }
            if (sum > 9) {
                sum -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            if (sumList == null) {
                sumList = new Node<>(sum);
                currentSum = sumList;
            } else {
                currentSum.setNext(new Node<>(sum));
                currentSum = currentSum.getNext();
            }
        }
        if (carry != 0) {
            currentSum.setNext(new Node<>(carry));
        }
        return sumList;
    }
}
