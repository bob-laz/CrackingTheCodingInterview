package chapter.three;

import java.util.EmptyStackException;

/*
    Imagine a (literal) stack of plates. If the stack gets too high, it might topple. Therefore, in real life, we would
    likely start a new stack when the previous stack exceeds some threshold. Implement a data structure SetOfStacks that
    mimics this. SetOfStacks should be composed of several stacks and should create a new stack once the previous one
    exceeds capacity. SetOfStacks.push() and SetOfStacks.pop() should behave identically to a single stack (that is,
    pop() should return the same values as it would if there were just a single stack).
 */
public class Problem3 {

    static class SetOfStacks {

        Stack current;
        int maxSize;

        public SetOfStacks(int maxSize) {
            current = new Stack(maxSize);
            this.maxSize = maxSize;
        }

        public void push(int data) {
            if (current.isFull()) {
                Stack newStack = new Stack(maxSize);
                newStack.prevStack = current;
                current = newStack;
            }
            current.push(data);
        }

        public int pop() {
            if (current.isEmpty()) {
                if (current.prevStack == null) {
                    throw new EmptyStackException();
                }
                current = current.prevStack;
            }
            return current.pop();
        }

        public int peek() {
            if (current.isEmpty()) {
                if (current.prevStack != null) {
                    return current.prevStack.peek();
                } else {
                    throw new EmptyStackException();
                }
            }
            return current.peek();
        }

        public boolean isEmpty() {
            return current.isEmpty() && current.prevStack == null;
        }

        private static class Stack {
            private final int maxSize;
            private int size;
            private Node head;
            private Stack prevStack;

            public Stack(int maxSize) {
                this.maxSize = maxSize;
            }

            public void push(int data) {
                if (isFull()) {
                    throw new IllegalStateException("Stack is full");
                }
                Node n = new Node(data);
                n.next = head;
                head = n;
                size++;
            }

            public int pop() {
                if (isEmpty()) {
                    throw new EmptyStackException();
                }
                int data = head.data;
                head = head.next;
                size--;
                return data;
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

            public boolean isFull() {
                return size == maxSize;
            }

            private static class Node {
                int data;
                Node next;

                public Node(int data) {
                    this.data = data;
                }
            }
        }
    }
}
