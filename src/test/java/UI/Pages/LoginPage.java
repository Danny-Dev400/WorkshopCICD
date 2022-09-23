package UI.Pages;

import UI.Base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    //private final TLogger logger = LogManager.getLogger(LoginPage.class);

    private final By inputUsername = By.id("username");
    private final By inputPassword = By.id("password");
    private final By loginButton = By.id("login_button");
    private final By errorStatusModal = By.xpath("//div[@class='error_status card']//h2");

    public LoginPage(WebDriver driver){
        super(driver);
    }

    @Step("Send Keys Username Input")
    public LoginPage sendKeysUsernameInput(String userr){
        mapLocator(inputUsername).sendKeys(userr);
        return new LoginPage(driver);
    }

    @Step("Send Keys Password Input")
    public LoginPage sendKeysPasswordInput(String pass){
        mapLocator(inputPassword).sendKeys(pass);
        return new LoginPage(driver);
    }

    @Step("Click in login button")
    public ProfilePage clickInLoginBtn(){
        mapLocator(loginButton).click();
        return new ProfilePage(driver);
    }

    @Step("Verifying Error Status Text")
    public String getErrorStatusText(){
        return waitForDisplayAnElement(errorStatusModal,3).getText();
    }
}
