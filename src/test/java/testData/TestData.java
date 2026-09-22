package testData;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {

    private final Faker fakerRu = new Faker (new Locale("ru"));
    private final Faker fakerEng = new Faker ();

    public String USER_FIRST_NAME = fakerRu.name().firstName();
    public String USER_LAST_NAME = fakerRu.name().lastName();
    public String USER_FULL_NAME = USER_LAST_NAME + " " + USER_FIRST_NAME;
    public String USER_EMAIL = fakerEng.internet().emailAddress();
    public String USER_PHONE_NUMBER = fakerRu.phoneNumber().phoneNumber().replaceFirst("^[87]", "+7");

    public String EXISTING_USER_EMAIL = "erich.witting@yahoo.com";
    public String EXISTING_USER_PASSWORD = "]&O6WjVoKE";
    public String EXISTING_USER_FULL_NAME = "Горшкова Ольга";
    public String PRODUCT_ITEMS_NAME = "Обои";

    public String FIRST_PRODUCT_NUMBER_ITEM = "290517";
    public String FIRST_PRODUCT_ITEM_NAME = "Печь банная чугунная Везувий Легенда 16 (ДТ-4)";
    public String SECOND_PRODUCT_NUMBER_ITEM = "411111";
    public String SECOND_PRODUCT_ITEM_NAME = "Изолента ПВХ ОНЛАЙТ 71 690 OIT-B19-20/BL 19мм х20м черная";
    public String ADDRESS_SHOP_NAME = "Стерлитамак, пр-т Октября, 36";
    public String CHANGED_CITY_NAME = "Саранск";
    public String CHANGED_ADDRESS_SHOP_NAME = "Саранск, ул. Севастопольская, 5";

}
