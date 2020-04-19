package chapter.one;

public class Urlify {

    public static char[] urlifyImpl(char[] rawUrl, int trueLength) {
        int index = rawUrl.length - 1;
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
