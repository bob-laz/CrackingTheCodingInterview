package chapter.one;

/*
    Write a method to replace all spaces in a string with '%20'. You may assume that the string has sufficient space at
    the end to hold the additional characters and that you are given the "true" length of the string. In Java, String =
    char array.

    Assuming leading and trailing spaces matter, only literal space " " char counts as space, no tab/newline
 */
public class Problem3 {

    // O(n) runtime since we must iterate over char array once
    // O(1) space since we manipulate the char array in place
    public static char[] Urlify(char[] rawUrl, int trueLength) {
        // rawUrl is padded with extra spaces to account for %20s being added, can use this length without counting spaces
        int index = rawUrl.length - 1;
        // iterate over string backwards, replacing spaces with %20 and manipulating the char array in place
        for(int i = trueLength - 1; i >= 0; i--) {
            if (rawUrl[i] == ' ') {
                rawUrl[index--] = '0';
                rawUrl[index--] = '2';
                rawUrl[index--] = '%';
            } else {
                rawUrl[index--] = rawUrl[i];
            }
        }
        return rawUrl;
    }
}
