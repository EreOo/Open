package configuration;

import com.codeborne.selenide.Configuration;
import pages.YandexPage;

import static com.codeborne.selenide.Selenide.open;

/**
 * Created Vladimir Shekhavtsov.
 * All setting hide there.
 */
public class Runner {
    private static final String URL_SITE = "https://yandex.ru/";

    public YandexPage openSite() {
        selectChrome();
        open(URL_SITE);
        return new YandexPage();
    }

    // Get properties from pom.xml (profiles)
    private void selectChrome() {
        Configuration.browser = System.getProperty("browser");
        //  Uncomment for use selenium grid or selenoid.
        //  Configuration.remote = System.getProperty("hub");
    }

}
