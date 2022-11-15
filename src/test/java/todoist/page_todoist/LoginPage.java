package todoist.page_todoist;

import org.openqa.selenium.By;
import structuredSelenium.control.Button;
import structuredSelenium.control.TextBox;

public class LoginPage {

    public TextBox emailTxtbox = new TextBox(By.xpath("//input[@type = 'email']"));
    public TextBox passwordTxtbox = new TextBox(By.xpath("//input[@type = 'password']"));
    public Button loginButton = new Button(By.xpath("//button[@type = 'submit']"));
}
