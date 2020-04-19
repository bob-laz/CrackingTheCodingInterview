package chapter.one;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UrlifyTest {

    @Test
    public void testString1() {
        String testString1 = "Mr John Smith    ";
        char[] actual = Urlify.urlifyImpl(testString1.toCharArray(), 13);
        assertArrayEquals("Mr%20John%20Smith".toCharArray(), actual);
    }

    @Test
    public void testString2() {
        String testString1 = "Cracking the Coding Interview      ";
        char[] actual = Urlify.urlifyImpl(testString1.toCharArray(), 29);
        assertArrayEquals("Cracking%20the%20Coding%20Interview".toCharArray(), actual);
    }

    @Test
    public void testString3() {
        String testString1 = "         ";
        char[] actual = Urlify.urlifyImpl(testString1.toCharArray(), 3);
        assertArrayEquals("%20%20%20".toCharArray(), actual);
    }

    @Test
    public void testString4() {
        String testString1 = "   a b c                   ";
        char[] actual = Urlify.urlifyImpl(testString1.toCharArray(), 11);
        assertArrayEquals("%20%20%20a%20b%20c%20%20%20".toCharArray(), actual);
    }

}