package functionality;

import configuration.Runner;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MailPage;
import util.EmailSender;

import static com.codeborne.selenide.Selenide.close;

/**
 * Created Vladimir Shekhavtsov.
 */
public class O3_findEmail {
    private MailPage mailPage;
    private static final String WRITE_LOGIN = "writeropentester@yandex.ru";
    private static final String READER_LOGIN = "readeropentester@yandex.ru";
    private static final String PASSWORD = "open12345";
    private static final String SUBJECT = "EmailToFind";

    @BeforeMethod
    public void setUp() {
        new EmailSender().send(WRITE_LOGIN, PASSWORD, READER_LOGIN, SUBJECT, "");
        mailPage = new Runner().openSite()
                .clickEnterInEmailButton()
                .enterLogin(READER_LOGIN)
                .enterPassword(PASSWORD)
                .clickConfirmButton()
                .checkPhoneNumberAskAndSkip();
    }

    @Test
    public void findEmail() {
        mailPage.enterSearchQueryAndFind(SUBJECT)
                .checkMessagesSearchInfoTitle()
                .checkMailIsExist(SUBJECT);
    }

    @AfterMethod
    public void setDown() {
        mailPage.selectAllMails()
                .clickDelete();
        close();
    }
}
