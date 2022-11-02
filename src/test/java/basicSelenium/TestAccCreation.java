package basicSelenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestAccCreation {

    WebDriver driver;


    @BeforeEach
    public void setup(){
        System.setProperty("webdriver.chrome.driver","/usr/lib/chromium-browser/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://todo.ly/");
    }

    @AfterEach
    public void cleanup(){ driver.quit(); }

    @Test
    public void accountCreation() throws InterruptedException {

        /* Account creation */
        driver.findElement(By.xpath("//img[contains(@src, 'pagesignup')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("ctl00_MainContent_SignupControl1_TextBoxFullName")).sendKeys("Abel Claros");
        Thread.sleep(1000);
        driver.findElement(By.id("ctl00_MainContent_SignupControl1_TextBoxEmail")).sendKeys("abelclaros@hotmail.com");
        Thread.sleep(1000);
        driver.findElement(By.id("ctl00_MainContent_SignupControl1_TextBoxPassword")).sendKeys("12345");
        Thread.sleep(1000);
        driver.findElement(By.id("ctl00_MainContent_SignupControl1_CheckBoxTerms")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("ctl00_MainContent_SignupControl1_ButtonSignup")).click();
        Thread.sleep(5000);
        Assertions.assertTrue(driver.findElement(By.id("ctl00_HeaderTopControl1_LinkButtonLogout")).isDisplayed()
                ,"ERROR Creation was incorrect");

    }
}
