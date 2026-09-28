package helpers;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class PopupHelper {
    private static final long INTERVAL_MS = 500;
    private static Thread killer;

    private PopupHelper() {}

    @Step("Удалить попап Mindbox / PopMechanic")
    public static void removePopMechanic() {
        if (!WebDriverRunner.hasWebDriverStarted()) return;
        try {
            executeJavaScript(
                    "document.querySelectorAll(" +
                            "  '.popmechanic-close, [data-popmechanic-close], " +
                            "   [id^=\"popmechanic-\"], .popmechanic-js-container, " +
                            "   .popmechanic-wrapper, .popmechanic-js-wrapper, " +
                            "   .popmechanic-js-paranja'" +
                            ").forEach(el => el.click());"
            );
        } catch (Exception ignored) {
        }
    }

    public static void start() {
        if (killer != null && killer.isAlive()) return;
        killer = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    removePopMechanic();
                    Thread.sleep(INTERVAL_MS);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                } catch (Exception ignored) {
                    return;
                }
            }
        });
        killer.setDaemon(true);
        killer.start();
    }

    public static void stop() {
        if (killer != null) {
            killer.interrupt();
            killer = null;
        }
    }
}
