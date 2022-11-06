package basicSelenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

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
        driver.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxEmail")).sendKeys("abelclaros@hotmail.com");
        driver.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxPassword")).sendKeys("12345");
        driver.findElement(By.id("ctl00_MainContent_LoginControl1_ButtonLogin")).click();
        Thread.sleep(3000);
        Assertions.assertTrue(driver.findElement(By.id("ctl00_HeaderTopControl1_LinkButtonLogout")).isDisplayed()
                ,"ERROR login was incorrect");

        /*  Create Project
        -----------------------
        *   Add new project             ->      //td[text()='Add New Project']
        *   Fill project text space     ->      NewProjNameInput
        *   Click Add                   ->      NewProjNameButton
        *   Verify that the project name is present in the Projects list
        */

        String nameProject = "Abel " + new Date().getTime();
        driver.findElement(By.xpath("//td[text()='Add New Project']")).click();
        driver.findElement(By.id("NewProjNameInput")).sendKeys(nameProject);
        driver.findElement(By.id("NewProjNameButton")).click();
        Thread.sleep(3000);
        int actualResult=driver.findElements(By.xpath(" //td[text()='" + nameProject + "'] ")).size();
        Assertions.assertTrue(actualResult >= 1,"ERROR The project was not created");


        /*  Create Task
        ----------------------
        *   Fill task text space        ->      NewItemContentInput
        *   Click Add                   ->      NewItemAddButton
        *   Verify that the task name is present in the Task list
        */
        String nameTask = "Abel " + new Date().getTime();
        driver.findElement(By.id("NewItemContentInput")).sendKeys(nameTask);
        driver.findElement(By.id("NewItemAddButton")).click();
        Thread.sleep(3000);
        actualResult = driver.findElements(By.xpath("//div[.='" + nameTask + "']")).size();
        Assertions.assertTrue(actualResult >= 1,"ERROR THE TASK WAS NOT CREATED");


        /*  Update Task
        * -----------------------
        * Click on modal menu icon          ->  //img[@class='ItemMenu' and @itemid]
        * Click on Edit                     ->  //ul[contains(@id,\"itemContextMenu\")]/li[@class]/a[text()=\"Edit\"]
        * Clear text on the task name field ->  //textarea[@itemid]
        * Input new task name               ->  //textarea[@itemid]
        * Click on Submit icon              ->  //img[@id='ItemEditSubmit' and @itemid]
        * Verify that the task name was updated
        * */
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//div/div/ul/li[@class and @itemid]"))).perform();

        nameTask = "AbelUpdate " + new Date().getTime();


        driver.findElement(By.xpath("//img[@class='ItemMenu' and @itemid]")).click();
        driver.findElement(By.xpath("//ul[contains(@id,\"itemContextMenu\")]/li[@class]/a[text()=\"Edit\"]")).click();
        driver.findElement(By.xpath("//td/div/div/textarea")).clear();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//td/div/div/textarea")).sendKeys(nameTask);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//td/div/div/img[@src='/Images/save.png']")).click();
        Thread.sleep(5000);
        actualResult = driver.findElements(By.xpath("//div[.='" + nameTask + "']")).size();
        Assertions.assertTrue(actualResult >= 1, "ERROR THE TASK WAS NOT EDITED");




    }
}
