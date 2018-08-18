package locators;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;

/**
 * Created Vladimir Shekhavtsov.
 */
public final class MailPageLocators {
    public static final By WRITE_MAIL_BUTTON = By.className("mail-ComposeButton-Wrap>a");
    public static final By MAIL_TO_INPUT = By.name("to");
    public static final By SUBJECT_INPUT = By.cssSelector("label[data-key='view=compose-field-subject'] > div > input");
    public static final By SUBMIT_BUTTON = By.cssSelector("button[title='Отправить письмо (Ctrl + Enter)']");
    public static final By LEFT_MENU_SENDED_BUTTON = By.cssSelector("a[href='#sent']");
    public static final By ALL_MAILS_CHECKBOX = By.className("mail-Toolbar-Item-Checkbox");
    public static final By DELETE_BUTTON = byText("Удалить");
    public static final By MARK_BUTTON = By.cssSelector("div[title='Метка (l)']");
    public static final By IMPORTANT_MARK_BUTTON = By.cssSelector("a[data-params='lid=7']");
    public static final By LEFT_MENU_IMPORTANT_BUTTON = By.className("mail-LabelList-Item_content");
    public static final By SEARCH_INPUT = By.tagName("input");
    public static final By SEARCH_INFO_RESULT_TITLE = By.className("mail-MessagesSearchInfo-Title");
    public static final By NO_EMAILS_TEXT = By.className("b-messages__placeholder-item");

    public static By getMail(String subject) {
        return By.cssSelector("span[title ='" + subject + "']");
    }

}
