package structuredSelenium.page_todoly;

import structuredSelenium.control.Label;
import org.openqa.selenium.By;

public class MainPage {
    public Label loginLabel = new Label(By.xpath("//img[contains(@src, 'pagelogin')]"));
}
