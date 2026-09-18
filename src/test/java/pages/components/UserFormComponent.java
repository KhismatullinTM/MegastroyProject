package pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class UserFormComponent {
    private final SelenideElement nameInput = $("input[name='name']");
    private final SelenideElement emailInput = $("input[name='email']");

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


//    $(".js-requisites-menu").hover();
//    $(".requisites-current-name").shouldHave(text("Тимур Тимур Тимур"));

}



