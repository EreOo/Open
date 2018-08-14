package pages;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Created Vladimir Shekhavtsov.
 */
public class YandexPage {

    public YandexPage clickEnterInEmailButton() {
        $(By.linkText("Войти в почту")).click();
        return this;
    }

    public YandexPage enterLogin(String writeLogin) {
        SelenideElement element = $(By.name("login"));
        element.clear();
        element.setValue(writeLogin);
        return this;
    }

    public YandexPage enterPassword(String writerPassword) {
        SelenideElement element = $(By.name("passwd"));
        element.clear();
        element.setValue(writerPassword);
        return this;
    }

    public YandexPage clickConfirmButton() {
        $(By.cssSelector("button[type = 'submit']")).click();
        return new YandexPage();
    }

    /**
     * Yandex could ask set phone number. Click skip button.
     * If dialog block is absent, return mail page and use next steps.
     *
     * @return mail page for next work;
     */
    public MailPage checkPhoneNumberAskAndSkip() {
        try {
            SelenideElement element = $(byText("Привяжите номер телефона"));
            if (element.exists()) {
                $$(By.tagName("button")).get(1).click();
            }
        } catch (NoSuchElementException e) {
            // ignored.
        }
        return new MailPage();
    }
}
