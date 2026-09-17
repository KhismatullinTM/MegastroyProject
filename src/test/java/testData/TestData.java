package testData;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {

    private final Faker fakerRu = new Faker (new Locale("ru"));
    private final Faker fakerEng = new Faker ();

    public String USER_FIRST_NAME = fakerRu.name().firstName();
    public String USER_LAST_NAME = fakerRu.name().lastName();
    public String FULL_USER_NAME = USER_LAST_NAME + " " + USER_FIRST_NAME;
    public String EMAIL = fakerEng.internet().emailAddress();
    public String PHONE_NUMBER = fakerRu.phoneNumber().phoneNumber().replaceFirst("^[87]", "+7");
    public String DAY_OF_BIRTH = String.valueOf(fakerRu.number().numberBetween(1, 28));
}
