package chapter.two;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Problem1Test {

    @Test
    void manyDuplicatesTest() {
        Problem1<Integer> actual = new Problem1<>();
        actual.addAll(List.of(3, 9, 2, 2, 9, 2, 6, 1, 6));

        actual.removeDuplicates();

        Problem1<Integer> expected = new Problem1<>();
        expected.addAll(List.of(3, 9, 2, 6, 1));

        assertEquals(expected, actual);
    }

    @Test
    void noDuplicatesTest() {
        Problem1<Integer> actual = new Problem1<>();
        actual.addAll(List.of(3, 9, 2, 6, 1));

        actual.removeDuplicates();

        Problem1<Integer> expected = new Problem1<>();
        expected.addAll(List.of(3, 9, 2, 6, 1));

        assertEquals(expected, actual);
    }

    @Test
    void oneDuplicateTest() {
        Problem1<Integer> actual = new Problem1<>();
        actual.addAll(List.of(3, 9, 2, 6, 1, 1));

        actual.removeDuplicates();

        Problem1<Integer> expected = new Problem1<>();
        expected.addAll(List.of(3, 9, 2, 6, 1));

        assertEquals(expected, actual);
    }

    @Test
    void oneDuplicateFirstTest() {
        Problem1<Integer> actual = new Problem1<>();
        actual.addAll(List.of(3, 3, 9, 2, 6, 1, 1));

        actual.removeDuplicates();

        Problem1<Integer> expected = new Problem1<>();
        expected.addAll(List.of(3, 9, 2, 6, 1));

        assertEquals(expected, actual);
    }

    @Test
    void emptyList() {
        Problem1<Integer> actual = new Problem1<>();

        actual.removeDuplicates();

        Problem1<Integer> expected = new Problem1<>();

        assertEquals(expected, actual);
    }

    @Test
    void manyDuplicatesPrevTest() {
        Problem1<Integer> actual = new Problem1<>();
        actual.addAll(List.of(3, 9, 2, 2, 9, 2, 6, 1, 6));

        actual.removeDuplicatesPrevious();

        Problem1<Integer> expected = new Problem1<>();
        expected.addAll(List.of(3, 9, 2, 6, 1));

        assertEquals(expected, actual);
    }

    @Test
    void noDuplicatesPrevTest() {
        Problem1<Integer> actual = new Problem1<>();
        actual.addAll(List.of(3, 9, 2, 6, 1));

        actual.removeDuplicatesPrevious();

        Problem1<Integer> expected = new Problem1<>();
        expected.addAll(List.of(3, 9, 2, 6, 1));

        assertEquals(expected, actual);
    }

    @Test
    void oneDuplicatePrevTest() {
        Problem1<Integer> actual = new Problem1<>();
        actual.addAll(List.of(3, 9, 2, 6, 1, 1));

        actual.removeDuplicatesPrevious();

        Problem1<Integer> expected = new Problem1<>();
        expected.addAll(List.of(3, 9, 2, 6, 1));

        assertEquals(expected, actual);
    }

    @Test
    void oneDuplicateFirstPrevTest() {
        Problem1<Integer> actual = new Problem1<>();
        actual.addAll(List.of(3, 3, 9, 2, 6, 1, 1));

        actual.removeDuplicatesPrevious();

        Problem1<Integer> expected = new Problem1<>();
        expected.addAll(List.of(3, 9, 2, 6, 1));

        assertEquals(expected, actual);
    }

    @Test
    void emptyListPrev() {
        Problem1<Integer> actual = new Problem1<>();

        actual.removeDuplicatesPrevious();

        Problem1<Integer> expected = new Problem1<>();

        assertEquals(expected, actual);
    }

    @Test
    void manyDuplicatesNoBufferTest() {
        Problem1<Integer> actual = new Problem1<>();
        actual.addAll(List.of(3, 9, 2, 2, 9, 2, 6, 1, 6));

        actual.removeDuplicatesNoBuffer();

        Problem1<Integer> expected = new Problem1<>();
        expected.addAll(List.of(3, 9, 2, 6, 1));

        assertEquals(expected, actual);
    }

    @Test
    void noDuplicatesNoBufferTest() {
        Problem1<Integer> actual = new Problem1<>();
        actual.addAll(List.of(3, 9, 2, 6, 1));

        actual.removeDuplicatesNoBuffer();

        Problem1<Integer> expected = new Problem1<>();
        expected.addAll(List.of(3, 9, 2, 6, 1));

        assertEquals(expected, actual);
    }

    @Test
    void oneDuplicateNoBufferTest() {
        Problem1<Integer> actual = new Problem1<>();
        actual.addAll(List.of(3, 9, 2, 6, 1, 1));

        actual.removeDuplicatesNoBuffer();

        Problem1<Integer> expected = new Problem1<>();
        expected.addAll(List.of(3, 9, 2, 6, 1));

        assertEquals(expected, actual);
    }

    @Test
    void oneDuplicateFirstNoBufferTest() {
        Problem1<Integer> actual = new Problem1<>();
        actual.addAll(List.of(3, 3, 9, 2, 6, 1, 1));

        actual.removeDuplicatesNoBuffer();

        Problem1<Integer> expected = new Problem1<>();
        expected.addAll(List.of(3, 9, 2, 6, 1));

        assertEquals(expected, actual);
    }

    @Test
    void emptyListNoBuffer() {
        Problem1<Integer> actual = new Problem1<>();

        actual.removeDuplicatesNoBuffer();

        Problem1<Integer> expected = new Problem1<>();

        assertEquals(expected, actual);
    }
}