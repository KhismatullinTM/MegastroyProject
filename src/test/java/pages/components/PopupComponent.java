package pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.MainPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class PopupComponent {
    private final SelenideElement profileMenu = $(".js-requisites-menu");
    private final SelenideElement nameInProfilePopupMenu = $(".requisites-current-name");
    private final SelenideElement emailInProfilePopupMenu = $(".requisites-current-details");

    @Step("Наводим курсор на вкладку \"Профиль\"")
    public PopupComponent hoverProfileTab() {
        profileMenu.hover();
        return this;
    }

    @Step("Проверка отображения ФИО пользователя: \"{fullName}\"")
    public PopupComponent checkProfilePopupMenu(String fullName) {
        nameInProfilePopupMenu.shouldHave(text(fullName));
        return this;
    }

    @Step("Проверка отображения e-mail пользователя: \"{email}\"")
    public PopupComponent checkEmailInProfilePopupMenu(String email) {
        emailInProfilePopupMenu.shouldHave(text(email));
        return this;
    }
}
