package publisher;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import settings.SetupDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by o.nikolskaya on 28.02.2017.
 */
public class CreateAccountTest {
    WebDriver driver = null;

    @BeforeTest
    public void setupWebDriver(){
        driver = (new SetupDriver()).getDriver();
    }

    @Test(description = "open browser")
    public void inn(){
        driver.get("https://beta.cityads.com.br/mng_new/payments/requests");
    }




}
