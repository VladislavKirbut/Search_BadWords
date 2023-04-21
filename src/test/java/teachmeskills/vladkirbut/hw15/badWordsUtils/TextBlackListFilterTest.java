package teachmeskills.vladkirbut.hw15.badWordsUtils;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TextBlackListFilterTest {

    private TextBlackListFilter blackListFilter;

    @BeforeEach
    void returnConstructor() {
        blackListFilter = new TextBlackListFilter("drug", "alcohol");
    }

    @Test
    void shouldBeExceptionIfTextNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            blackListFilter.hasBadWords(null);
        });
    }

    @Test
    void shouldBeTrueIfWordExistsInList() {
        assertTrue(blackListFilter.hasBadWords("alcohol"));
    }

    @Test
    void shouldBeFalseIfWordNotExistInList() {
        assertFalse(blackListFilter.hasBadWords("Bear"));
    }

    @Test
    void shouldBeFalseIfSetEmptyString() {
        assertFalse(blackListFilter.hasBadWords(""));
    }

    @Test
    void countShouldThrowExceptionIfTextNull() {
        assertThrows(IllegalArgumentException.class, () -> {
           blackListFilter.getCountOfBadWords(null);
        });
    }

    @Test
    void countOfBadWordsShouldBeOneIfSetBadWords() {
        assertEquals(1, blackListFilter.getCountOfBadWords("drug"));
    }

    @Test
    void countOfBadWordsShouldBeZeroIfSetNotBadWords() {
        assertEquals(0, blackListFilter.getCountOfBadWords("Bear"));
    }

    @Test
    void countOfBadWordsShouldBeZeroIfSetEmptyString() {
        assertEquals(0, blackListFilter.getCountOfBadWords(""));
    }

    @Test
    void replaceBadWordShouldBeExceptionIfSetNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            blackListFilter.replaceBadWords(null);
        });
    }

    @Test
    void shouldBeReplacedIfSetBadWord() {
        assertEquals("####", blackListFilter.replaceBadWords("alcohol"));
    }

    @Test
    void shouldNotBeReplacedIfSetNotBadWord() {
        assertEquals("Bear", blackListFilter.replaceBadWords("Bear"));
    }
}
