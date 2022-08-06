package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InternalServerErrorPage {
    private WebDriver driver;
    private By pageText = By.tagName("h1");

    public InternalServerErrorPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageText() {
        return driver.findElement(pageText).getText();
    }
}
