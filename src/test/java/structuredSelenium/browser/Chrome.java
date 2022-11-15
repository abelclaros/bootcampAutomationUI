package structuredSelenium.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Chrome implements IBrowser{

    @Override
    public WebDriver create() {
        System.setProperty("webdriver.chrome.driver","/usr/lib/chromium-browser/chromedriver");
        WebDriver driver = new ChromeDriver();
        /*Implicit Wait*/
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        /*Page Load Wait*/
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        return driver;
    }
}
