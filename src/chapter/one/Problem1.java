package chapter.one;

/*
    Implement an algorithm to determine if a string has all unique characters.

    Assuming charset is ASCII, case sensitive and whitespace matters
 */
public class Problem1 {

    // O(1) runtime because max iterations loop is constant at 128
    // O(1) space because storage used is fixed
    public static boolean isUnique(String str) {
        if (str.length() > 128) { // assuming ascii charset
            return false;
        }

        // keep track of each char seen in boolean array
        boolean[] seenBefore = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            // if this value is already true we've seen this character before
            if (seenBefore[str.charAt(i)]) {
                return false;
            }
            // set chars we have seen before to true
            seenBefore[str.charAt(i)] = true;
        }

        return true;
    }
}
