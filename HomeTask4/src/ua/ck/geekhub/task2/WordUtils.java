package ua.ck.geekhub.task2;

public class WordUtils {
    private static final int MAX_WORD_LENGTH = 10;

    static String getAbbr(String word) {
        if (word.length() >= MAX_WORD_LENGTH) {
            return "" + word.charAt(0) + (word.length() - 2) + word.charAt(word.length() - 1);
        } else {
            return word;
        }
    }
}
