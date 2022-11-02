package basicSelenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Date;

public class Homework {

    WebDriver driver;

    @BeforeEach
    public void setup(){
        System.setProperty("webdriver.chrome.driver","/usr/lib/chromium-browser/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://todo.ly/");
    }

    @AfterEach
    public void cleanup(){
        driver.quit();
    }

    @Test
    public void HomeWork() throws InterruptedException {

        /*Login*/

        driver.findElement(By.xpath("//img[contains(@src,'pagelogin')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxEmail")).sendKeys("abelclaros@hotmail.com");
        Thread.sleep(1000);
        driver.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxPassword")).sendKeys("12345");
        Thread.sleep(1000);
        driver.findElement(By.id("ctl00_MainContent_LoginControl1_ButtonLogin")).click();
        Thread.sleep(5000);
        Assertions.assertTrue(driver.findElement(By.id("ctl00_HeaderTopControl1_LinkButtonLogout")).isDisplayed()
                ,"ERROR login was incorrect");

        /*Create Project*/

        String nameProject="Abel"+new Date().getTime();

        driver.findElement(By.xpath("///td[text()='Add New Project']")).click();
        driver.findElement(By.id("NewProjNameInput")).sendKeys(nameProject);
        driver.findElement(By.id("NewProjNameButton")).click();
        Thread.sleep(1000);
        int actualResult=driver.findElements(By.xpath(" //td[text()='"+nameProject+"'] ")).size();
        Assertions.assertTrue(actualResult >= 1
                ,"ERROR The project was not created");

        /*Create Task*/

        String nameTask="Abel Task"+new Date().getTime();

        driver.findElement(By.xpath("//*[@id=\"NewItemContentInput\"]")).sendKeys(nameTask);
        driver.findElement(By.xpath("//*[@id=\"NewItemAddButton\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"ItemId_11078655\"]/table/tbody/tr/td[3]/div[4]")).click();
        Thread.sleep(1000);
        actualResult=driver.findElements(By.xpath(" //td[text()='"+nameTask+"'] ")).size();
        Assertions.assertTrue(actualResult >= 1
                ,"ERROR The project was not created");


        /*Update Task*/

        nameTask="Abel Task Update"+new Date().getTime();

        driver.findElement(By.xpath("//*[@id=\"ItemId_11078655\"]/table/tbody/tr/td[4]/div/img")).click();
        driver.findElement(By.xpath("//ul[@id=\"projectContextMenu\"]//a[text()='Edit']")).click();
        driver.findElement(By.xpath("//*[@id=\"ItemId_11078655\"]/table/tbody/tr/td[3]/div[4]")).clear();
        driver.findElement(By.xpath("//*[@id=\"ItemId_11078655\"]/table/tbody/tr/td[3]/div[4]")).sendKeys(nameTask);
        driver.findElement(By.xpath("//td/div/img[@id='ItemEditSubmit']")).click();
        Thread.sleep(1000);
        actualResult=driver.findElements(By.xpath(" //td[text()='"+nameTask+"'] ")).size();
        Assertions.assertTrue(actualResult >= 1
                ,"ERROR The project was not updated");

//*[@id="ItemId_11078655"]/table/tbody/tr/td[3]/div[4]

    }
}
