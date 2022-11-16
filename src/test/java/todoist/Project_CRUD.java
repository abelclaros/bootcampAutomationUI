package todoist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Date;


public class Project_CRUD extends TestBaseTodoist {
    @Test
    public void todolyCRUD() throws InterruptedException {
        String projectCreate = "Abel " + new Date().getTime();
        String projectUpdate;

        HomePage.loginButtontodoist.click();
        LoginPage.emailTxtbox.setText(user);
        LoginPage.passwordTxtbox.setText(password);
        LoginPage.loginButton.click();
        Assertions.assertTrue(MainPageTodoist.upcoming.isControlDisplayed(), "ERROR login failed");

        MainPageTodoist.plusProjectButton.click();
        MainPageTodoist.projectName.setText(projectCreate);
        MainPageTodoist.submitButton.click();
        Thread.sleep(1000);
        Assertions.assertTrue(MainPageTodoist.isProjectCreated(projectCreate),"ERROR! Project was not created");

        MainPageTodoist.projectOptions(projectCreate).click();
        MainPageTodoist.editButton.click();
        projectUpdate = "Abel Update " + new Date().getTime();
        MainPageTodoist.projectName.cleanSetText(projectUpdate);
        MainPageTodoist.submitButton.click();
        Thread.sleep(1000);
        Assertions.assertTrue(MainPageTodoist.isProjectCreated(projectUpdate),"ERROR! Project was not updated");


        MainPageTodoist.projectOptions(projectUpdate).click();
        MainPageTodoist.optionsDelete.click();
        MainPageTodoist.submitButton.click();
        Thread.sleep(2000);
        Assertions.assertFalse(MainPageTodoist.isProjectCreated(projectUpdate),"ERROR! Project was not deleted");





    }
}
