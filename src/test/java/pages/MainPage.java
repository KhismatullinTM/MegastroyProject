package pages;

import io.qameta.allure.Step;
import pages.components.PopupComponent;
import pages.components.SearchBarComponent;

import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    private final PopupComponent popup = new PopupComponent();
    private final SearchBarComponent searchBar = new SearchBarComponent();

    @Step("Открываем главный экран \"Megastroy\"")
    public MainPage openMainPage() {
        open("/");
        return this;
    }

    @Step("Проверяем ФИО пользователя: «{fullName}»")
    public MainPage checkFullNameAndEmailInPopupMenu(String fullName, String email) {
        popup.hoverProfileTab();
        popup.checkProfilePopupMenu(fullName);
        popup.checkEmailInProfilePopupMenu(email);
        return this;
    }

    public SearchBarComponent searchBarCall() {
        return searchBar;
    }

}
