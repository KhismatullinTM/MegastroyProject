package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.ProductItemPage;
import pages.SearchResultPage;
import testData.TestData;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Epic("Megastroy")
@Feature("Магазин стройматериалов")
@DisplayName("Тесты магазина Megastroy")
public class MegastroyTests extends TestBase {

    TestData testData = new TestData();
    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage();
    SearchResultPage searchResult = new SearchResultPage();
    ProductItemPage productItem = new ProductItemPage();

    @Test
    @DisplayName("Успешная регистрация с валидными данными")
    public void shouldRegistrationSuccessfully (){

        open("/registration?from=/");
        $("input[name='email']").setValue(testData.EMAIL);
        $("input[name='phone']").setValue(testData.PHONE_NUMBER);
        $("input[name='first_name']").setValue(testData.USER_FIRST_NAME);
        $("input[name='surname']").setValue(testData.USER_LAST_NAME);
        $("input[name='password']").setValue("]&O6WjVoKE");
        $("input[name='password_confirmation']").setValue("]&O6WjVoKE");
        executeJavaScript("arguments[0].click();", $("#subscribe"));
        executeJavaScript("arguments[0].click();", $("button[type='submit']"));
        // asserts
        $(".js-requisites-menu").hover();
        $(".requisites-current-name").shouldHave(text(testData.FULL_USER_NAME));
        $(".requisites-current-details").shouldHave(text(testData.EMAIL));
        System.out.println("e-mail: " + testData.EMAIL);
        System.out.println("phone: " + testData.PHONE_NUMBER);
    }

    @Test
    @DisplayName("Успешная авторизация с валидными данными")
    public void shouldLoginSuccessfully (){
        step("Открытие страницы авторизации \"Мегастрой\"", () -> {
        loginPage.openLoginPage();
        });
        step("Заполнение логина и пароиля пользователя", () -> {
            loginPage.setEmail(testData.TIMUR_EMAIL).
                    setPassword(testData.TIMUR_PASSWORD).
                    rememberMeLabelClick().
                    submitButtonClick();
        });
        step("Проверка авторизации пользователя", () -> {
            mainPage.checkFullNameAndEmailInPopupMenu(testData.TIMUR_FULL_NAME, testData.TIMUR_EMAIL);
        });
    }

    @Test
    @DisplayName("Успешный поиск товаров через поисковую строку")
    public void shouldSearchProductSuccessfully (){
        step("Открытие главного экрана ", () -> {
            mainPage.openMainPage();
        });
        step("Поиск товара", () -> {
            mainPage.searchBarCall().
                    searchInput(testData.PRODUCT_ITEMS_NAME);
        });
        step("Проверка отображение товара на странице", () -> {
            searchResult.checkFirstProductContains(testData.PRODUCT_ITEMS_NAME);
        });
    }

    @Test
    @DisplayName("Успешное добавление товара в корзину")
    public void shouldAddedProductInBasketSuccessfully (){
        step("Открытие страницы товара", () -> {
            productItem.openProductItemPage(testData.PRODUCT_NUMBER_ITEM);
        });
        step("Добавление товара в корзину", () -> {
            productItem.checkNameProductItem(testData.PRODUCT_ITEM_NAME).
                    clickBasketButton();
        });
        step("Проверка добавление товара в корзину", () -> {
            productItem.checkAddedProductInBasket(testData.PRODUCT_ITEM_NAME);
        });
    }

    @Test
    @DisplayName("Успешное создание заказа")
    public void shouldCreateOrderSuccessfully() {
        open("/products/411111");
        $("h1[itemprop='name']").shouldHave(text("Изолента ПВХ ОНЛАЙТ 71 690 OIT-B19-20/BL 19мм х20м черная"));
        $("#product-add-to-cart-button .js-basket-add").click();
        $("#product-add-to-cart-button .js-basket-add").shouldNotBe(visible);
        $(".js-basket-header-widget").click();
        $(".basket-list__description-title").shouldHave(text("Изолента ПВХ ОНЛАЙТ 71 690 OIT-B19-20/BL 19мм х20м черная"));
        $("button.js-submit").click();
        $("input[name='first_name']").setValue(testData.USER_FIRST_NAME);
        $("input[name='surname']").setValue(testData.USER_LAST_NAME);
        $("input[name='phone']").setValue(testData.PHONE_NUMBER);
        $("#m_pickup").shouldBe(checked);
        $$(".order-list__item").findBy(text("Адрес гипермаркета")).$(".order-notice").shouldHave(text("Стерлитамак, пр-т Октября, 36"));
        $("label[for='cash_in_market']").click();
        $$("button").findBy(text("Оформить заказ")).click();
        $("h1").shouldHave(matchText("Ваш заказ №\\d+ принят"));
    }

    @Test
    @DisplayName("Смена адреса местонахождения магазина")
    public void shouldApplyPromoCodeSuccessfully (){
        open("/");
        $(".header-city").click();
        $$(".js-city-container").findBy(text("Саранск")).click();
        $("[data-city-id='7'] .city-location[data-market-id='9'] .js-market-link").click();
        $(".header-city__link").shouldHave(text("Саранск, ул. Севастопольская, 5"));
//        $(".js-fancybox-city").click();              // открыть окно
//        $("[data-market-id='6'] .js-market-link").click();  // выбрать
//        $("h1[itemprop='name']").shouldHave(text("Изолента ПВХ ОНЛАЙТ 71 690 OIT-B19-20/BL 19мм х20м черная"));
//        $("#product-add-to-cart-button .js-basket-add").click();
//        $("#product-add-to-cart-button .js-basket-add").shouldNotBe(visible);
//        $(".js-basket-header-widget").click();
//        $(".basket-list__description-title").shouldHave(text("Изолента ПВХ ОНЛАЙТ 71 690 OIT-B19-20/BL 19мм х20м черная"));
//        $("button.js-submit").click();
//        $("input[name='promo_coupon_code']").setValue("ПЕРВЫЙ");
//        $(".promo-list").$(byText("Применить")).click();
    }

    @Test
    @DisplayName("Успешное добавление товара в избранное")
    public void shouldAddedProductInFavoritesSuccessfully (){
        open("/products/290517");
        $("h1[itemprop='name']").shouldHave(text("Печь банная чугунная Везувий Легенда 16 (ДТ-4)"));
        executeJavaScript("arguments[0].click();", $(".products-icon__item.js-favorite"));
        $("a[href='/favorites/']").click();
        $(".js-search-product-link[title*='Печь банная чугунная Везувий Легенда 16']").shouldBe(visible);
    }
}
