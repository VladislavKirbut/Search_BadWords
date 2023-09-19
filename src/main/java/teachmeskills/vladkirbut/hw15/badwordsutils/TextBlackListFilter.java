package teachmeskills.vladkirbut.hw15.badWordsUtils;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextBlackListFilter {

    private static final String MASK = "####";
    private final String[] badWords;
    private final Pattern[] pattern;

    public TextBlackListFilter(String... badWords) {
        this.badWords = Arrays.copyOf(badWords, badWords.length);
        pattern = new Pattern[badWords.length];

        for (int i = 0; i < pattern.length; i++) {
            pattern[i] = Pattern.compile("\\b" + Pattern.quote(badWords[i]) + "\\b",
                    Pattern.UNICODE_CHARACTER_CLASS | Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
        }
    }

    public boolean hasBadWords(String text) {
        if (text == null)
            throw new IllegalArgumentException("Error. Enter text");

        for (int i = 0; i < badWords.length; i++) {
            boolean result;
            Pattern pattern = this.pattern[i];
            Matcher matcher = pattern.matcher(text);
            result = matcher.find();

            if (result) return true;
        }

        return false;
    }

    public int getCountOfBadWords(String text) {
        if (text == null)
            throw new IllegalArgumentException("Error. Enter text");

        int count = 0;
        for (int i = 0; i < badWords.length; i++) {
            Pattern pattern = this.pattern[i];
            Matcher matcher = pattern.matcher(text);
            while (matcher.find())
                count++;
        }
        return count;
    }

    public String replaceBadWords(String text) {
        if (text == null)
            throw new IllegalArgumentException("Error. Enter text");

        String replacedText = text;
        for (int i = 0; i < badWords.length; i++) {
            Pattern pattern = this.pattern[i];
            Matcher matcher = pattern.matcher(replacedText);
            replacedText = matcher.replaceAll(MASK);
        }

        return replacedText;
    }
}
