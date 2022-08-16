package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StatusCodesPage {
    private WebDriver driver;
    private By successLink = By.xpath("//li/a[text()='200']");
    private By movedPermanentlyLink = By.xpath("//li/a[text()='301']");
    private By notFoundLink = By.xpath("//li/a[text()='404']");
    private By internalServerLink = By.xpath("//li/a[text()='500']");
    private By paragraph = By.xpath("//p");

    public StatusCodesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void click200StatusCode() {
        driver.findElement(successLink).click();
    }

    public void click301StatusCode() {
        driver.findElement(movedPermanentlyLink).click();
    }

    public void click404StatusCode() {
        driver.findElement(notFoundLink).click();
    }

    public void click500StatusCode() {
        driver.findElement(internalServerLink).click();
    }

    public String getParagraphContent() {
        return driver.findElement(paragraph).getText();
    }
}
