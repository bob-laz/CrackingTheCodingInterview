package chapter.one;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem2Test {

    @Test
    public void checkPermutation_diffLengths_false() {
        boolean actual = Problem2.checkPermutation("abc", "abbc");
        assertFalse(actual);
    }

    @Test
    public void checkPermutation_noRepeatedChars_true() {
        boolean actual = Problem2.checkPermutation("abcde", "bcaed");
        assertTrue(actual);
    }

    @Test
    public void checkPermutation_repeatedChars_true() {
        boolean actual = Problem2.checkPermutation("aabbcc", "abcabc");
        assertTrue(actual);
    }

    @Test
    public void checkPermutation_complexString_true() {
        boolean actual = Problem2.checkPermutation("aAbB  %78 !", " %!aAbB78  ");
        assertTrue(actual);
    }

    @Test
    public void checkPermutation_notPermutation_false() {
        boolean actual = Problem2.checkPermutation("aabbcc", "aabccc");
        assertFalse(actual);
    }

}