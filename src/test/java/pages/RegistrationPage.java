package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.PopupComponent;
import pages.components.UserFormComponent;

import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    UserFormComponent userForm = new UserFormComponent();

    private final SelenideElement subscribeLabel = $("#subscribe");
    private final SelenideElement submitButton = $("button[type='submit']");

    @Step ("Открытие страницы авторизации")
    public RegistrationPage openRegistrationPage() {
        open("/registration?from=/");
        return this;
    }


    @Step ("Вводим e-mail клиента")
    public RegistrationPage setEmail (String email){
        userForm.setEmail(email);
        return this;
    }

    @Step ("Вводим номер телефона клиента")
    public RegistrationPage setPhone (String phone){
        userForm.setPhone(phone);
        return this;
    }

    @Step("Вводим имя клиента")
    public RegistrationPage setName (String name) {
        userForm.setName(name);
        return this;
    }

    @Step ("Вводим имя клиента")
    public RegistrationPage setFirstName (String firstName){
        userForm.setFirstName(firstName);
        return this;
    }

    @Step ("Вводим фамилию клиента")
    public RegistrationPage setSurname (String surname){
        userForm.setSurname(surname);
        return this;
    }

    @Step("Вводим пароль")
    public RegistrationPage setRegistrationPassword(String password) {
        userForm.setPassword(password);
        return this;
    }

    @Step("Повторяем пароль")
    public RegistrationPage setPasswordConfirmation(String password) {
        userForm.setPasswordConfirmation(password);
        return this;
    }

    @Step("Кликаем на чек-бокс \"Хочу получать информацию о товарах, услугах и акциях Мегастрой\"")
    public RegistrationPage subscribeLabelClick() {
        executeJavaScript("arguments[0].click();", subscribeLabel);
        return this;
    }

    @Step("Кликаем на кнопку \"Зарегистрироваться\"")
    public MainPage submitRegistrationButtonClick() {
        executeJavaScript("arguments[0].click();", submitButton);
        return new MainPage();
    }
}
