package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ShopSelectionPage {

    private final ElementsCollection cityNameButton = $$(".js-city-container");
    private final SelenideElement newCityShopButton = $("[data-city-id='7'] .city-location[data-market-id='9'] .js-market-link");

    public ShopSelectionPage selectCity(String cityName) {
        cityNameButton.findBy(text(cityName)).click();
        return this;
    }

    public MainPage selectShop() {
        newCityShopButton.click();
        return new MainPage();
    }
}