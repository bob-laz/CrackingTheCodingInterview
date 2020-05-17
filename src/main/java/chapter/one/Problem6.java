package chapter.one;

/*
    Implement a method to perform basic string compression using the counts of repeated characters. For example, the
    string aabcccccaaa would become a2b1c5a3. If the "compressed" string would not become smaller than the original
    string, your method should return the original string. You can assume the string has only uppercase and lowercase
    letters (a-z).
 */
public class Problem6 {

    // O(n) runtime, just iterating over the string once
    // O(n) space, string builder size dependent on input array size (possibly even large, doubles in size whenever it runs out of space)
    public static String compress(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);
            sb.append(current);
            int charCount = 1;
            while (i + 1 < str.length() && str.charAt(i + 1) == current) {
                charCount++;
                i++;
            }
            sb.append(charCount);
        }
        String compressed = sb.toString();
        return compressed.length() < str.length() ? compressed : str;
    }
}
