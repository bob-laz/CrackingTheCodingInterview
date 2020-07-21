package chapter.three;

import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class Problem4Test {

    @Test
    public void queueTest() {
        Problem4.MyQueue setOfStacks = new Problem4.MyQueue();

        // test isEmpty with empty queue
        assertTrue(setOfStacks.isEmpty());

        // test peek & remove on empty queue
        assertThrows(EmptyStackException.class, setOfStacks::peek);
        assertThrows(EmptyStackException.class, setOfStacks::remove);

        // test add
        setOfStacks.add(1);
        setOfStacks.add(2);
        setOfStacks.add(3);
        setOfStacks.add(4);
        setOfStacks.add(5);

        // test isEmpty on populated queue
        assertFalse(setOfStacks.isEmpty());

        // test peek
        assertEquals(1, setOfStacks.peek());

        // test remove
        assertEquals(1, setOfStacks.remove());
        assertEquals(2, setOfStacks.remove());
        assertEquals(3, setOfStacks.remove());
        setOfStacks.add(6);
        setOfStacks.add(7);
        assertEquals(4, setOfStacks.remove());
        assertEquals(5, setOfStacks.remove());
        assertEquals(6, setOfStacks.remove());
        assertEquals(7, setOfStacks.remove());
        assertThrows(EmptyStackException.class, setOfStacks::remove);
    }

}