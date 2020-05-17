package chapter.one;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem5Test {

    @Test
    void oneAway_oneInsertion_true() {
        boolean actual = Problem5.oneAway("ple", "pale");
        assertTrue(actual);
    }

    @Test
    void oneAway_oneRemoval_true() {
        boolean actual = Problem5.oneAway("pale", "ple");
        assertTrue(actual);
    }

    @Test
    void oneAway_oneReplacement_true() {
        boolean actual = Problem5.oneAway("pale", "bale");
        assertTrue(actual);
    }

    @Test
    void oneAway_oneInsertionRepeatedChars_true() {
        boolean actual = Problem5.oneAway("aaaa", "aaaab");
        assertTrue(actual);
    }

    @Test
    void oneAway_oneRemovalRepeatedChars_true() {
        boolean actual = Problem5.oneAway("aabaa", "aaaa");
        assertTrue(actual);
    }

    @Test
    void oneAway_twoInsertions_false() {
        boolean actual = Problem5.oneAway("pale", "paless");
        assertFalse(actual);
    }

    @Test
    void oneAway_twoRemovals_false() {
        boolean actual = Problem5.oneAway("paless", "less");
        assertFalse(actual);
    }

    @Test
    void oneAway_twoReplacements_false() {
        boolean actual = Problem5.oneAway("pale", "bade");
        assertFalse(actual);
    }

    @Test
    void oneAway_oneInsertionOneReplacement_false() {
        boolean actual = Problem5.oneAway("pale", "bales");
        assertFalse(actual);
    }

    @Test
    void oneAway_sameString_true() {
        boolean actual = Problem5.oneAway("pale", "pale");
        assertTrue(actual);
    }
}