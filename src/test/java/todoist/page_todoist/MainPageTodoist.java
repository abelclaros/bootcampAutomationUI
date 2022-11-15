package todoist.page_todoist;

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
    public Button projectOptions = new Button(By.xpath("//a[@aria-label = \"proj, 0 tasks\"]/following-sibling::div"));
    public Button optionsDelete = new Button(By.xpath("//li/div[contains(text(), \"Delete project\")]"));
    public Button upcoming = new Button(By.xpath("//span[text() = 'Upcoming']"));

    public boolean isProjectCreated(String nameProject){
        Label projectCreated = new Label(By.xpath("//a/span[text() = '" + nameProject + "']"));
        return projectCreated.isControlDisplayed();
    }
}
