package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.PopupComponent;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class FavoritePage {

    PopupComponent popupComponent = new PopupComponent();

    private SelenideElement productLink(String productName) {
        return $(".js-search-product-link[title*='" + productName + "']");
    }

    @Step("Проверяем, что товар \"{productName}\" добавлен в избранное")
    public FavoritePage chekProductNameInFavorite(String productName) {
        productLink(productName).shouldBe(visible);
        return this;
    }
}
