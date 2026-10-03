package pages;

import com.codeborne.selenide.SelenideElement;

import io.qameta.allure.Step;
import pages.components.UserFormComponent;

import static com.codeborne.selenide.Condition.checked;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class OrderPage {

    private final UserFormComponent userForm = new UserFormComponent();

    private final SelenideElement pickupRadio = $("#m_pickup");
    private final SelenideElement addressBlock = $$(".order-list__item").findBy(text("Адрес гипермаркета"));
    private final SelenideElement addressText = addressBlock.$(".order-notice");
    private final SelenideElement cashPaymentLabel = $("label[for='cash_in_market']");
    private final SelenideElement submitOrderButton = $$("button").findBy(text("Оформить заказ"));

    @Step("Вводим данные клиента для заказа")
    public OrderPage setFullDetailsOrder (String firstName, String surname, String phone) {
        userForm.setFirstName(firstName);
        userForm.setSurname(surname);
        userForm.setPhone(phone);
        return this;
    }

    public OrderPage checkPickupSelected () {
        pickupRadio.shouldBe(checked);
        return this;
    }

    public OrderPage checkAddressShop (String addressShop) {
        addressText.shouldHave(text(addressShop));
        return this;
    }

    public OrderPage cashPaymentLabelClick () {
        cashPaymentLabel.click();
        return this;
    }

    public OrderSuccessPage submitOrderButtonClick () {
        submitOrderButton.click();
        return new OrderSuccessPage();
    }
}
