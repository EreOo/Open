package functionality;

import configuration.Runner;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MailPage;

import java.util.Date;

import static com.codeborne.selenide.Selenide.close;

/**
 * Created Vladimir Shekhavtsov.
 */
public class O1_sendEmail {
    private MailPage mailPage;
    private static final String WRITE_LOGIN = "writeropentester@yandex.ru";
    private static final String WRITER_PASSWORD = "open12345";
    private static final String TO_ADDRESS = "writeropentester@yandex.ru";
    private static final String SUBJECT = "TestEmail" + new Date().getTime();

    @BeforeMethod
    public void setUp() {
        mailPage = new Runner().openSite()
                .clickEnterInEmailButton()
                .enterLogin(WRITE_LOGIN)
                .enterPassword(WRITER_PASSWORD)
                .clickConfirmButton()
                .checkPhoneNumberAskAndSkip();
    }

    @Test
    public void sendEmail() {
        mailPage.clickWriteMailButton()
                .enterMailTo(TO_ADDRESS)
                .enterSubject(SUBJECT)
                .clickSendButton()
                .clickLeftMenuSendedButton()
                .checkMailIsExist(SUBJECT);

    }

    @AfterMethod
    public void setDown() {
        mailPage.selectAllMails()
                .clickDelete();
        close();
    }
}
