package manager;

import org.openqa.selenium.WebDriver;

/**
 * Created by o.nikolskaya on 02.03.2017.
 */
public class BasePage {
    WebDriver driver;
    String baseUrl = System.getProperty("baseUrl");
    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public void goToChannels() {
        driver.get(baseUrl + "/mng_new/tools/traffic_channels");
    }

    public void goToAddChannels() {
        driver.get(baseUrl + "/mng_new/tools/traffic_channels/new");
    }
}
