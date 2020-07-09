package chapter.two;

import chapter.two.list.Node;
import org.junit.jupiter.api.Test;

import static chapter.two.Problem7.intersection;
import static org.junit.jupiter.api.Assertions.*;

class Problem7Test {

    @Test
    public void intersectionTestDiffLengths() {
        Node<Integer> aHead = new Node<>(1);
        Node<Integer> num2 = new Node<>(2);
        Node<Integer> num3 = new Node<>(3);
        Node<Integer> num4 = new Node<>(4);
        Node<Integer> num5 = new Node<>(5);
        Node<Integer> num6 = new Node<>(6);
        aHead.setNext(num2);
        num2.setNext(num3);
        num3.setNext(num4);
        num4.setNext(num5);
        num5.setNext(num6);

        Node<Integer> bHead = new Node<>(3);
        bHead.setNext(num4);

        System.out.println("list A: " + aHead);
        System.out.println("list B: " + bHead);

        Node<Integer> actual = intersection(aHead, bHead);
        assertSame(actual, num4);
    }

    @Test
    public void intersectionTestSameLengths() {
        Node<Integer> aHead = new Node<>(1);
        Node<Integer> num2 = new Node<>(2);
        Node<Integer> num3 = new Node<>(3);
        Node<Integer> num4 = new Node<>(4);
        Node<Integer> num5 = new Node<>(5);
        Node<Integer> num6 = new Node<>(6);
        aHead.setNext(num2);
        num2.setNext(num3);
        num3.setNext(num4);
        num4.setNext(num5);
        num5.setNext(num6);

        Node<Integer> bHead = new Node<>(1);
        Node<Integer> numb2 = new Node<>(2);
        Node<Integer> numb3 = new Node<>(3);
        bHead.setNext(numb2);
        numb2.setNext(numb3);
        numb3.setNext(num4);

        System.out.println("list A: " + aHead);
        System.out.println("list B: " + bHead);

        Node<Integer> actual = intersection(aHead, bHead);
        assertSame(actual, num4);
    }

    @Test
    public void intersectionTestNoIntersection() {
        Node<Integer> aHead = new Node<>(1);
        Node<Integer> num2 = new Node<>(2);
        Node<Integer> num3 = new Node<>(3);
        Node<Integer> num4 = new Node<>(4);
        Node<Integer> num5 = new Node<>(5);
        Node<Integer> num6 = new Node<>(6);
        aHead.setNext(num2);
        num2.setNext(num3);
        num3.setNext(num4);
        num4.setNext(num5);
        num5.setNext(num6);

        Node<Integer> bHead = new Node<>(1);
        Node<Integer> numb2 = new Node<>(2);
        Node<Integer> numb3 = new Node<>(3);
        Node<Integer> numb4 = new Node<>(4);
        Node<Integer> numb5 = new Node<>(5);
        Node<Integer> numb6 = new Node<>(6);
        bHead.setNext(numb2);
        numb2.setNext(numb3);
        numb3.setNext(numb4);
        numb4.setNext(numb5);
        numb5.setNext(numb6);

        System.out.println("list A: " + aHead);
        System.out.println("list B: " + bHead);

        Node<Integer> actual = intersection(aHead, bHead);
        assertNull(actual);
    }

    @Test
    public void intersectionTestNoIntersectionLength1() {
        Node<Integer> aHead = new Node<>(1);
        Node<Integer> bHead = new Node<>(1);


        System.out.println("list A: " + aHead);
        System.out.println("list B: " + bHead);

        Node<Integer> actual = intersection(aHead, bHead);
        assertNull(actual);
    }


    @Test
    public void intersectionTestLength1() {
        Node<Integer> aHead = new Node<>(1);
        Node<Integer> bHead = aHead;

        System.out.println("list A: " + aHead);
        System.out.println("list B: " + bHead);

        Node<Integer> actual = intersection(aHead, bHead);
        assertSame(actual, aHead);
    }

    @Test
    public void intersectionTestNullInput() {
        Node<Integer> actual = intersection(null, null);
        assertNull(actual);
    }

}