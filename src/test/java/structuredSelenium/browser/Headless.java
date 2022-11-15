package structuredSelenium.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Headless implements IBrowser{
    @Override
    public WebDriver create() {
        System.setProperty("webdriver.chrome.driver", "/usr/lib/chromium-browser/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--window-size=1920,1200");

        WebDriver driver = new ChromeDriver(options);
        /*Implicit Wait*/
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        /*Page Load Wait*/
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        return driver;
    }
}
