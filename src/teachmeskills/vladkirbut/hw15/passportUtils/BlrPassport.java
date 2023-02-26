package teachmeskills.vladkirbut.hw15.passportUtils;

public class BlrPassport {

    private static final int NUMBER_OF_PASSPORT_LENGTH = 9;
    private static final int IDENTIFIER_NUMBER_LENGTH = 14;
    private final String surname;
    private final String name;
    private final Gender gender;
    private final String dateOfBirth;
    private final String numberOfPassport;
    private final String identifierNumber;
    private String dataOfIssue;
    private String validityPeriod;

    BlrPassport (String surname, String name, Gender gender, String dateOfBirth, String numberOfPassport,
                 String identifierNumber, String dataOfIssue, String validityPeriod) {

        if(!isSurnameAndNameCorrect(surname, name))
            throw new IllegalArgumentException("Enter correct name or surname.");

        if (!isPassportNumberCorrect(numberOfPassport))
            throw new IllegalArgumentException("Number of passport is incorrect.");

        if (!isIdentifierNumberCorrect(identifierNumber))
            throw new IllegalArgumentException("Identifier number is incorrect.");

        this.surname = surname;
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.numberOfPassport = numberOfPassport;
        this.identifierNumber = identifierNumber;
    }

    public static boolean isSurnameAndNameCorrect(String surname, String name) {
        for (int i = 0; i < surname.length(); i++)
            if (!isLatinCharacter(surname.charAt(i)))
                return false;

        for (int i = 0; i < name.length(); i++)
            if (!isLatinCharacter(name.charAt(i)))
                return false;

        return true;
    }

    public static boolean isPassportNumberCorrect(String numberOfPassport) {

        if(numberOfPassport.length() != NUMBER_OF_PASSPORT_LENGTH)
            throw new IllegalArgumentException("The length of passport number is incorrect.");

        return numberOfPassport.matches("(AB|BM|HB|KH|MP|MC|KB|PP|SP|DP)(\\d{7})");
    }

    public static boolean isIdentifierNumberCorrect(String identifierNumber) {
        if (identifierNumber.length() != IDENTIFIER_NUMBER_LENGTH)
            throw new IllegalArgumentException("The length of identifier number is incorrect.");

        return identifierNumber.matches("\\d{7}[ABCKEMH](\\d{3})(PB|BA|BI)\\d");
    }


    public static boolean isLatinCharacter(char letter) {
        return letter >= 'A' && letter <= 'z';
    }
}
