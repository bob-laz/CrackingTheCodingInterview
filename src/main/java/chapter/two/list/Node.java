package chapter.two.list;

import java.util.Objects;

public class Node<X> {
    private Node<X> next;
    private X item;

    @Override
    public String toString() {
        String retVal = item.toString();
        if (next != null) {
            retVal += ", " + next.toString();
        }
        return retVal;
    }

    public Node(X item) {
        this.next = null;
        this.item = item;
    }

    public void setNext(Node<X> next) {
        this.next = next;
    }

    public Node<X> getNext() {
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
        @SuppressWarnings("unchecked") Node<X> node = (Node<X>) o;
        return Objects.equals(item, node.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item);
    }
}
