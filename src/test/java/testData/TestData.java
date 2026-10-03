package testData;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {

    private static final Faker FAKER_RU = new Faker (new Locale("ru"));
    private static final Faker FAKER_ENG = new Faker ();

    public String userFirstName = FAKER_RU.name().firstName();
    public String userLastName = FAKER_RU.name().lastName();
    public String userFullName = userLastName + " " + userFirstName;
    public String userEmail = FAKER_ENG.internet().emailAddress();
    public String userPhoneNumber = FAKER_RU.phoneNumber().phoneNumber().replaceFirst("^[87]", "+7");
    public static final String EXISTING_USER_EMAIL = "erich.witting@yahoo.com";
    public static final String EXISTING_USER_PASSWORD = "]&O6WjVoKE";
    public static final String EXISTING_USER_FULL_NAME = "Горшкова Ольга";
    public static final String PRODUCT_ITEMS_NAME = "Обои";

    public static final String FIRST_PRODUCT_NUMBER_ITEM = "290517";
    public static final String FIRST_PRODUCT_ITEM_NAME = "Печь банная чугунная Везувий Легенда 16 (ДТ-4)";
    public static final String SECOND_PRODUCT_NUMBER_ITEM = "411111";
    public static final String SECOND_PRODUCT_ITEM_NAME = "Изолента ПВХ ОНЛАЙТ 71 690 OIT-B19-20/BL 19мм х20м черная";
    public static final String ADDRESS_SHOP_NAME = "Стерлитамак, пр-т Октября, 36";
    public static final String CHANGED_CITY_NAME = "Саранск";
    public static final String CHANGED_ADDRESS_SHOP_NAME = "Саранск, ул. Севастопольская, 5";

}
