package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {

    SelenideElement nameInput = $("input[name='name']");
    SelenideElement emailInput = $("input[name='email']");
    SelenideElement passwordInput = $("input[name='password']");
    SelenideElement rememberMeLabel = $("label[for='remember_me']");
    SelenideElement submitButton =  $("button[type='submit']");



    @Step("Вводим имя пользователя: {name}")
    public LoginPage setName (String name) {
        nameInput.setValue(name);
        return this;
    }

    @Step ("Вводим e-mail: {email}")
    public LoginPage setEmail (String email){
        emailInput.setValue(email);
        return this;
    }
    @Step ("Открытие страницы авторизации")
    public LoginPage openLoginPage () {
        open("/login");
        return this;
    }

    @Step("Вводим пароль")
    public LoginPage setPassword (String password){
        passwordInput.setValue(password);
        return this;
    }

    @Step("Кликаем на чек-бокс \"Запомнить меня\"")
    public LoginPage rememberMeLabelClick (){
        rememberMeLabel.click();
        return this;
    }

   @Step("Кликаем на кнопку \"Войти\"")
    public MainPage submitButtonClick (){
        submitButton.click();
        return new MainPage();
   }

}