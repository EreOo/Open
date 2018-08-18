package pages;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.NoSuchElementException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static locators.YandexPageLocators.*;

/**
 * Created Vladimir Shekhavtsov.
 */
public class YandexPage {

    public YandexPage clickEnterInEmailButton() {
        $(ENTER_IN_EMAIL_BUTTON).click();
        return this;
    }

    public YandexPage enterLogin(String writeLogin) {
        SelenideElement element = $(LOGIN);
        element.clear();
        element.setValue(writeLogin);
        return this;
    }

    public YandexPage enterPassword(String writerPassword) {
        SelenideElement element = $(PASSWORD);
        element.clear();
        element.setValue(writerPassword);
        return this;
    }

    public YandexPage clickConfirmButton() {
        $(CONFIRM_BUTTON).click();
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
            SelenideElement element = $(PHONE_NUMBER_ALERT_TITLE);
            if (element.exists()) {
                $$(BUTTON).get(1).click();
            }
        } catch (NoSuchElementException e) {
            // ignored.
        }
        return new MailPage();
    }
}
