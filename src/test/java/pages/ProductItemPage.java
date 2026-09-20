package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.PopupComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class ProductItemPage {

    private final PopupComponent popup = new PopupComponent();

    private final SelenideElement nameProductInPage= $("h1[itemprop='name']");
    private final SelenideElement basketButton = $("#product-add-to-cart-button .js-basket-add");
    private final SelenideElement favoriteButton = $(".products-icon__item.js-favorite");


    @Step("Открываем страницу товара \"{productNumberPage}\"")
    public ProductItemPage openProductItemPage(String productNumberPage){
        open("/products/" + productNumberPage);
        return this;
    }

    @Step("Проверяем, что открывшаяся страница принадлежит товару: \"{productItemName}\"")
    public ProductItemPage checkNameProductItem(String productItemName) {
        nameProductInPage.shouldHave(text(productItemName));
        return this;
    }

    @Step("Кликаем на кнопку \"В корзину\"")
    public ProductItemPage clickAddInBasket(){
        basketButton.click();
        sleep(4000);
        return this;
    }

    @Step("Кликаем на вкладку \"Корзина\"")
    public BasketPage openBasket(){
        return popup.clickBasketMenu();
    }

    @Step("Проверяем, что товар \"{productItemName}\" добавился в козину")
    public ProductItemPage checkAddedProductInBasket(String productItemName) {
        popup.hoverBasketTab();
        popup.checkProductItemNameInBasketMenu(productItemName);
        return this;
    }

    @Step("Кликаем на кнопку \"В избранное\"")
    public ProductItemPage addToFavorites() {
        executeJavaScript("arguments[0].click();", favoriteButton);
        sleep(4000);
        return this;
    }

    @Step("Переход на страницу \"Избранное\"")
    public ProductItemPage openFavorites() {
        popup.clickFavoriteMenu();
        sleep(4000);
        return this;
    }
}