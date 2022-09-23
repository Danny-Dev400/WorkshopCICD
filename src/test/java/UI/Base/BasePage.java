package UI.Base;

import org.apache.logging.log4j.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    protected WebDriver driver;

    protected static final Marker DRIVER = MarkerManager.getMarker("DRIVER");

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement waitForDisplayAnElement(By element, int time){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public WebElement mapLocator(By locator){
        return driver.findElement(locator);
    }

    public List<WebElement> mapListLocator(By locator){
        return driver.findElements(locator);
    }
}
