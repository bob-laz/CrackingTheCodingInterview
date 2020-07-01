package chapter.two;

import chapter.two.list.Node;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem3Test {

    @Test
    public void problem3Test1(){
        Node<Character> n1 = new Node<>('A');
        Node<Character> n2 = new Node<>('B');
        Node<Character> n3 = new Node<>('C');
        Node<Character> n4 = new Node<>('D');
        Node<Character> n5 = new Node<>('E');
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);

        assertEquals("A, B, C, D, E", n1.toString());

        Problem3<Character> systemUnderTest = new Problem3<>();
        systemUnderTest.deleteMiddleNode(n3);

        assertEquals("A, B, D, E", n1.toString());
    }

    @Test
    public void problem3Test2(){
        Node<Integer> n1 = new Node<>(1);
        Node<Integer> n2 = new Node<>(2);
        Node<Integer> n3 = new Node<>(3);
        Node<Integer> n4 = new Node<>(4);
        Node<Integer> n5 = new Node<>(5);
        Node<Integer> n6 = new Node<>(6);
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        n5.setNext(n6);

        assertEquals("1, 2, 3, 4, 5, 6", n1.toString());

        Problem3<Integer> systemUnderTest = new Problem3<>();
        systemUnderTest.deleteMiddleNode(n2);

        assertEquals("1, 3, 4, 5, 6", n1.toString());
    }
}
