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
    public String DAY_OF_BIRTH = String.valueOf(fakerRu.number().numberBetween(1, 31));

    public String TIMUR_EMAIL = "avito9195@gmail.com";
    public String TIMUR_PASSWORD = "]&O6WjVoKE";
    public String TIMUR_FULL_NAME = "Тимур Тимур Тимур";
    public String PRODUCT_ITEMS_NAME = "Обои";

    public String FIRST_PRODUCT_NUMBER_ITEM = "290517";
    public String FIRST_PRODUCT_ITEM_NAME = "Печь банная чугунная Везувий Легенда 16 (ДТ-4)";
    public String SECOND_PRODUCT_NUMBER_ITEM = "411111";
    public String SECOND_PRODUCT_ITEM_NAME = "Изолента ПВХ ОНЛАЙТ 71 690 OIT-B19-20/BL 19мм х20м черная";
    public String ADDRESS_SHOP_NAME = "Стерлитамак, пр-т Октября, 36";
}
