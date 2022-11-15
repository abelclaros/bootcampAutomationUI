package todoist.page_todoist;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import structuredSelenium.control.Button;
import structuredSelenium.control.TextBox;

public class HomePage {
    public static Actions loginButton;
    public Button loginButtontodoist = new Button(By.xpath("//ul//a[@href = '/auth/login']"));
}
