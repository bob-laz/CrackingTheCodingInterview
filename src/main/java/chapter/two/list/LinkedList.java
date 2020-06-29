package chapter.two.list;

import java.util.Collection;
import java.util.Objects;

public class LinkedList<X> implements ListInf<X> {

    protected Node first;
    protected Node last;
    protected int size;

    public LinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    public LinkedList(Collection<X> items) {
        this();
        items.forEach(this::add);
    }

    // add to end
    public void add(X item) {
        if (item == null) {
            throw new IllegalArgumentException("cannot add null items to list");
        }
        Node newItem = new Node(item);
        if (first == null) {
            first = newItem;
            last = first;
        } else {
            last.setNext(newItem);
            last = newItem;
        }
        size++;
    }

    public final void addAll(Collection<X> items) {
        items.forEach(this::add);
    }

    // remove from front
    public X remove() {
        if (first == null) {
            throw new IllegalStateException("The LinkedList is empty");
        }
        X firstItem = first.getItem();
        first = first.getNext();
        size--;
        return firstItem;
    }

    public void insert(X item, int position) {
        if (position > size()) {
            throw new IllegalArgumentException("Position is greater than length of list");
        }
        Node currentNode = first;
        Node newNode = new Node(item);

        if (position == 0) {
            newNode.setNext(currentNode);
            first = newNode;
        } else {
            for (int i = 1; i < position; i++) {
                currentNode = currentNode.getNext();
            }
            newNode.setNext(currentNode.getNext());
            currentNode.setNext(newNode);
        }
        size++;
    }

    public X removeAt(int position) {
        if (position > size()) {
            throw new IllegalArgumentException("Position is greater than length of list");
        }

        if (position == 0) {
            return remove();
        }

        Node currentNode = first;
        for (int i = 1; i < position; i++) {
            currentNode = currentNode.getNext();
        }
        Node removeNode = currentNode.getNext();
        currentNode.setNext(removeNode.getNext());

        // if we removed the last item, update last
        if (position == (size() - 1)) {
            last = currentNode;
        }

        size--;
        return removeNode.getItem();
    }

    public X get(int position) {
        if (size() == 0 || position > size()) {
            throw new IllegalArgumentException("Position is greater than length of list or list is empty");
        }

        Node currentNode = first;
        for (int i = 0; i < position; i++) {
            currentNode = currentNode.getNext();
        }
        return currentNode.getItem();
    }

    public int find(X item) {
        Node currentNode = first;
        for (int i = 0; i < size(); i++) {
            if (currentNode.getItem().equals(item)) return i;
            currentNode = currentNode.getNext();
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder contents = new StringBuilder();
        Node currentNode = first;

        while (currentNode != null) {
            contents.append(currentNode.getItem());
            currentNode = currentNode.getNext();

            if (currentNode != null) {
                contents.append(", ");
            }
        }
        return contents.toString();
    }

    public int size() {
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkedList<?> that = (LinkedList<?>) o;
        if (size != that.size()) return false;
        if (size == 0 && that.size() == 0) return true;

        Node thisCur = this.first;
        LinkedList<?>.Node thatCur = that.first;

        while (thisCur != null) {
            if (!thisCur.getItem().equals(thatCur.getItem())) {
                return false;
            }
            thisCur = thisCur.getNext();
            thatCur = thatCur.getNext();
        }

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, last, size);
    }

    protected class Node {
        private Node next;
        private X item;

        Node(X item) {
            this.next = null;
            this.item = item;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getNext() {
            return this.next;
        }

        public X getItem() {
            return this.item;
        }

        public void setItem(X item) {
            this.item = item;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            @SuppressWarnings("unchecked") Node node = (Node) o;
            return Objects.equals(item, node.item);
        }

        @Override
        public int hashCode() {
            return Objects.hash(item);
        }
    }
}
