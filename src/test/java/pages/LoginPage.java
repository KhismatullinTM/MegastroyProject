package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {

    private final SelenideElement emailInput = $("input[name='email']");
    private final SelenideElement passwordInput = $("input[name='password']");
    private final SelenideElement rememberMeLabel = $("label[for='remember_me']");
    private final SelenideElement submitButton =  $("button[type='submit']");

    public LoginPage openLoginPage() {
        open("/login");
        return this;
    }

    public LoginPage setEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    public LoginPage setPassword(String password) {
        passwordInput.setValue(password);
        return this;
    }

    public LoginPage rememberMeLabelClick() {
        rememberMeLabel.click();
        return this;
    }

    public MainPage submitButtonClick() {
        submitButton.click();
        return new MainPage();
   }

}