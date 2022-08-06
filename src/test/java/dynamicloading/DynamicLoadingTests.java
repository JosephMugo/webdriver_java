package dynamicloading;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.DynamicLoadingPage;

import static org.testng.Assert.assertEquals;

public class DynamicLoadingTests extends BaseTests {

    @Test
    public void testWaitUntilHidden() {
        DynamicLoadingPage dynamicLoadingPage = homePage.clickDynamicLoadingPage();
        dynamicLoadingPage.clickExample1();
        dynamicLoadingPage.clickStartButton();
        assertEquals(dynamicLoadingPage.getLoadedText(), "Hello World!", "Text does not match");
    }
}
