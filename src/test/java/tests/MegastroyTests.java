package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.*;
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
    OrderSuccessPage orderSuccess = new OrderSuccessPage();
    FavoritePage favoritePage = new FavoritePage();
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    @DisplayName("Успешная регистрация с валидными данными")
    public void shouldRegistrationSuccessfully (){

            step("Открытие страницы регистрации \"Мегастрой\"", () -> {
        registrationPage.openRegistrationPage();
    });
    step("Заполнение данных клиента", () -> {
        registrationPage.setEmail(testData.EMAIL).
                setPhone(testData.PHONE_NUMBER).
                setFirstName(testData.USER_FIRST_NAME).
                setSurname(testData.USER_LAST_NAME).
                setRegistrationPassword(testData.TIMUR_PASSWORD).
                setPasswordConfirmation(testData.TIMUR_PASSWORD).
                subscribeLabelClick().
                submitRegistrationButtonClick();
    });
    step("Проверка регистрации пользователя", () -> {
        mainPage.checkFullNameAndEmailInPopupMenu(testData.FULL_USER_NAME, testData.EMAIL);
    });
}

    @Test
    @DisplayName("Успешная авторизация с валидными данными")
    public void shouldLoginSuccessfully (){
        step("Открытие страницы авторизации \"Мегастрой\"", () -> {
        loginPage.openLoginPage();
        });
        step("Заполнение логина и пароля пользователя", () -> {
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
            productItem.openProductItemPage(testData.FIRST_PRODUCT_NUMBER_ITEM);
        });
        step("Добавление товара в корзину", () -> {
            productItem.checkNameProductItem(testData.FIRST_PRODUCT_ITEM_NAME).
                    clickAddInBasket();
        });
        step("Проверка добавление товара в корзину", () -> {
            productItem.checkAddedProductInBasket(testData.FIRST_PRODUCT_ITEM_NAME);
        });
    }

    @Test
    @DisplayName("Успешное создание заказа")
    public void shouldCreateOrderSuccessfully() {
        step("Открытие страницы товара", () -> {
            productItem.openProductItemPage(testData.SECOND_PRODUCT_NUMBER_ITEM);
        });
        step("Выполняем заказ товара", () -> {
            productItem.checkNameProductItem(testData.SECOND_PRODUCT_ITEM_NAME).
                    clickAddInBasket().
                    openBasket().
                    checkAddedBasketItem(testData.SECOND_PRODUCT_ITEM_NAME).
                    clickSubmitButton().
                    setFullDetailsOrder(testData.USER_FIRST_NAME, testData.USER_LAST_NAME, testData.PHONE_NUMBER).
                    checkPickupSelected().
                    checkAddressShop(testData.ADDRESS_SHOP_NAME).
                    cashPaymentLabelClick().
                    submitOrderButtonClick();
        });
        step("Проверка создания заказа", () -> {
            orderSuccess.checkOrderAccepted();
        });
}

    @Test
    @DisplayName("Смена адреса местонахождения магазина")
    public void shouldApplyPromoCodeSuccessfully (){
        step("Открытие главного экрана ", () -> {
            mainPage.openMainPage();
        });
        step("Смена адреса магазина", () -> {
            mainPage.clickAddressShopButton().
                    selectCity(testData.CHANGED_CITY_NAME).
                    selectShop();
        });
        step("Проверка смены магазина", () -> {
            mainPage.checkNewAddressShop(testData.CHANGED_ADDRESS_SHOP_NAME);
        });
    }

    @Test
    @DisplayName("Успешное добавление товара в избранное")
    public void shouldAddedProductInFavoritesSuccessfully (){
        step("Открытие страницы товара", () -> {
            productItem.openProductItemPage(testData.FIRST_PRODUCT_NUMBER_ITEM);
        });
        step("Добавление товара в избранное", () -> {
            productItem.checkNameProductItem(testData.FIRST_PRODUCT_ITEM_NAME).
                    addToFavorites().
                    openFavorites();
        });
        step("Проверка добавления товара в избранное", () -> {
            favoritePage.chekProductNameInFavorite(testData.FIRST_PRODUCT_ITEM_NAME);
        });
    }
}
