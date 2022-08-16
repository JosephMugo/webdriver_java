package statusCodes;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.StatusCodesPage;

public class StatusCodesTests extends BaseTests {

    @Test
    public void test200CodeContent() {
        StatusCodesPage statusCodesPage = homePage.clickStatusCodesPage();
        statusCodesPage.click200StatusCode();
        String content = statusCodesPage.getParagraphContent();
        Assert.assertTrue(content.contains("This page returned a 200 status code"));
    }

}
