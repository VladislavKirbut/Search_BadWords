package teachmeskills.vladkirbut.hw15.passportUtils;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import teachmeskills.vladkirbut.hw15.passportUtils.BlrPassport;
import teachmeskills.vladkirbut.hw15.passportUtils.Gender;

import java.time.LocalDate;

public class BlrPassportTest {

    private BlrPassport passportData;
    @BeforeEach
    void getConstructor() {
        passportData = new BlrPassport("Ivan", "Ivanov", Gender.MALE,
                LocalDate.of(2000, 1,2), "MP2417879",
                "3260483A011PB6", LocalDate.of(2010, 5, 7),
                LocalDate.of(2014, 5,7));
    }

    @Test
    void shouldBeTrueIfNameAndSurnameCorrect() {
        assertTrue(passportData.isSurnameAndNameCorrect("Ivan", "Ivanov"));
    }

    @Test
    void shouldBeFalseIfSetEmptyNameOrSurname() {
        assertFalse(passportData.isSurnameAndNameCorrect("", ""));
    }

    @Test
    void shouldBeFalseIfNameAndSurnameNotMatchPattern() {
        assertFalse(passportData.isSurnameAndNameCorrect("123", "03Adfg"));
    }

    @Test
    void shouldBeExceptionIfNumberPassportLengthIncorrect() {
        assertThrows(IllegalArgumentException.class, () -> {
            passportData.isPassportNumberCorrect("MP464726574859574");
        });
    }

    @Test
    void shouldBeFalseIfNumberOfPassportNotMatchPattern() {
        assertFalse(passportData.isPassportNumberCorrect("MP23e4N4J"));
    }

    @Test
    void shouldBeTrueIfNumberOfPassportMatchPattern() {
        assertTrue(passportData.isPassportNumberCorrect("MP2345678"));
    }

    @Test
    void shouldBeExceptionIfIdentifierNumberLengthIncorrect() {
        assertThrows(IllegalArgumentException.class, () -> {
            passportData.isIdentifierNumberCorrect("463849N384752847363748372685947463");
        });
    }

    @Test
    void shouldBeFalseIfIdentifierNumberNotMatchPattern() {
        assertFalse(passportData.isIdentifierNumberCorrect("Ma456378N984N3"));
    }

    @Test
    void shouldBeTrueIfIdentifierNumberMatchPattern() {
        assertTrue(passportData.isIdentifierNumberCorrect("3260483A011PB6"));
    }

    @Test
    void shouldBeExceptionIfIssueDateOrValidityDateNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            passportData.isIssueDateLessThanValidityPeriod(null, null);
        });
    }

    @Test
    void shouldBeTrueIfIssueDateLessThanValidityDate() {
        assertTrue(passportData.isIssueDateLessThanValidityPeriod(LocalDate.of(2022,1,6),
                LocalDate.of(2023,1,6)));
    }

    @Test
    void shouldBeFalseIfIssueDateMoreThanValidityDate() {
        assertFalse(passportData.isIssueDateLessThanValidityPeriod(LocalDate.of(2023,2,4),
                LocalDate.of(2022,2,4)));
    }

    @Test
    void shouldBeFalseIfIssueDateIsEqualToValidityDate() {
        assertFalse(passportData.isIssueDateLessThanValidityPeriod(LocalDate.of(2022,5,7),
                LocalDate.of(2022,5,7)));
    }

    @Test
    void shouldBeExceptionIfValidityPeriodIsExpired() {
        assertThrows(IllegalArgumentException.class, () -> {
            passportData.isExpired(null);
        });
    }

    @Test
    void shouldBeTrueIfValidityPeriodNotExpired() {
        assertTrue(passportData.isExpired(LocalDate.now()));
    }

    @Test
    void shouldBeFalseIfValidityPeriodIsExpired() {
        assertFalse(passportData.isExpired(LocalDate.of(2012,4,7)));
    }
}