package todoist.page_todoist;

import basicSelenium.TestAccCreation;
import org.openqa.selenium.By;
import structuredSelenium.control.Button;
import structuredSelenium.control.Label;
import structuredSelenium.control.TextBox;

public class MainPageTodoist {
    public Button plusProjectButton = new Button(By.xpath("//button[@aria-label = 'Add project']"));
    public TextBox projectName = new TextBox(By.xpath("//input[@name = 'name']"));
    public Button submitButton = new Button(By.xpath("//button[@type = 'submit']"));
    public Button ellipsys = new Button(By.xpath("//button[@aria-label = 'Project options menu']"));
    public Button editButton = new Button(By.xpath("//div[contains(text(), \"Edit project\")]"));
    public TextBox projectEditName = new TextBox(By.xpath("//input[@id ='edit_project_modal_field_name']"));
    public Button addTaskButton = new Button(By.xpath("//button[@class = 'plus_add_button']"));
    public TextBox taskName = new TextBox(By.xpath("//div[@data-offset-key and @data-editor]"));
    public Button submitAddTaskButton = new Button(By.xpath("//span[contains(text(), 'Add task')]"));
    public Button taskOptions = new Button(By.xpath("//button[@data-testid = 'more_menu']"));
    public Button taskEdit = new Button(By.xpath("//div[contains(text(), 'Edit task')]"));
    public Button taskDelete = new Button(By.xpath("//div[contains(text(), 'Delete task')]"));
    public Button submitDeleteTask = new Button(By.xpath("//span[contains(text(), 'Delete')]"));
    public Button optionsDelete = new Button(By.xpath("//li/div[contains(text(), \"Delete project\")]"));
    public Button upcoming = new Button(By.xpath("//span[text() = 'Upcoming']"));

    public boolean isProjectCreated(String nameProject){
        Label projectCreated = new Label(By.xpath("//a/span[text() = \"" + nameProject + "\"]"));
        return projectCreated.isControlDisplayed();
    }

    public boolean isTaskCreated(String nameTask){
        Label taskCreated = new Label(By.xpath("//div[contains(text(), '" + nameTask + "')]"));
        return taskCreated.isControlDisplayed();
    }

    public Button projectOptions (String nameProject){
        Button projectNameInList = new Button(By.xpath("//a[@aria-label = '" + nameProject + ", 0 tasks']/following-sibling::div"));
        return projectNameInList;
    }
}
