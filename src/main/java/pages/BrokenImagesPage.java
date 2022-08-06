package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BrokenImagesPage {

    private WebDriver driver;

    public BrokenImagesPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return driver.findElement(By.tagName("h3")).getText();
    }

}
