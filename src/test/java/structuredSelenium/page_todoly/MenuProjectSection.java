package structuredSelenium.page_todoly;

import structuredSelenium.control.Button;
import org.openqa.selenium.By;

public class MenuProjectSection {

    public Button menuIconButton = new Button(By.xpath("//div[contains(@style,'block')]/img"));
    public Button editButton = new Button(By.xpath("//ul[@id=\"projectContextMenu\"]//a[text()='Edit']"));
    public Button deleteButton = new Button(By.id("ProjShareMenuDel"));
}
