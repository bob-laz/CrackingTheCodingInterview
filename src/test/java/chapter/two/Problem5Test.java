package chapter.two;

import chapter.two.list.Node;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem5Test {

    @Test
    public void sumListTest1() {
        Node<Integer> num1_1 = new Node<>(7);
        Node<Integer> num1_2 = new Node<>(1);
        Node<Integer> num1_3 = new Node<>(6);
        num1_1.setNext(num1_2);
        num1_2.setNext(num1_3);

        Node<Integer> num2_1 = new Node<>(5);
        Node<Integer> num2_2 = new Node<>(9);
        Node<Integer> num2_3 = new Node<>(2);
        num2_1.setNext(num2_2);
        num2_2.setNext(num2_3);

        Node<Integer> actual = Problem5.sumLists(num1_1, num2_1);

        assertEquals("2, 1, 9", actual.toString());
    }

    @Test
    public void sumListTest2() {
        Node<Integer> num1_1 = new Node<>(9);
        Node<Integer> num1_2 = new Node<>(9);
        Node<Integer> num1_3 = new Node<>(9);
        num1_1.setNext(num1_2);
        num1_2.setNext(num1_3);

        Node<Integer> num2_1 = new Node<>(9);
        Node<Integer> num2_2 = new Node<>(9);
        Node<Integer> num2_3 = new Node<>(9);
        num2_1.setNext(num2_2);
        num2_2.setNext(num2_3);

        Node<Integer> actual = Problem5.sumLists(num1_1, num2_1);

        assertEquals("8, 9, 9, 1", actual.toString());
    }

    @Test
    public void sumListTest3() {
        Node<Integer> num1_1 = new Node<>(2);
        Node<Integer> num1_2 = new Node<>(8);
        Node<Integer> num1_3 = new Node<>(4);
        Node<Integer> num1_4 = new Node<>(1);
        num1_1.setNext(num1_2);
        num1_2.setNext(num1_3);
        num1_3.setNext(num1_4);

        Node<Integer> num2_1 = new Node<>(6);
        Node<Integer> num2_2 = new Node<>(4);
        Node<Integer> num2_3 = new Node<>(9);
        num2_1.setNext(num2_2);
        num2_2.setNext(num2_3);

        Node<Integer> actual = Problem5.sumLists(num1_1, num2_1);

        assertEquals("8, 2, 4, 2", actual.toString());
    }

    @Test
    public void sumListTest4() {
        Node<Integer> num1_1 = new Node<>(6);
        Node<Integer> num1_2 = new Node<>(8);
        Node<Integer> num1_3 = new Node<>(4);
        num1_1.setNext(num1_2);
        num1_2.setNext(num1_3);

        Node<Integer> num2_1 = new Node<>(0);

        Node<Integer> actual = Problem5.sumLists(num1_1, num2_1);

        assertEquals("6, 8, 4", actual.toString());
    }
}