package pages;

import io.qameta.allure.Step;
import pages.components.UserFormComponent;

public class OrderPage {

    private UserFormComponent userForm = new UserFormComponent();

    @Step("Вводим имя клиента: \"{firstname}\"")
    public OrderPage setNameClientOrder (String firstName) {
        userForm.setFirstName(firstName);
        return this;
    }

    @Step("Вводим фамилию клиента: \"{surname}\"")
    public OrderPage setSurnameClientOrder (String surname) {
        userForm.setSurname(surname);
        return this;
    }

//    $("#m_pickup").shouldBe(checked);
//    $$(".order-list__item").findBy(text("Адрес гипермаркета")).$(".order-notice").shouldHave(text("Стерлитамак, пр-т Октября, 36"));
//    $("label[for='cash_in_market']").click();
//    $$("button").findBy(text("Оформить заказ")).click();
//    $("h1").shouldHave(matchText("Ваш заказ №\\d+ принят"));
}
