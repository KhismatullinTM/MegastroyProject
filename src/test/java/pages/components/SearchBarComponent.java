package pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.SearchResultPage;

import static com.codeborne.selenide.Selenide.$;

public class SearchBarComponent {

    private final SelenideElement searchInput = $("input[name='q']");

    @Step("Выполняем поиск \"{string}\" через поисковую строку")
    public SearchResultPage searchInput(String searchQuery) {
        searchInput.setValue(searchQuery).pressEnter();
        return new SearchResultPage();
    }
}
