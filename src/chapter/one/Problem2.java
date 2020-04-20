package chapter.one;

/*
    Given two strings, write a method to decide if one is a permutation of the other.

    Assuming charset is ASCII, case sensitive and whitespace matters
 */
public class Problem2 {

    // O(n) runtime since we must loop over both strings once, n and not n*m because both strings are same length
    // O(1) space since storage used is constant
    public static boolean checkPermutation(String str1, String str2) {
        if (str1.length() != str2.length()) { // permutations must be same length
            return false;
        }
        int[] charAry = new int[128]; // assuming ASCII
        for (int i = 0; i < str1.length(); i++) { // increment counts of each letter that appear in str1
            charAry[str1.charAt(i)]++;
        }
        for (int i = 0; i < str2.length(); i++) { // decrement counts of each letter that appear in str2
            charAry[str2.charAt(i)]--;
            // if decremented below 0 means a letter appeared in str2 that was not in str1 or appeared more times in
            // str2 than in str1, meaning not permutations since strings are same length
            if (charAry[str2.charAt(i)] < 0) {
                return false;
            }
        }
        return true;
    }
}
