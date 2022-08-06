package forgotPassword;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.ForgotPasswordPage;
import pages.InternalServerErrorPage;

import static org.testng.Assert.assertEquals;

public class ForgotPasswordTests extends BaseTests {

    @Test
    public void testForgotPassword() {
        ForgotPasswordPage forgotPasswordTests = homePage.clickForgotPasswordPage();

        forgotPasswordTests.inputEmail("example@example.com");
        InternalServerErrorPage internalServerErrorPage = forgotPasswordTests.clickRetrievePasswordButton();

        assertEquals(internalServerErrorPage.getPageText(), "Internal Server Error");

    }
}
