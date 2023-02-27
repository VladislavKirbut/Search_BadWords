package teachmeskills.vladkirbut.hw15.task2;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextBlackListFilter {

    private final String[] badWords;

    public TextBlackListFilter(String... badWords) {
        this.badWords = Arrays.copyOf(badWords, badWords.length);
    }

    public boolean hasBadWords(String text) {
        if (text == null)
            throw new IllegalArgumentException("Error. Enter text");

        for (int i = 0; i < badWords.length; i++) {
            boolean result;
            Pattern pattern = Pattern.compile("(^|\\b)" + badWords[i] + "\\b",
                             Pattern.UNICODE_CHARACTER_CLASS | Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
            Matcher matcher = pattern.matcher(text);
            result = matcher.find();

            if (result) return true;
        }

        return false;
    }
}
