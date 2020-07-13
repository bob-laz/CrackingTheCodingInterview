package chapter.three;

import java.util.NoSuchElementException;

public class Queue<X> {

    private Node<X> front, back;

    private static class Node<X> {
        private X data;
        private Node<X> next;

        public Node(X data) {
            this.data = data;
            next = null;
        }
    }

    public void add(X data) {
        Node<X> newNode = new Node<>(data);
        if (front == null) {
            front = newNode;
        }
        if (back != null) {
            back.next = newNode;
        }
        back = newNode;
    }

    public X remove() {
        if (front == null) {
            throw new NoSuchElementException();
        }
        X data = front.data;
        front = front.next;
        if (front == null) {
            back = null;
        }
        return data;
    }

    public X peek() {
        if (front == null) {
            throw new NoSuchElementException();
        }
        return front.data;
    }

    public boolean isEmpty() {
        return front == null;
    }
}
