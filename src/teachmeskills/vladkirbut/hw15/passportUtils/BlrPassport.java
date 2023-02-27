package teachmeskills.vladkirbut.hw15.passportUtils;

import java.time.LocalDate;

public class BlrPassport {

    private static final int NUMBER_OF_PASSPORT_LENGTH = 9;
    private static final int IDENTIFIER_NUMBER_LENGTH = 14;
    private final String surname;
    private final String name;
    private final Gender gender;
    private final LocalDate dateOfBirth;
    private final String numberOfPassport;
    private final String identifierNumber;
    private final LocalDate dateOfIssue;
    private final LocalDate validityPeriod;

    BlrPassport (String surname, String name, Gender gender, LocalDate dateOfBirth, String numberOfPassport,
                String identifierNumber, LocalDate dateOfIssue, LocalDate validityPeriod) {

        passportValidationCheck(surname, name, numberOfPassport, identifierNumber,dateOfIssue,validityPeriod);

        this.surname = surname;
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.numberOfPassport = numberOfPassport;
        this.identifierNumber = identifierNumber;
        this.dateOfIssue = dateOfIssue;
        this.validityPeriod = validityPeriod;
    }

    public boolean isSurnameAndNameCorrect(String surname, String name) {
        return surname.trim().matches("[A-z]+") && name.trim().matches("[A-z]+");
    }

    public boolean isPassportNumberCorrect(String numberOfPassport) {

        if (numberOfPassport.length() != NUMBER_OF_PASSPORT_LENGTH)
            throw new IllegalArgumentException("The length of passport number is incorrect.");

        return numberOfPassport.matches("(AB|BM|HB|KH|MP|MC|KB|PP|SP|DP)(\\d{7})");
    }

    public boolean isIdentifierNumberCorrect(String identifierNumber) {
        if (identifierNumber.length() != IDENTIFIER_NUMBER_LENGTH)
            throw new IllegalArgumentException("The length of identifier number is incorrect.");

        return identifierNumber.matches("\\d{7}[ABCKEMH](\\d{3})(PB|BA|BI)\\d");
    }

    public boolean isIssueDateLessThanValidityPeriod(LocalDate dateOfIssue, LocalDate validityPeriod) {
        return dateOfIssue.isBefore(validityPeriod);
    }

    public void passportValidationCheck(String surname, String name, String numberOfPassport, String identifierNumber,
                                        LocalDate dateOfIssue, LocalDate validityPeriod) {
        if (!isSurnameAndNameCorrect(surname, name))
            throw new IllegalArgumentException("Enter correct name or surname.");

        if (!isPassportNumberCorrect(numberOfPassport))
            throw new IllegalArgumentException("Number of passport is incorrect.");

        if (!isIdentifierNumberCorrect(identifierNumber))
            throw new IllegalArgumentException("Identifier number is incorrect.");

        if (!isIssueDateLessThanValidityPeriod(dateOfIssue, validityPeriod))
            throw new IllegalArgumentException("Enter correct date of issue or validity period.");
    }

    public String toString() {
        return "Surname: " + surname + "\nName: " + name + "\nGender: " + gender + "\nDateOfBirth: " + dateOfBirth +
                "\nNumber of passport: " + numberOfPassport + "\nIdentifier number: " + identifierNumber +
                "\nDate of issue: " + dateOfIssue + "\nValidity period: " + validityPeriod;
    }
}