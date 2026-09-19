package pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.BasketPage;
import pages.ProductItemPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class PopupComponent {
    private final SelenideElement profileMenu = $(".js-requisites-menu");
    private final SelenideElement nameInProfilePopupMenu = $(".requisites-current-name");
    private final SelenideElement emailInProfilePopupMenu = $(".requisites-current-details");
    private final SelenideElement basketMenu = $(".js-basket-header-widget");
    private final SelenideElement productItemNameInBasketMenu = $(".product-item__content-title");


    @Step("Наводим курсор на вкладку \"Профиль\"")
    public PopupComponent hoverProfileTab() {
        profileMenu.hover();
        return this;
    }

    @Step("Проверка отображения ФИО пользователя: \"{fullName}\"")
    public PopupComponent checkProfilePopupMenu(String fullName) {
        nameInProfilePopupMenu.shouldHave(text(fullName));
        return this;
    }

    @Step("Проверка отображения e-mail пользователя: \"{email}\"")
    public PopupComponent checkEmailInProfilePopupMenu(String email) {
        emailInProfilePopupMenu.shouldHave(text(email));
        return this;
    }

    @Step("Наводим курсор на вкладку \"Корзина\"")
    public PopupComponent hoverBasketTab() {
        basketMenu.hover();
        return this;
    }

    @Step("Кликаем на вкладку «Корзина»")
    public BasketPage clickBasketMenu() {
        basketMenu.click();
        return new BasketPage();
    }

    @Step("Проверка отображения товара: \"{productItemName}\" в корзине")
    public PopupComponent checkProductItemNameInBasketMenu(String productItemName) {
        productItemNameInBasketMenu.shouldHave(text(productItemName));
        return this;
    }

 }