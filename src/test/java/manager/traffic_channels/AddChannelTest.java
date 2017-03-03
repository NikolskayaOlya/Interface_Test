package manager.traffic_channels;

import auth.LoginIn;
import manager.BasePage;
import manager.pages.channel.ChannelsPage;
import manager.pages.channel.CreateChannelPage;
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
         driver = (new SetupDriver()).setDriver();

    }

    @Test
    public void addChannel() throws SQLException, ClassNotFoundException {

        String channel_name = "Channel1";
        String webmaster_name = "e6@cityads.dump (W1-99)";
        LoginIn login_in = new LoginIn(driver);

        String sql = "SELECT id, name FROM traffic_channel WHERE name = " + channel_name + "and webmaster_user_id =" + webmaster_name;
        String db_url = "beta.cityads.com.br:3306/cityads";
        String password ="";
        String user = "root";
        ResultSet result;





        BasePage get_page = new BasePage(driver);
        CreateChannelPage create_channel_page = new CreateChannelPage(driver);

        get_page.goToAddChannels();
        login_in.login(System.getProperty("manager_user"), System.getProperty("manager_password"));
        create_channel_page.addChannel(channel_name, webmaster_name);


        ConnectDB conDB = new ConnectDB(password, user, db_url);
        conDB.connectDB();
        result = conDB.getQueruResult(sql);
        System.out.println(result);

    }

    @AfterTest
    public void closeBeowser(){
        driver.close();
    }
    }
