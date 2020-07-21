package chapter.three;

import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class Problem3Test {

    @Test
    public void stackTest() {
        Problem3.SetOfStacks setOfStacks = new Problem3.SetOfStacks(3);

        // test isEmpty with empty stack
        assertTrue(setOfStacks.isEmpty());

        // test peek & pop on empty stack
        assertThrows(EmptyStackException.class, setOfStacks::peek);
        assertThrows(EmptyStackException.class, setOfStacks::pop);

        // test push beyond individual stack size
        setOfStacks.push(1);
        setOfStacks.push(2);
        setOfStacks.push(3);
        setOfStacks.push(4);
        setOfStacks.push(5);
        setOfStacks.push(6);
        setOfStacks.push(7);

        // test isEmpty on populated stack
        assertFalse(setOfStacks.isEmpty());

        // test peek
        assertEquals(7, setOfStacks.peek());

        // test pop
        assertEquals(7, setOfStacks.pop());
        assertEquals(6, setOfStacks.pop());
        assertEquals(5, setOfStacks.pop());
        assertEquals(4, setOfStacks.pop());
        assertEquals(3, setOfStacks.pop());
        assertEquals(2, setOfStacks.pop());
        assertEquals(1, setOfStacks.pop());
        assertThrows(EmptyStackException.class, setOfStacks::pop);
    }
}