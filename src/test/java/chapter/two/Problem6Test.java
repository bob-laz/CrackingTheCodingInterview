package chapter.two;

import chapter.two.list.Node;
import org.junit.jupiter.api.Test;

import static chapter.two.Problem6.isPalindrome;
import static org.junit.jupiter.api.Assertions.*;

class Problem6Test {

    @Test
    public void isPalindromeTestOdd() {
        Node<Integer> num1 = new Node<>(1);
        Node<Integer> num2 = new Node<>(2);
        Node<Integer> num3 = new Node<>(3);
        Node<Integer> num4 = new Node<>(2);
        Node<Integer> num5 = new Node<>(1);
        num1.setNext(num2);
        num2.setNext(num3);
        num3.setNext(num4);
        num4.setNext(num5);

        assertTrue(isPalindrome(num1, 5));
        assertTrue(isPalindrome(num1));
    }

    @Test
    public void isPalindromeTestEven() {
        Node<Integer> num1 = new Node<>(1);
        Node<Integer> num2 = new Node<>(2);
        Node<Integer> num3 = new Node<>(3);
        Node<Integer> num4 = new Node<>(3);
        Node<Integer> num5 = new Node<>(2);
        Node<Integer> num6 = new Node<>(1);
        num1.setNext(num2);
        num2.setNext(num3);
        num3.setNext(num4);
        num4.setNext(num5);
        num5.setNext(num6);

        assertTrue(isPalindrome(num1, 6));
        assertTrue(isPalindrome(num1));
    }

    @Test
    public void isPalindromeTestFalse() {
        Node<Integer> num1 = new Node<>(1);
        Node<Integer> num2 = new Node<>(2);
        Node<Integer> num3 = new Node<>(3);
        Node<Integer> num4 = new Node<>(3);
        Node<Integer> num5 = new Node<>(2);
        Node<Integer> num6 = new Node<>(2);
        num1.setNext(num2);
        num2.setNext(num3);
        num3.setNext(num4);
        num4.setNext(num5);
        num5.setNext(num6);

        assertFalse(isPalindrome(num1, 6));
        assertFalse(isPalindrome(num1));
    }

}