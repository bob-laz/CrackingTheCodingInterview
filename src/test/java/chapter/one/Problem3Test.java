package chapter.one;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Problem3Test {

    @Test
    public void urlify_basicString_encodedCorrectly() {
        String testString = "Mr John Smith    ";
        char[] actual = Problem3.Urlify(testString.toCharArray(), 13);
        assertArrayEquals("Mr%20John%20Smith".toCharArray(), actual);
    }

    @Test
    public void urlify_longerString_encodedCorrectly() {
        String testString = "Cracking the Coding Interview      ";
        char[] actual = Problem3.Urlify(testString.toCharArray(), 29);
        assertArrayEquals("Cracking%20the%20Coding%20Interview".toCharArray(), actual);
    }

    @Test
    public void urlify_onlySpaces_encodedCorrectly() {
        String testString = "         ";
        char[] actual = Problem3.Urlify(testString.toCharArray(), 3);
        assertArrayEquals("%20%20%20".toCharArray(), actual);
    }

    @Test
    public void urlify_leadingMiddleAndTrailingSpace_encodedCorrectly() {
        String testString = "   a b c                   ";
        char[] actual = Problem3.Urlify(testString.toCharArray(), 11);
        assertArrayEquals("%20%20%20a%20b%20c%20%20%20".toCharArray(), actual);
    }

    @Test
    public void urlify_noSpaces_encodedCorrectly() {
        String testString = "iHaveNoSpaces";
        char[] actual = Problem3.Urlify(testString.toCharArray(), 13);
        assertArrayEquals("iHaveNoSpaces".toCharArray(), actual);
    }

}