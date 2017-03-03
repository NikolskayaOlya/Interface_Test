package manager.traffic_channels;

import auth.LoginIn;
import manager.BasePage;
import manager.pages.ChannelsPage;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;
import settings.SetupDriver;

/**
 * Created by o.nikolskaya on 02.03.2017.
 */
public class AddChannel {
    WebDriver driver ;

    @BeforeTest
    public void setupWebDriver(){
        driver = (new SetupDriver()).setDriver();
    }

    @Test
    public void addNewChannel() throws InterruptedException {
        HtmlElementLoader.populatePageObject(true, driver);
        String baseUrl = System.getProperty("baseUrl");
        LoginIn auth_mg = new LoginIn(driver);
        BasePage get_page = new BasePage(driver);
        ChannelsPage channels_page =new ChannelsPage(driver);
        get_page.goToChannels();
        auth_mg.login(System.getProperty("manager_user"), System.getProperty("manager_password"));
        Thread.sleep(5000);
        channels_page.add();
        Assert.assertEquals( baseUrl + "/mng_new/tools/traffic_channels/new",driver.getCurrentUrl());
    }


    @AfterTest
    public void closeBrowser(){
     //  driver.close();
    }

}
