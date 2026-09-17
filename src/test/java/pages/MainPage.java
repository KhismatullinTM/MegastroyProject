package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    SelenideElement profilePopup = $(".js-requisites-menu");
    SelenideElement profilePopupMenu = $(".requisites-current-name");

   @Step("Наводим курсор на вкладку \"Профиль\"")
    public MainPage hoverProfileTab (){
        profilePopup.hover();
        return this;
    }

@Step("Проверка отображения фамилии \"{lastName}\", имени \"{firstName}\", отчества \"{surname}\" пользователя")
    public MainPage checkProfilePopupMenu (String fullName){
        profilePopupMenu.shouldHave(text(fullName));
        return this;
    }
}
