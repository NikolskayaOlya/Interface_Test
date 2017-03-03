package auth;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;
/**
 * Created by o.nikolskaya on 02.03.2017.
 */
public class LoginIn {

    WebDriver driver;

    //Username
    @FindBy(id = "auth_content_login_username")
    public WebElement username;

    //Password
    @FindBy(id = "auth_content_login_password")
    public WebElement password;

    //Submit
    @FindBy(id= "auth_content_login_submit")
    public WebElement submit;

    public LoginIn(WebDriver driver){
        this.driver =  driver;
        HtmlElementLoader.populatePageObject(this, driver);
    }

    public void inputUsername (String username){ this.username.sendKeys(username);}
    public void inputPassword (String password){
        this.password.sendKeys(password);
    }
    public void submitLoginForm(){ this.submit.click(); }


    public void login(String user, String pass){
         inputUsername(user);
         inputPassword(pass);
         submitLoginForm();
    }
}
