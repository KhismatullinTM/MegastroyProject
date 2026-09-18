package testData;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {

    private final Faker fakerRu = new Faker (new Locale("ru"));
    private final Faker fakerEng = new Faker ();

    public String cityShopName = "sterlitamak";
    public String USER_FIRST_NAME = fakerRu.name().firstName();
    public String USER_LAST_NAME = fakerRu.name().lastName();
    public String FULL_USER_NAME = USER_LAST_NAME + " " + USER_FIRST_NAME;
    public String EMAIL = fakerEng.internet().emailAddress();
    public String PHONE_NUMBER = fakerRu.phoneNumber().phoneNumber().replaceFirst("^[87]", "+7");
    public String DAY_OF_BIRTH = String.valueOf(fakerRu.number().numberBetween(1, 31));

    public String TIMUR_EMAIL = "avito9195@gmail.com";
    public String TIMUR_PASSWORD = "]&O6WjVoKE";
    public String TIMUR_FULL_NAME = "Тимур Тимур Тимур";
    public String PRODUCT_ITEMS_NAME = "Обои";

    public String PRODUCT_NUMBER_ITEM = "290517";
    public String PRODUCT_ITEM_NAME = "Печь банная чугунная Везувий Легенда 16 (ДТ-4)";
}
