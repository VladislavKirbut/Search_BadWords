package teachmeskills.vladkirbut.hw15;

import teachmeskills.vladkirbut.hw15.passportUtils.BlrPassport;
import teachmeskills.vladkirbut.hw15.passportUtils.Gender;
import teachmeskills.vladkirbut.hw15.badWordsUtils.TextBlackListFilter;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Demonstration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("""
                    Choose:
                    1.Passport data
                    2.TextBlankListFilter
                    0.Exit
                    """);

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.println("Enter passport data: ");

                    System.out.print("Enter surname: ");
                    String surname = scanner.next().trim();

                    System.out.print("Enter name: ");
                    String name = scanner.next().trim();

                    System.out.print("Enter your gender (MALE or FEMALE): ");
                    Gender gender = Gender.valueOf(scanner.next());

                    System.out.println("Enter date of your birth (dd.MM.yyyy format): ");
                    LocalDate dateOfBirth = getDateParameters();

                    System.out.print("Enter number of passport: ");
                    String numberOfPassport = scanner.next();

                    System.out.print("Enter identifier number: ");
                    String identifierNumber = scanner.next();

                    System.out.print("Enter date of issue passport (dd.MM.yyyy format): ");
                    LocalDate dateOfIssue = getDateParameters();

                    System.out.println("Enter validity period of passport (dd.MM.yyyy format): ");
                    LocalDate validityPeriod = getDateParameters();

                    BlrPassport passport = new BlrPassport(surname, name, gender, dateOfBirth, numberOfPassport,
                                           identifierNumber, dateOfIssue, validityPeriod);

                    System.out.println(passport);
                    boolean result = passport.isExpired(LocalDate.now(ZoneId.of("Europe/Minsk")));
                    System.out.println("Is your passport expired? [" + result + "]");
                }
                case 2 -> {
                    System.out.println("Enter bad words (through ','): ");
                    scanner.nextLine();
                    String[] badWords = scanner.nextLine().split("\\s*,\\s*");

                    TextBlackListFilter blackList = new TextBlackListFilter(badWords);

                    System.out.println("1.hasBadWords method.");
                    System.out.println("Enter text: ");
                    String text = scanner.nextLine();
                    boolean result = blackList.hasBadWords(text);
                    System.out.println("Does the text have bad words? - " + result);

                    System.out.println("2.getCountOfBadWords method");
                    System.out.println("Enter text: ");
                    text = scanner.nextLine();
                    int count = blackList.getCountOfBadWords(text);
                    System.out.println("Count of bad words in this text: " + count);

                    System.out.println("3.replaceBadWords method.");
                    System.out.println("Enter text: ");
                    text = scanner.nextLine();
                    text = blackList.replaceBadWords(text);
                    System.out.println("New text: " + text);
                }
                case 0 -> System.exit(0);
                default -> System.out.println("Enter correct number of task");
            }
        }
    }
    public static LocalDate getDateParameters() {
        Scanner scanner = new Scanner(System.in);
        return LocalDate.parse(scanner.nextLine().trim(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }
}
