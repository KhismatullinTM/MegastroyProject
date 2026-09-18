package pages;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import pages.components.SearchBarComponent;

import static com.codeborne.selenide.Condition.attributeMatching;
import static com.codeborne.selenide.Selenide.$$;

public class SearchResultPage {

    SearchBarComponent searchBar = new SearchBarComponent();

    private final ElementsCollection productItems = $$(".js-search-product-link");

    @Step("Поиск первого товара \"{searchQuery}\" на странице результата поиска")
    public SearchResultPage checkFirstProductContains(String searchQuery) {
        productItems.first().shouldHave(attributeMatching("title", "(?i).*" + searchQuery + ".*"));
        return this;
    }
}