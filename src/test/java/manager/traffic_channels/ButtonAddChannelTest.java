package manager.traffic_channels;

import auth.LoginIn;
import manager.BasePage;
import manager.pages.channel.ChannelsPage;
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
public class ButtonAddChannelTest {
    WebDriver driver ;

    @BeforeTest
    public void setupWebDriver(){
        driver = (new SetupDriver()).setDriver();
    }

    @Test
    public void addNewChannel() throws InterruptedException {

        String baseUrl = System.getProperty("baseUrl");
        LoginIn auth_mg = new LoginIn(driver);
        BasePage get_page = new BasePage(driver);
        ChannelsPage channels_page =new ChannelsPage(driver);

        get_page.goToChannels();
        auth_mg.login(System.getProperty("manager_user"), System.getProperty("manager_password"));
        channels_page.goToAddPage();

        Assert.assertEquals( baseUrl + "/mng_new/tools/traffic_channels/new", driver.getCurrentUrl());
    }

    @AfterTest
    public void closeBrowser(){
     // driver.close();
    }

}
