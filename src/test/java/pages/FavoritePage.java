package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class FavoritePage {

    private SelenideElement productLink(String productName) {
        return $(".js-search-product-link[title*='" + productName + "']");
    }

    public FavoritePage chekProductNameInFavorite(String productName) {
        productLink(productName).shouldBe(visible);
        return this;
    }
}
