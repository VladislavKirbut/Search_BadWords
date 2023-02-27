package teachmeskills.vladkirbut.hw15.passportUtils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Scanner;

public class PassportData {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter passport data: ");

        System.out.print("Enter name:");
        String name = scanner.next();

        System.out.print("Enter surname: ");
        String surname = scanner.next();

        System.out.print("Enter your gender (MALE or FEMALE): ");
        Gender gender = Gender.valueOf(scanner.next());

        System.out.println("Enter date of your birth: ");
        LocalDate dateOfBirth = getDateParameters();

        System.out.print("Enter number of passport: ");
        String numberOfPassport = scanner.next();

        System.out.print("Enter identifier number: ");
        String identifierNumber = scanner.next();

        System.out.print("Enter date of issue passport: ");
        LocalDate dateOfIssue = getDateParameters();

        System.out.println("Enter validity period of passport: ");
        LocalDate validityPeriod = getDateParameters();

        BlrPassport passport = new BlrPassport (surname, name, gender,dateOfBirth,numberOfPassport,identifierNumber,
                                               dateOfIssue, validityPeriod);

        System.out.println(passport);
        boolean result = passport.isExpired(LocalDate.now(ZoneId.of("Europe/Minsk")));
        System.out.println("Is your passport expired? [" + result + "]");
    }

    public static LocalDate getDateParameters() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter day (1-31): ");
        int day = scanner.nextInt();
        System.out.print("Enter month (1-12): ");
        int month = scanner.nextInt();
        System.out.print("Enter year: ");
        int year = scanner.nextInt();

        return LocalDate.of(year, month, day);
    }
}
