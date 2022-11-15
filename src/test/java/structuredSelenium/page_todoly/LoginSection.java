package structuredSelenium.page_todoly;

import structuredSelenium.control.Button;
import structuredSelenium.control.TextBox;
import org.openqa.selenium.By;

public class LoginSection {
    public TextBox emailTxtBox = new TextBox(By.id("ctl00_MainContent_LoginControl1_TextBoxEmail"));
    public TextBox passwordTxtBox = new TextBox(By.id("ctl00_MainContent_LoginControl1_TextBoxPassword"));
    public Button loginButton = new Button(By.id("ctl00_MainContent_LoginControl1_ButtonLogin"));
}
