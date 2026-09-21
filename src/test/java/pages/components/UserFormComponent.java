package pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class UserFormComponent {
    private final SelenideElement nameInput = $("input[name='name']");
    private final SelenideElement emailInput = $("input[name='email']");
    private final SelenideElement surnameInput = $("input[name='surname']");
    private final SelenideElement firstNameInput = $("input[name='first_name']");
    private final SelenideElement phoneInput = $("input[name='phone']");
    private final SelenideElement passwordInput = $("input[name='password']");
    private final SelenideElement passwordConfirmationInput = $("input[name='password_confirmation']");



    @Step("Вводим имя пользователя: {name}")
    public UserFormComponent setName (String name) {
        nameInput.setValue(name);
                return this;
    }

    @Step ("Вводим e-mail: {email}")
    public UserFormComponent setEmail (String email){
        emailInput.setValue(email);
        return this;
    }

    @Step ("Вводим имя клиента: {firstName}")
    public UserFormComponent setFirstName (String firstName){
        firstNameInput.setValue(firstName);
        return this;
    }

    @Step ("Вводим фамилию клиента: {surname}")
    public UserFormComponent setSurname (String surname){
        surnameInput.setValue(surname);
        return this;
    }

    @Step ("Вводим номер телефона клиента: {phone}")
    public UserFormComponent setPhone (String phone){
        phoneInput.setValue(phone);
        return this;
    }

    @Step("Вводим пароль")
    public UserFormComponent setPassword(String password) {
        passwordInput.setValue(password);
        return this;
    }

    @Step("Вводим пароль")
    public UserFormComponent setPasswordConfirmation(String password) {
        passwordConfirmationInput.setValue(password);
        return this;
    }

}



