package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Selenide.$;

public class OrderSuccessPage {

    private final SelenideElement successTitle = $("h1");

    @Step("Проверяем, что заказ принят")
    public OrderSuccessPage checkOrderAccepted() {
        successTitle.shouldHave(matchText("Ваш заказ №\\d+ принят"));
        return this;
    }
}
