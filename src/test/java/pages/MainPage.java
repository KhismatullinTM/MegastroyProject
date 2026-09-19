package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.PopupComponent;
import pages.components.SearchBarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    private final PopupComponent popup = new PopupComponent();
    private final SearchBarComponent searchBar = new SearchBarComponent();

    private final SelenideElement addressShopButton = $(".header-city");
    private final SelenideElement addressShopNameButton = $(".header-city__link");

    @Step("Открываем главный экран \"Megastroy\"")
    public MainPage openMainPage() {
        open("/");
        return this;
    }

    @Step("Проверяем ФИО пользователя: «{fullName}»")
    public MainPage checkFullNameAndEmailInPopupMenu(String fullName, String email) {
        popup.hoverProfileTab();
        popup.checkProfilePopupMenu(fullName);
        popup.checkEmailInProfilePopupMenu(email);
        return this;
    }

    public SearchBarComponent searchBarCall() {
        return searchBar;
    }

    @Step("Нажимаем на кнопку Адреса магазина")
    public ShopSelectionPage clickAddressShopButton() {
        addressShopButton.click();
        return new ShopSelectionPage();
    }

    @Step("Проверяем, что адрес магазина изменен на : \"{changedAddressShop}\" на кнопку Адреса магазина")
    public MainPage checkNewAddressShop(String changedAddressShop) {
        addressShopNameButton.shouldHave(text(changedAddressShop));
        return this;
    }
}
