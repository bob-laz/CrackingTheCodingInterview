package chapter.one;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Problem4Test {

    @Test
    public void palindromePermutation_oddPalindrome_true() {
        boolean actual = Problem4.palindromePermutation("racecar");
        assertTrue(actual);
    }

    @Test
    public void palindromePermutation_evenPalindrome_true() {
        boolean actual = Problem4.palindromePermutation("noon");
        assertTrue(actual);
    }

    @Test
    public void palindromePermutation_oddPalindromeScrambled_true() {
        boolean actual = Problem4.palindromePermutation("cecarar");
        assertTrue(actual);
    }

    @Test
    public void palindromePermutation_evenPalindromeScrambled_true() {
        boolean actual = Problem4.palindromePermutation("onon");
        assertTrue(actual);
    }

    @Test
    public void palindromePermutation_notPalindrome_false() {
        boolean actual = Problem4.palindromePermutation("nooooooo");
        assertFalse(actual);
    }

    @Test
    public void palindromePermutation_palindromeSpecialChars_true() {
        boolean actual = Problem4.palindromePermutation("r$e4c-a r_a`c");
        assertTrue(actual);
    }

    @Test
    public void palindromePermutation_palindromeCapitals_true() {
        boolean actual = Problem4.palindromePermutation("r$e4c-A r_a`c");
        assertTrue(actual);
    }

}