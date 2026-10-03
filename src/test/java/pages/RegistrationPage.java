package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.UserFormComponent;

import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    UserFormComponent userForm = new UserFormComponent();

    private final SelenideElement subscribeLabel = $("#subscribe");
    private final SelenideElement submitButton = $("button[type='submit']");

    public RegistrationPage openRegistrationPage() {
        open("/registration?from=/");
        return this;
    }

    public RegistrationPage setEmail (String email){
        userForm.setEmail(email);
        return this;
    }

    public RegistrationPage setPhone (String phone){
        userForm.setPhone(phone);
        return this;
    }

    public RegistrationPage setFirstName (String firstName){
        userForm.setFirstName(firstName);
        return this;
    }

    public RegistrationPage setSurname (String surname){
        userForm.setSurname(surname);
        return this;
    }

    public RegistrationPage setRegistrationPassword(String password) {
        userForm.setPassword(password);
        return this;
    }

    public RegistrationPage setPasswordConfirmation(String password) {
        userForm.setPasswordConfirmation(password);
        return this;
    }

    public RegistrationPage subscribeLabelClick() {
        executeJavaScript("arguments[0].click();", subscribeLabel);
        return this;
    }

    public MainPage submitRegistrationButtonClick() {
        executeJavaScript("arguments[0].click();", submitButton);
        return new MainPage();
    }
}
