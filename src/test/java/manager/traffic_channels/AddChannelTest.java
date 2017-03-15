package manager.traffic_channels;

import auth.LoginIn;
import manager.pages.channel.CreateChannelPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import settings.ConnectDB;
import settings.SetupDriver;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by o.nikolskaya on 03.03.2017.
 */
public class AddChannelTest {
    WebDriver driver;


    @BeforeTest
    public void setupWebDriver(){
        driver = (new SetupDriver()).getDriver();
    }

    @Test
    public void addChannel() throws SQLException, ClassNotFoundException {

        String channel_name = "Channel3";
        String webmaster_name = "e6@cityads.dump (W1-99)";
        String sql = "SELECT id FROM traffic_channel WHERE name =  'Channel2'  and webmaster_user_id = 6";
        String db_url = "beta.cityads.com.br:3306/cityads";
        String password ="";
        String user = "root";
        ResultSet result;

        LoginIn login_in = new LoginIn(driver);

        CreateChannelPage create_channel_page = new CreateChannelPage(driver);
        create_channel_page.goToAddChannels();
        login_in.login(System.getProperty("manager_user"), System.getProperty("manager_password"));
      //create_channel_page.addChannel ( channel_name, webmaster_name);

        ConnectDB conDB = new ConnectDB(password, user, db_url);
        conDB.connectDB();
        result = conDB.getQueruResult(sql);
        Assert.assertEquals(true, result.next());
        conDB.disconnectDB();
    }

    @AfterTest
    public void closeBeowser(){
        driver.close();
    }
    }
