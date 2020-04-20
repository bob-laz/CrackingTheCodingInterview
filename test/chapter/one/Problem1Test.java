package chapter.one;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem1Test {

    @Test
    public void test1() {
        boolean actual = Problem1.isUnique("abcdefg");
        assertTrue(actual);
    }

    @Test
    public void test2() {
        boolean actual = Problem1.isUnique("aABbCcDd!24");
        assertTrue(actual);
    }

    @Test
    public void test3() {
        boolean actual = Problem1.isUnique("abcdea13#");
        assertFalse(actual);
    }

}