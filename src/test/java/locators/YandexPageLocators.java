package locators;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;

/**
 * Created Vladimir Shekhavtsov.
 */
public final class YandexPageLocators {
    public static final By ENTER_IN_EMAIL_BUTTON = By.linkText("Войти в почту");
    public static final By LOGIN = By.name("login");
    public static final By PASSWORD = By.name("passwd");
    public static final By CONFIRM_BUTTON = By.cssSelector("button[type = 'submit']");
    public static final By PHONE_NUMBER_ALERT_TITLE = byText("Привяжите номер телефона");
    public static final By BUTTON = By.tagName("button");
}
