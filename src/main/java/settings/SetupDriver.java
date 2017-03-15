package settings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by o.nikolskaya on 01.03.2017.
 */
public class SetupDriver {

    public WebDriver getDriver(){

        WebDriver driver ;
        String browser = System.getProperty("browser");

        switch(browser){
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                driver = new FirefoxDriver();
                break;
        }

        return driver;
    }

}
