package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

/**
 * Created Vladimir Shekhavtsov.
 */
public class MailPage {

    public MailPage clickWriteMailButton() {
        $(By.className("mail-ComposeButton-Wrap>a")).click();
        return this;
    }

    public MailPage enterMailTo(String toAdress) {
        SelenideElement element = $(By.name("to"));
        element.clear();
        element.setValue(toAdress);
        return this;
    }

    public MailPage enterTheme(String theme) {
        SelenideElement element = $(By.cssSelector("label[data-key='view=compose-field-subject'] > div > input"));
        element.clear();
        element.setValue(theme);
        return this;
    }

    public MailPage clickSendButton() {
        $(By.cssSelector("button[title='Отправить письмо (Ctrl + Enter)']")).click();
        timeOut(2000);
        return this;
    }

    public MailPage clickMenuSendedButton() {
        $(By.cssSelector("a[href='#sent']")).click();
        return this;
    }

    public MailPage checkMailIsExist(String subject) {
        timeOut(2000);
//        Assert.assertTrue($(By.cssSelector("span[title ='" + subject + "']")).isDisplayed());
        $(By.cssSelector("span[title ='" + subject + "']")).shouldBe(Condition.visible);
        return this;
    }

    //TODO VS add to new util class
    private void timeOut(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public MailPage selectAllMails() {
        $(By.className("mail-Toolbar-Item-Checkbox")).click();
        return this;
    }

    public MailPage clickDelete() {
        $(byText("Удалить")).click();
        return this;
    }

    public MailPage clickMarkButton() {
        $(By.cssSelector("div[title='Метка (l)']")).click();
        timeOut(2000);
        return this;
    }

    public MailPage clickImportantMarkButton() {
        $(By.cssSelector("a[data-params='lid=7']")).click();
        return this;
    }

    public MailPage clickImportantLeftMenuButton() {
        $(By.className("mail-LabelList-Item_content")).click();
        return this;
    }

    public MailPage enterSearchQueryAndFind(String subject) {
        $(By.tagName("input")).setValue(subject).sendKeys(Keys.ENTER);
        return this;
    }

    public MailPage checkMessagesSearchInfoTitle() {
        $(By.className("mail-MessagesSearchInfo-Title")).shouldBe(Condition.visible);
        return this;
    }
}
