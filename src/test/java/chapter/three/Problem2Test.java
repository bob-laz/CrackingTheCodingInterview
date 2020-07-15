package chapter.three;

import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class Problem2Test {

    @Test
    public void minStackTest() {
        Problem2.MinStack minStack = new Problem2.MinStack();

        assertTrue(minStack.isEmpty());
        assertThrows(EmptyStackException.class, minStack::pop);
        assertThrows(EmptyStackException.class, minStack::min);
        assertThrows(EmptyStackException.class, minStack::peek);

        minStack.push(5);
        assertEquals(5, minStack.peek());
        assertEquals(5, minStack.min());

        assertEquals(5, minStack.pop());
        assertThrows(EmptyStackException.class, minStack::min);

        minStack.push(5);
        minStack.push(6);
        assertEquals(5, minStack.min());

        minStack.push(4);
        assertEquals(4, minStack.min());

        minStack.pop();
        assertEquals(5, minStack.min());

        minStack.push(4);
        minStack.push(5);
        minStack.push(6);
        minStack.push(3);
        minStack.push(10);
        assertEquals(3, minStack.min());

        minStack.pop();
        minStack.pop();

        assertEquals(4, minStack.min());
    }

}