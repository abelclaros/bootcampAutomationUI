package todoist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class Task_CRUD extends TestBaseTodoist{

    @Test
    public void todolyCRUD() throws InterruptedException {
        String projectCreate = "Abel " + new Date().getTime();
        String taskCreate = "Abel " + new Date().getTime();
        //Login
        HomePage.loginButtontodoist.click();
        LoginPage.emailTxtbox.setText(user);
        LoginPage.passwordTxtbox.setText(password);
        LoginPage.loginButton.click();
        Assertions.assertTrue(MainPageTodoist.upcoming.isControlDisplayed(), "ERROR login failed");

        //Create project

        MainPageTodoist.plusProjectButton.click();
        MainPageTodoist.projectName.setText(projectCreate);
        MainPageTodoist.submitButton.click();
        Thread.sleep(1000);
        Assertions.assertTrue(MainPageTodoist.isProjectCreated(projectCreate),"ERROR! Project was not created");

        //Create Task

        MainPageTodoist.addTaskButton.click();
        MainPageTodoist.taskName.setText(taskCreate);
        MainPageTodoist.submitAddTaskButton.click();
        Thread.sleep(1000);
        Assertions.assertTrue(MainPageTodoist.isTaskCreated(taskCreate),"ERROR! Task was not created");

        //Update Task
        String taskUpdate = "Abel " + new Date().getTime();
        Thread.sleep(1000);
        MainPageTodoist.taskOptions.click();
        MainPageTodoist.taskEdit.click();
        MainPageTodoist.taskName.cleanSetText(taskUpdate);
        MainPageTodoist.submitAddTaskButton.click();
        Thread.sleep(1000);
        Assertions.assertTrue(MainPageTodoist.isTaskCreated(taskUpdate),"ERROR! Task was not updated");

        //Delete Task
        MainPageTodoist.taskOptions.click();
        MainPageTodoist.taskDelete.click();
        MainPageTodoist.submitDeleteTask.click();
        Thread.sleep(1000);
        Assertions.assertFalse(MainPageTodoist.isTaskCreated(taskUpdate),"ERROR! Task was not deleted");


    }
}
