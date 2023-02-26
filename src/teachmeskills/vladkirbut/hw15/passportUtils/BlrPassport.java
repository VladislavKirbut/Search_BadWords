package teachmeskills.vladkirbut.hw15.passportUtils;

public class BlrPassport {
    private String surname;
    private String name;
    private Gender gender;
    private String dateOfBirth;
    private String numberOfPassport;
    private String identifierNumber;
    private String dataOfIssue;
    private String validityPeriod;

    BlrPassport (String surname, String name, Gender gender, String dateOfBirth, String numberOfPassport,
                 String identifierNumber, String dataOfIssue, String validityPeriod) {

        if(!isSurnameAndNameCorrect(surname, name))
            throw new IllegalArgumentException("Enter correct name or surname.");

        this.surname = surname;
        this.name = name;
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

    public static boolean isLatinCharacter(char letter) {
        return letter >= 'A' && letter <= 'z';
    }
}
