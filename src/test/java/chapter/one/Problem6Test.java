package chapter.one;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem6Test {

    @Test
    public void compress_manyRepeats_compressedString() {
        String expected = "a2b1c5a3";
        String actual = Problem6.compress("aabcccccaaa");
        assertEquals(expected, actual);
    }

    @Test
    public void compress_manyRepeatsTwo_compressedString() {
        String expected = "a1b1a1b1e6f5d1c1";
        String actual = Problem6.compress("ababeeeeeefffffdc");
        assertEquals(expected, actual);
    }

    @Test
    public void compress_manyRepeatsCapitalLetters_compressedString() {
        String expected = "a1b1a1b1e6F5d1c1";
        String actual = Problem6.compress("ababeeeeeeFFFFFdc");
        assertEquals(expected, actual);
    }

    @Test
    public void compress_noRepeats_originalString() {
        String expected = "abcdefg";
        String actual = Problem6.compress("abcdefg");
        assertEquals(expected, actual);
    }

    @Test
    public void compress_stringLengthOne_originalString() {
        String expected = "a";
        String actual = Problem6.compress("a");
        assertEquals(expected, actual);
    }

}