package functionality;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pages.base.Runner;

import java.util.Date;

import static com.codeborne.selenide.Selenide.close;

/**
 * Created Vladimir Shekhavtsov.
 */
public class O1_sendEmail {
    private static final String WRITE_LOGIN = "writeropentester@yandex.ru";
    private static final String WRITER_PASSWORD = "open12345";
    private static final String TO_ADRESS = "writeropentester@yandex.ru";
    private static final String THEME = "TestEmail" + new Date().getTime();

    @Test
    public void sendEmail() {
        new Runner().openSite()
                .clickEnterInEmailButton()
                .enterLogin(WRITE_LOGIN)
                .enterPassword(WRITER_PASSWORD)
                .clickConfirmButton()
                // yandex could ask user set phone number.
                .checkPhoneNumberAskAndSkip()
                .clickWriteMailButton()
                .enterMailTo(TO_ADRESS)
                .enterTheme(THEME)
                .clickSendButton()
                .clickMenuSendedButton()
                .checkMailIsExist(THEME)
                .selectAllMails()
                .clickDelete();
    }

    @AfterTest
    public void setDown() {
        close();
    }
}
