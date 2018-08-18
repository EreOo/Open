package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import locators.MailPageLocators;
import org.openqa.selenium.Keys;
import util.TimeOut;

import static com.codeborne.selenide.Selenide.$;
import static locators.MailPageLocators.*;

/**
 * Created Vladimir Shekhavtsov.
 * Note: for this project this page is enough. When paje will be grow up and code line will be more
 * than 300 lines, separate page to blocks (example: left menu, header menu, mail table ...)
 */
public class MailPage {

    public MailPage clickWriteMailButton() {
        $(WRITE_MAIL_BUTTON).click();
        return this;
    }

    public MailPage enterMailTo(String toAdress) {
        SelenideElement element = $(MAIL_TO_INPUT);
        element.clear();
        element.setValue(toAdress);
        return this;
    }

    public MailPage enterSubject(String subject) {
        SelenideElement element = $(SUBJECT_INPUT);
        element.clear();
        element.setValue(subject);
        return this;
    }

    public MailPage clickSendButton() {
        $(SUBMIT_BUTTON).click();
        // wait because processing delay.
        new TimeOut().timeOut(2000);
        return this;
    }

    public MailPage clickLeftMenuSendedButton() {
        $(LEFT_MENU_SENDED_BUTTON).click();
        return this;
    }

    public MailPage checkMailIsExist(String subject) {
        // wait because processing delay.
        new TimeOut().timeOut(2000);
        $(MailPageLocators.getMail(subject)).shouldBe(Condition.visible);
        return this;
    }

    public MailPage selectAllMails() {
        $(ALL_MAILS_CHECKBOX).click();
        return this;
    }

    public MailPage clickDelete() {
        $(DELETE_BUTTON).click();
        return this;
    }

    public MailPage clickMarkButton() {
        $(MARK_BUTTON).click();
        // wait because processing delay.
        new TimeOut().timeOut(2000);
        return this;
    }

    public MailPage clickImportantMarkButton() {
        $(IMPORTANT_MARK_BUTTON).click();
        return this;
    }

    public MailPage clickImportantLeftMenuButton() {
        $(LEFT_MENU_IMPORTANT_BUTTON).click();
        return this;
    }

    public MailPage enterSearchQueryAndFind(String subject) {
        $(SEARCH_INPUT).setValue(subject).sendKeys(Keys.ENTER);
        return this;
    }

    public MailPage checkMessagesSearchInfoTitle() {
        $(SEARCH_INFO_RESULT_TITLE).shouldBe(Condition.visible);
        return this;
    }

    public MailPage checkNoEmailsText() {
        $(NO_EMAILS_TEXT).shouldHave(Condition.text("В папке «Входящие» нет писем."));
        return this;
    }
}
