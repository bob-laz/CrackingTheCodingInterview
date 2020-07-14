package chapter.three;

import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class Problem1Test {

    @Test
    public void stackTest() {
        Problem1.MultiStack ms = new Problem1.MultiStack(3);

        // test isEmpty/isFull with empty stack
        assertTrue(ms.isEmpty(0));
        assertTrue(ms.isEmpty(1));
        assertTrue(ms.isEmpty(2));
        assertFalse(ms.isFull(0));
        assertFalse(ms.isFull(1));
        assertFalse(ms.isFull(2));

        // test peek on empty stack
        assertThrows(EmptyStackException.class, () -> ms.peek(0));

        // test operation on invalid stack number
        assertThrows(IndexOutOfBoundsException.class, () -> ms.isEmpty(5));

        // test push and stack capacity
        ms.push(0, 1);
        ms.push(0, 2);
        ms.push(0, 3);
        assertThrows(IllegalStateException.class, () -> ms.push(0, -1));
        ms.push(1, 4);
        ms.push(1, 5);
        ms.push(1, 6);
        assertThrows(IllegalStateException.class, () -> ms.push(1, -1));
        ms.push(2, 7);
        ms.push(2, 8);
        ms.push(2, 9);
        assertThrows(IllegalStateException.class, () -> ms.push(2, -1));

        // test isEmpty/isFull on full stack
        assertFalse(ms.isEmpty(0));
        assertFalse(ms.isEmpty(1));
        assertFalse(ms.isEmpty(2));
        assertTrue(ms.isFull(0));
        assertTrue(ms.isFull(1));
        assertTrue(ms.isFull(2));

        // test peek
        assertEquals(3, ms.peek(0));
        assertEquals(6, ms.peek(1));
        assertEquals(9, ms.peek(2));

        // test pop
        assertEquals(3, ms.pop(0));
        assertEquals(2, ms.pop(0));
        assertEquals(1, ms.pop(0));
        assertThrows(EmptyStackException.class, () -> ms.pop(0));
        assertEquals(6, ms.pop(1));
        assertEquals(5, ms.pop(1));
        assertEquals(4, ms.pop(1));
        assertThrows(EmptyStackException.class, () -> ms.pop(1));
        assertEquals(9, ms.pop(2));
        assertEquals(8, ms.pop(2));
        assertEquals(7, ms.pop(2));
        assertThrows(EmptyStackException.class, () -> ms.pop(2));
    }

}