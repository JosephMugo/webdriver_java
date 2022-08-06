package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
    private WebDriver driver;
    private By emailInputField = By.id("email");
    private By retrievePasswordButton = By.cssSelector("button#form_submit");

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public void inputEmail(String email) {
        driver.findElement(emailInputField).sendKeys(email);
    }

    public InternalServerErrorPage clickRetrievePasswordButton() {
        driver.findElement(retrievePasswordButton).click();
        return new InternalServerErrorPage(driver);
    }
}
