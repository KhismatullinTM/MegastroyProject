package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BasketPage {

    private final ElementsCollection basketItems =  $$(".basket-list__description-title");
    private final SelenideElement submitButton = $("button.js-submit");

    @Step("Проведка отображения товара \"{productNumberPage}\" в списке корзины")
    public BasketPage checkAddedBasketItem(String productNumberPage) {
        basketItems.findBy(text(productNumberPage)).shouldBe(visible);
        return this;
    }

    @Step("Кликаем на кнопку \"Перейти к оформлению\"")
    public OrderPage clickSubmitButton(){
        submitButton.click();
        return new OrderPage();
    }
}
