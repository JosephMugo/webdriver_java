package login;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SecureAreaPage;

import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTests {

    @Test(dataProvider = "LoginDataProvider", dataProviderClass = LoginDataProvider.class)
    public void testSuccessfulLogin(String username, String password) {
        LoginPage loginPage = homePage.clickFormAuthentication();
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        System.out.println(username + " " + password);
        if (username.equals("tomsmith") && password.equals("SuperSecretPassword!")) {
            assertTrue(secureAreaPage.getAlertText().contains("You logged into a secure area!"), "Alert text is incorrect");
        } else {
            System.out.println(loginPage.getFlashText());
            assertTrue(loginPage.getFlashText().contains("Your username is invalid!"), "Flash text is incorrect");
        }

    }
}
