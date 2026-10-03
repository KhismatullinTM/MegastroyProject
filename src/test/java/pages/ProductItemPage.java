package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.PopupComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class ProductItemPage {

    private final PopupComponent popup = new PopupComponent();

    private final SelenideElement nameProductInPage= $("h1[itemprop='name']");
    private final SelenideElement basketButton = $("#product-add-to-cart-button .js-basket-add");
    private final SelenideElement favoriteButton = $(".products-icon__item.js-favorite");

    public ProductItemPage openProductItemPage(String productNumberPage){
        open("/products/" + productNumberPage);
        return this;
    }

    public ProductItemPage checkNameProductItem(String productItemName) {
        nameProductInPage.shouldHave(text(productItemName));
        return this;
    }

    public ProductItemPage clickAddInBasket(){
        basketButton.click();
        return this;
    }

    public BasketPage openBasket(){
        return popup.clickBasketMenu();
    }

    public ProductItemPage checkAddedProductInBasket(String productItemName) {
        popup.hoverBasketTab();
        popup.checkProductItemNameInBasketMenu(productItemName);
        return this;
    }

    public ProductItemPage addToFavorites() {
        executeJavaScript("arguments[0].click();", favoriteButton);
        return this;
    }

    public ProductItemPage openFavorites() {
        popup.clickFavoriteMenu();
        return this;
    }
}