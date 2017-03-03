package manager.pages.channel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

/**
 * Created by o.nikolskaya on 02.03.2017.
 */
public class ChannelsPage {
    WebDriver driver;

    @FindBy(xpath = "//div[@class='fr']/a")
    public Button add_button;

    public ChannelsPage(WebDriver driver){
        this.driver = driver;
        HtmlElementLoader.populatePageObject(this, driver);
    }
    public void goToAddPage(){
        this.add_button.click();
    }
}
