package chapter.three;

import java.util.EmptyStackException;

/*
    How would you design a stack which, in addition to push and pop, has a function min which returns the minimum
    element? Push, pop and min should all operate in O(1) time.
 */
public class Problem2 {

    // Each node keeps track of the prev min when it is min, when min is popped, min is moved to prevMin value
    static class MinStack {
        private static class MinNode {
            int data;
            MinNode next, prevMin;

            public MinNode(int data) {
                this.data = data;
            }
        }

        private MinNode min, head;

        public void push(int data) {
            MinNode n = new MinNode(data);
            if (min == null) {
                min = n;
            } else if (data < min.data) {
                n.prevMin = min;
                min = n;
            }
            n.next = head;
            head = n;
        }

        public int pop() {
            if (isEmpty()) {
                throw new EmptyStackException();
            }
            if (head == min) {
                min = min.prevMin;
            }
            int popped = head.data;
            head = head.next;
            return popped;
        }

        public int min() {
            if (isEmpty()) {
                throw new EmptyStackException();
            }
            return min.data;
        }

        public int peek() {
            if (isEmpty()) {
                throw new EmptyStackException();
            }
            return head.data;
        }

        public boolean isEmpty() {
            return head == null;
        }
    }
}
