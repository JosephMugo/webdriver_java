package alerts;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.JavascriptAlertsPage;

import static org.testng.Assert.assertEquals;

public class AlertTests extends BaseTests {

    @Test
    public void testAcceptAlert() {
        JavascriptAlertsPage javascriptAlertsPage = homePage.clickJavascriptAlertsPage();
        javascriptAlertsPage.triggerAlert();
        javascriptAlertsPage.alert_clickToAccept();
        assertEquals(javascriptAlertsPage.getResult(), "You successfully clicked an alert", "Result text incorrect");
    }

    @Test
    public void testGetTextFromAlert() {
        JavascriptAlertsPage javascriptAlertsPage = homePage.clickJavascriptAlertsPage();
        javascriptAlertsPage.triggerConfirm();
        String text = javascriptAlertsPage.alert_getText();
        javascriptAlertsPage.alert_clickToDismiss();
        assertEquals(text, "I am a JS Confirm", "Alert text incorrect");
    }

    @Test
    public void testSetInputInAlert() {
        JavascriptAlertsPage javascriptAlertsPage = homePage.clickJavascriptAlertsPage();
        javascriptAlertsPage.triggerPrompt();

        String text = "Joe rocks!";
        javascriptAlertsPage.alert_setInput(text);
        javascriptAlertsPage.alert_clickToAccept();
        assertEquals(javascriptAlertsPage.getResult(), "You entered: " + text, "Results text incorrect");
    }
}
