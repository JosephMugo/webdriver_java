package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HorizontalSliderPage {
    private WebDriver driver;
    private By slider = By.tagName("input");
    private By sliderValue = By.id("range");

    public HorizontalSliderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void increaseSlider() {
        driver.findElement(slider).sendKeys(Keys.ARROW_RIGHT);
    }

    public void decreaseSlider() {
        driver.findElement(slider).sendKeys(Keys.ARROW_LEFT);
    }

    public void setSliderValue(double value) {

        // Value Validation Check
        if (value > 5 || value < 0 || (value % 0.5 != 0)) {
            throw new IllegalArgumentException("Value invalid");
        }

        double currentValue = getSliderValue();

        while (currentValue != value) {
            if (currentValue > value) {
                driver.findElement(slider).sendKeys(Keys.ARROW_LEFT);
            } else {
                driver.findElement(slider).sendKeys(Keys.ARROW_RIGHT);
            }
            currentValue = getSliderValue();
        }
    }

    public double getSliderValue() {
        return Double.parseDouble(driver.findElement(sliderValue).getText());
    }
}
