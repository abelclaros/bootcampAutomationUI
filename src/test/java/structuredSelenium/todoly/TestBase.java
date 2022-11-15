package structuredSelenium.todoly;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import structuredSelenium.page_todoly.LoginSection;
import structuredSelenium.page_todoly.MainPage;
import structuredSelenium.page_todoly.MenuSection;
import structuredSelenium.page_todoly.ProjectSection;
import structuredSelenium.session.Session;
import todoist.page_todoist.HomePage;
import todoist.page_todoist.LoginPage;
import todoist.page_todoist.MainPageTodoist;

public class TestBase {
    MainPage mainPage = new MainPage();
    LoginSection loginSection = new LoginSection();
    MenuSection menuSection = new MenuSection();
    ProjectSection projectSection = new ProjectSection();


    String user = "abelclaros@hotmail.com";
    String password = "12345";

    @BeforeEach
    public void openBrowser(){
        Session.getInstance().getBrowser().get("http://todo.ly");
            }

    @AfterEach
    public void closeBrowser(){
        Session.getInstance().closeSession();
    }
}
