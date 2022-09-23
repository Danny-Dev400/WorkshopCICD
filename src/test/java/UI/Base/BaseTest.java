package UI.Base;

import UI.Drivers.DriverFactory;
import Utils.Enum.Enums;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.ByteArrayInputStream;

public class BaseTest {
    protected static ThreadLocal<WebDriver> driver =  new ThreadLocal<>();

    @BeforeMethod
    @Parameters({ "typedriver" })
    public void setup(@Optional String typedriver){
        DriverFactory driverFactory = new DriverFactory();
        driver.set(driverFactory.loadDriver(Enums.Driver.valueOf(typedriver)));
        getDriver().manage().window().maximize();
        getDriver().navigate().to("https://www.themoviedb.org/");
    }

    public static WebDriver getDriver(){
        return driver.get();
    }

    @AfterMethod
    public void tearDown(ITestResult result){
        if(getDriver() == null)
            return;
        if (!result.isSuccess()){
            byte[] myScreenshot = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Screenshot",new ByteArrayInputStream(myScreenshot));
        }
        getDriver().quit();
    }
}
