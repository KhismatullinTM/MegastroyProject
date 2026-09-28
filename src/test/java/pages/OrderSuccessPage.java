package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Selenide.$;

public class OrderSuccessPage {

    private final SelenideElement successTitle = $("h1");

    @Step("Проверяем, что заказ принят")
    public OrderSuccessPage checkOrderAccepted() {
        successTitle.should(matchText("Ваш заказ №\\d+ принят"), Duration.ofSeconds(15));;
        return this;
    }
}
