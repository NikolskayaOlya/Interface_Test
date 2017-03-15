package manager.pages.channel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

/**
 * Created by o.nikolskaya on 03.03.2017.
 */
public class CreateChannelPage {
    WebDriver driver;
    String baseUrl = System.getProperty("baseUrl");



    public CreateChannelPage(WebDriver driver){
        this.driver = driver;
        HtmlElementLoader.populatePageObject(this, driver);

    }

    @FindBy(xpath = "//table[@class='form-table']/tr/td[@class='form-table__value ']/input")
    public WebElement channel_name;

    @FindBy(xpath = "//tr/td[@class='form-table__value ']/div/input")
    public WebElement webmaster_name;

    @FindBy(xpath = "//tr/td[2]/button")
    public Button create_channel_button;

    @FindBy(xpath = "//ul[@class='autocompleter-list']/li[@class='autocompleter-item']")
    public WebElement webmastersList;

    public void goToAddChannels() {
        this.driver.get(baseUrl + "/mng_new/tools/traffic_channels/new");
    }
    public void inputChannelName(String channel_name){
        this.channel_name.sendKeys(channel_name);
    }
    public void inputWebmasterName(String webmaster_name){
        this.webmaster_name.sendKeys(webmaster_name);
    }
    public void pressAddChannelButton(){
        this.create_channel_button.click();
    }



    public void addChannel (String channel_name, String webmaster_name){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        inputWebmasterName(webmaster_name);
        wait.until(ExpectedConditions.visibilityOf(webmastersList));
        inputChannelName(channel_name);
        wait.until(ExpectedConditions.elementToBeClickable(create_channel_button));
        pressAddChannelButton();
    }

}
