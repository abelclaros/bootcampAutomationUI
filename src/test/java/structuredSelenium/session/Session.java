package structuredSelenium.session;

import structuredSelenium.browser.FactoryBrowser;
import org.openqa.selenium.WebDriver;

public class Session {
    //create same type attribute
    private static Session instance = null;
    private WebDriver browser;

    //Create a private constructor
    private Session(){

        browser = FactoryBrowser.make("chrome").create();
    }
//metodo public estatico para acceder a la instancia unica
    public static Session getInstance(){
        if (instance == null)
            instance = new Session();
        return instance;
    }
    public void closeSession(){
        browser.quit();
        instance = null;
    }
    public WebDriver getBrowser(){
        return browser;
    }

    public void acceptAlert(){

        browser.switchTo().alert().accept();
    }
}

