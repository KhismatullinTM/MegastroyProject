package pages;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Selenide.$;

public class OrderSuccessPage {

    private final SelenideElement successTitle = $("h1");

    public OrderSuccessPage checkOrderAccepted() {
        successTitle.should(matchText("Ваш заказ №\\d+ принят"), Duration.ofSeconds(15));
        return this;
    }
}
