package chapter.three;

import java.util.EmptyStackException;

public class Stack<X> {

    private Node<X> top;

    private static class Node<X> {
        private X data;
        private Node<X> next;

        public Node(X data) {
            this.data = data;
            next = null;
        }
    }

    public void push(X data) {
        Node<X> newNode = new Node<>(data);
        newNode.next = top;
        top = newNode;
    }

    public X pop() {
        if (top == null) {
            throw new EmptyStackException();
        }
        X data = top.data;
        top = top.next;
        return data;
    }

    public X peek() {
        if (top == null) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}
