package base;

import com.aventstack.extentreports.ExtentReports;
import com.google.common.io.Files;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.EventReporter;
import utils.WindowManager;

import java.awt.*;
import java.io.File;
import java.io.IOException;

// This class serves as the base class for all test
public class BaseTests {

    // This is the driver object that is responsible for interacting with browser
    private EventFiringWebDriver driver;
    private ExtentReports extentReports;
    protected HomePage homePage;

    @BeforeClass
    public void setUp() {
        // provide location of driver
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");

        // https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/WebDriver.html
        driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));

        driver.register(new EventReporter());


        // pull website before starting to interact with elements unless element is found under time provided
        // Implicit Wait
        // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        // Explicit Wait


        // makes window appear on the left side of the screen
        driver.manage().window().setPosition(new org.openqa.selenium.Point(0, 0));
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        driver.manage().window().setSize(new org.openqa.selenium.Dimension((int) (dimension.getWidth() / 2), (int) dimension.getHeight()));

        goHome();
        setCookies();


        homePage = new HomePage(driver);
    }

    @BeforeMethod
    public void goHome() {
        driver.get("https://the-internet.herokuapp.com");
    }

    @AfterClass
    public void tearDown() {
        // Quits this driver, closing every associated window.
        driver.quit();
    }

    @AfterMethod
    public void recordFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            var camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot, new File("resources/screenshots/" + result.getName() + ".png "));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public WindowManager getWindowManager() {
        return new WindowManager(driver);
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        // option for running test without actually opening up browser
        // options.setHeadless(true);
        return options;
    }

    private void setCookies() {
        Cookie cookie = new Cookie.Builder("tau", "123")
                .domain("the-internet.herokuapp.com")
                .build();
        driver.manage().addCookie(cookie);
    }
}
