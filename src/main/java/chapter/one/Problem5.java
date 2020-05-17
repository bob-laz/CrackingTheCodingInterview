package chapter.one;

/*
    There are three types of edits that can be performed on strings: insert a character, remove a character, or replace
    a character. Given two strings, write a function to check tif they are one edit (or zero edits) away.

    Assuming: only lower case chars a-z, no special characters
 */
public class Problem5 {

    // O(n) runtime, iterating over each string once
    // O(1) space, charCount array is constant size
    public static boolean oneAway(String str1, String str2) {
        if (str1.length() == str2.length()) {
            return checkReplace(str1, str2);
        } else if (str2.length() + 1 == str1.length()) {
            return checkInsertRemove(str1, str2);
        } else if (str1.length() + 1 == str2.length()) {
            return checkInsertRemove(str2, str1);
        }
        return false;
    }

    private static boolean checkInsertRemove(String longer, String shorter) {
        int[] charCount = buildCharCountArray(longer);
        for (int i = 0; i < shorter.length(); i++) {
            int currentCharCount = --charCount[shorter.charAt(i) - 'a'];
            if (currentCharCount < 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkReplace(String str1, String str2) {
        int[] charCount = buildCharCountArray(str1);
        boolean diffFound = false;
        for (int i = 0; i < str2.length(); i++) {
            int currentCharCount = --charCount[str2.charAt(i) - 'a'];
            if (currentCharCount == -1) {
                if (diffFound) {
                    return false;
                } else {
                    diffFound = true;
                }
            } else if (currentCharCount < -1) {
                return false;
            }
        }
        return true;
    }

    private static int[] buildCharCountArray(String str) {
        int[] charCount = new int[26];
        for (int i = 0; i < str.length(); i++) {
            charCount[str.charAt(i) - 'a']++;
        }
        return charCount;
    }
}
