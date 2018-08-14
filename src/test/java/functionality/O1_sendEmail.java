package functionality;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pages.base.Runner;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

/**
 * Created Vladimir Shekhavtsov.
 */
public class O1_sendEmail {
    private static final String WRITE_LOGIN = "writeropentester@yandex.ru";
    private static final String WRITER_PASSWORD = "open12345";

    @Test
    public void sendEmail() {
        new Runner().openSite()
                .clickEnterInEmailButton()
                .enterLogin(WRITE_LOGIN)
                .enterPassword(WRITER_PASSWORD)
                .clickConfirmButton()
                // yandex could ask user set phone number.
                .checkPhoneNumberAskAndSkip();
    }

    @AfterTest
    public void setDown() {
        getWebDriver().quit();
    }
}
