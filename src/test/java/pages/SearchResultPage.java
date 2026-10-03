package pages;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Condition.attributeMatching;
import static com.codeborne.selenide.Selenide.$$;

public class SearchResultPage {

    private final ElementsCollection productItems = $$(".js-search-product-link");

    public SearchResultPage checkFirstProductContains(String searchQuery) {
        productItems.first().shouldHave(attributeMatching("title", "(?i).*" + searchQuery + ".*"));
        return this;
    }
}