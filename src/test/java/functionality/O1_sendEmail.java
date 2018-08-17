package functionality;

import configuration.Runner;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.Date;

import static com.codeborne.selenide.Selenide.close;

/**
 * Created Vladimir Shekhavtsov.
 */
public class O1_sendEmail {
    private static final String WRITE_LOGIN = "writeropentester@yandex.ru";
    private static final String WRITER_PASSWORD = "open12345";
    private static final String TO_ADRESS = "writeropentester@yandex.ru";
    private static final String SUBJECT = "TestEmail" + new Date().getTime();

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
                .enterTheme(SUBJECT)
                .clickSendButton()
                .clickMenuSendedButton()
                .checkMailIsExist(SUBJECT)
                .selectAllMails()
                .clickDelete();
    }

    @AfterMethod
    public void setDown() {
        close();
    }
}
