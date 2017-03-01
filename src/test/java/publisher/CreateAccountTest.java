package publisher;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by o.nikolskaya on 28.02.2017.
 */
public class CreateAccountTest {
    WebDriver driver;

    public void setupWebDriver(){
        System.setProperty("webdriver.chrome.driver", "C:/Users/o.nikolskaya/Desktop/programs/chromedriver.exe");
        driver = new ChromeDriver();
        // driver.get("http://beta3.cityads.com.br/");
        driver.get("https://beta.cityads.com.br/mng_new/payments/requests");
        WebElement username = driver.findElement(By.id("auth_content_login_username"));
        username.sendKeys("o.nikolskaya@cityads.com");//e.voronin+manager@cityads.com

        WebElement password = driver.findElement(By.id("auth_content_login_password"));
        password.sendKeys("Nikolskaya");  //123456789

        WebElement sign_in = driver.findElement(By.className("button"));
        sign_in.click();

        driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);

        WebElement login_link = driver.findElement(By.id("popup-login-link"));
        login_link.click();
      /*  driver.get("http://beta3.cityads.com.br/webmaster/office/dashboard");*/
    }


}
