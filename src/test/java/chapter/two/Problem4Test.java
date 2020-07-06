package chapter.two;

import chapter.two.list.Node;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem4Test {

    @Test
    public void partitionTest1() {
        Node<Integer> n1 = new Node<>(3);
        Node<Integer> n2 = new Node<>(5);
        Node<Integer> n3 = new Node<>(8);
        Node<Integer> n4 = new Node<>(5);
        Node<Integer> n5 = new Node<>(10);
        Node<Integer> n6 = new Node<>(2);
        Node<Integer> n7 = new Node<>(1);
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        n5.setNext(n6);
        n6.setNext(n7);

        Node<Integer> actual = Problem4.partitionList(n1, 5);

        assertEquals("3, 2, 1, 5, 8, 5, 10", actual.toString());
    }

    @Test
    public void partitionTest2() {
        Node<Integer> n1 = new Node<>(4);
        Node<Integer> n2 = new Node<>(6);
        Node<Integer> n3 = new Node<>(2);
        Node<Integer> n4 = new Node<>(1);
        Node<Integer> n5 = new Node<>(8);
        Node<Integer> n6 = new Node<>(4);
        Node<Integer> n7 = new Node<>(10);
        Node<Integer> n8 = new Node<>(5);
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        n5.setNext(n6);
        n6.setNext(n7);
        n7.setNext(n8);

        Node<Integer> actual = Problem4.partitionList(n1, 5);

        assertEquals("4, 2, 1, 4, 6, 8, 10, 5", actual.toString());
    }

    @Test
    public void partitionTestWithNull() {
        Node<Integer> n1 = new Node<>(null);

        Node<Integer> actual = Problem4.partitionList(n1, 5);

        assertNull(actual);
    }

    @Test
    public void partitionTestWithSingleItemPartitionAbove() {
        Node<Integer> n1 = new Node<>(1);

        Node<Integer> actual = Problem4.partitionList(n1, 5);

        assertEquals("1", actual.toString());
    }

    @Test
    public void partitionTestWithSingleItemPartitionBelow() {
        Node<Integer> n1 = new Node<>(5);

        Node<Integer> actual = Problem4.partitionList(n1, 1);

        assertEquals("5", actual.toString());
    }

    @Test
    public void partitionTestWithTwoItemsPartitionAbove() {
        Node<Integer> n1 = new Node<>(2);
        Node<Integer> n2 = new Node<>(4);
        n1.setNext(n2);

        Node<Integer> actual = Problem4.partitionList(n1, 5);

        assertEquals("2, 4", actual.toString());
    }

    @Test
    public void partitionTestWithTwoItemsPartitionBelow() {
        Node<Integer> n1 = new Node<>(2);
        Node<Integer> n2 = new Node<>(4);
        n1.setNext(n2);

        Node<Integer> actual = Problem4.partitionList(n1, 1);

        assertEquals("2, 4", actual.toString());
    }

    @Test
    public void partitionTestWithTwoItemsPartitionBetween() {
        Node<Integer> n1 = new Node<>(4);
        Node<Integer> n2 = new Node<>(2);
        n1.setNext(n2);

        Node<Integer> actual = Problem4.partitionList(n1, 3);

        assertEquals("2, 4", actual.toString());
    }
}