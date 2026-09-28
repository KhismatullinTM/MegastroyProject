package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import helpers.PopupHelper;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import testData.ConfigData;

import java.util.Map;

import static com.codeborne.selenide.Selenide.*;

public class TestBase {

    static ConfigData configData = new ConfigData();

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = System.getProperty("URL", "https://" + configData.CITY_SHOP_NAME + ".megastroy.com");
        Configuration.browser = System.getProperty("BROWSER", "chrome");
        Configuration.browserSize = System.getProperty("BROWSER_SIZE");
        Configuration.browserVersion = System.getProperty("BROWSER_VERSION");
        Configuration.headless = Boolean.parseBoolean(System.getProperty("HEADLESS", "false"));
        Configuration.timeout = 5000;

        DesiredCapabilities capabilities = new DesiredCapabilities();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments(
                "--disable-dev-shm-usage",
                "--no-sandbox",
                "--host-rules=MAP personalization-web.g.mindbox.ru 0.0.0.0, " +
                        "MAP personalization-speedtest.g.mindbox.ru 0.0.0.0, " +
                        "MAP web-static.mindbox.ru 0.0.0.0, " +
                        "MAP personalization-web.mindbox.ru 0.0.0.0"
        );
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));

        Configuration.browserCapabilities = capabilities;

        String selenoidUrl = System.getProperty("SELENOID_URL");
        if (selenoidUrl == null || selenoidUrl.isEmpty() || "null".equals(selenoidUrl)) {
            selenoidUrl = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        }
        Configuration.remote = selenoidUrl;
    }

    @BeforeEach
    void setUpPage() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open("/");
        executeJavaScript("document.querySelector('#accept-cookie-notification')?.click();");
        PopupHelper.start();
    }

    @AfterEach
    void tearDown() {
        PopupHelper.stop();
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }
}