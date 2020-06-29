package chapter.two;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Problem2Test {

    @Test
    public void getKFromEndTest() {
        Problem2<Integer> myList = new Problem2<>();
        myList.addAll(List.of(3, 9, 2, 2, 9, 2, 6, 1, 6));

        assertEquals(6, myList.getKFromEnd(0));
        assertEquals(1, myList.getKFromEnd(1));
        assertEquals(6, myList.getKFromEnd(2));
        assertEquals(2, myList.getKFromEnd(3));
        assertEquals(3, myList.getKFromEnd(8));
        assertThrows(IndexOutOfBoundsException.class, () -> myList.getKFromEnd(10));
    }

    @Test
    public void getKFromEndTestTrail() {
        Problem2<Integer> myList = new Problem2<>();
        myList.addAll(List.of(3, 9, 2, 2, 9, 2, 6, 1, 6));

        assertEquals(6, myList.getKFromEndTrailing(0));
        assertEquals(1, myList.getKFromEndTrailing(1));
        assertEquals(6, myList.getKFromEndTrailing(2));
        assertEquals(2, myList.getKFromEndTrailing(3));
        assertEquals(3, myList.getKFromEndTrailing(8));
        assertThrows(IndexOutOfBoundsException.class, () -> myList.getKFromEndTrailing(10));
    }

}