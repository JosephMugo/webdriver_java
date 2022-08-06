package fileupload;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.FileUploadPage;

import static org.testng.Assert.assertEquals;

public class FileUploadTests extends BaseTests {

    @Test
    public void testFileUpload() {
        FileUploadPage fileUploadPage = homePage.clickFileUploadPage();
        fileUploadPage.uploadFile("C:\\Users\\Joseph\\Desktop\\JavaProgramming\\webdriver_java\\resources\\chromedriver.exe");
        assertEquals(fileUploadPage.getUploadedFileTxt(), "chromedriver.exe", "Uploaded file does not match");
    }
}
