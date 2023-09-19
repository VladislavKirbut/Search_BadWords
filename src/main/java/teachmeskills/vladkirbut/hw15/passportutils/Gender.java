package teachmeskills.vladkirbut.hw15.passportUtils;

public enum Gender {
    MALE ("Мужской пол"),
    FEMALE ("Женский пол");

    private final String genderOnRussian;
    Gender(String genderOnRussian) {
        this.genderOnRussian = genderOnRussian;
    }

    public String getGenderOnRussian() {
        return genderOnRussian;
    }
}
