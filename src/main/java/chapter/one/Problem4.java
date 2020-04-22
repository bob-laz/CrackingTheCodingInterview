package chapter.one;

/*
    Given a string, write a function to check if it is a permutation of a palindrome. A palindrome is a word that is the
    same forward and backwards. A permutation is rearrangement of letters. The palindrome does not need to be limited to
    dictionary words.

    Assuming: case insensitive, special characters and white space can be ignored
 */
public class Problem4 {

    // O(n) runtime since we iterate over the string once
    // O(1) space since charCount array is constant length
    public static boolean palindromePermutation(String str) {
        str = str.toLowerCase();
        int[] charCount = new int[Character.getNumericValue('z') - Character.getNumericValue('a')];
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                charCount[str.charAt(i) - 'a']++;
            }
        }
        boolean foundOdd = false;
        for (int value : charCount) {
            if (value % 2 == 1) {
                if (foundOdd) {
                    return false;
                }
                foundOdd = true;
            }
        }
        return true;
    }
}
