package todoist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.bidi.log.Log;
import todoist.page_todoist.HomePage;
import todoist.page_todoist.LoginPage;
import todoist.page_todoist.MainPageTodoist;

import java.util.Date;
import java.util.Locale;

public class Project_CRUD extends TestBaseTodoist {
    @Test
    public void todolyCRUD() throws InterruptedException {
        String projectCreate = "Abel " + new Date().getTime();
        String projectUpdate = "Abel Update " + new Date().getTime();

        HomePage.loginButtontodoist.click();
        LoginPage.emailTxtbox.setText(user);
        LoginPage.passwordTxtbox.setText(password);
        LoginPage.loginButton.click();
        Assertions.assertTrue(MainPageTodoist.upcoming.isControlDisplayed(), "ERROR login failed");

        MainPageTodoist.plusProjectButton.click();
        MainPageTodoist.projectName.setText(projectCreate);
        MainPageTodoist.submitButton.click();
        Thread.sleep(5000);
        Assertions.assertTrue(MainPageTodoist.isProjectCreated(projectCreate),"ERROR! Project was not created");




    }
}
