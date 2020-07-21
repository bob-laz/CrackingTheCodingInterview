package chapter.three;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem5Test {

    @Test
    public void stackSortTest() {
        Stack s1 = new Stack();
        s1.push(1);
        s1.push(9);
        s1.push(4);
        s1.push(2);
        s1.push(5);

        Stack sortedS1 = Problem5.sort(s1);
        assertEquals("1, 2, 4, 5, 9", sortedS1.toString());
        assertEquals(1, sortedS1.pop());
        assertEquals(2, sortedS1.pop());
        assertEquals(4, sortedS1.pop());
        assertEquals(5, sortedS1.pop());
        assertEquals(9, sortedS1.pop());

        Stack s2 = new Stack();
        s2.push(81);
        s2.push(85);
        s2.push(99);
        s2.push(45);
        s2.push(118);
        s2.push(4);
        s2.push(205);
        s2.push(118);
        s2.push(999);
        s2.push(-5);

        Stack sortedS2 = Problem5.sort(s2);
        assertEquals("-5, 4, 45, 81, 85, 99, 118, 118, 205, 999", sortedS2.toString());
    }

}