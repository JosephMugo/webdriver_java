package brokenimages;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.BrokenImagesPage;

import static org.testng.Assert.assertEquals;

public class BrokenImagesTests extends BaseTests {

    @Test
    public void testCorrectTitle() {
        BrokenImagesPage brokenImagesPage = homePage.clickBrokenImagesPage();
        assertEquals(brokenImagesPage.getTitle(), "Broken Images");
    }
}
