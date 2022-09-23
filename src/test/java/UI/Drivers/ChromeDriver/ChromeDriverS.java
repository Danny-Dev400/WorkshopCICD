package UI.Drivers.ChromeDriver;

import UI.Drivers.IDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeDriverS implements IDriver {
    @Override
    public WebDriver loadDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        //options.addArguments("--headless");
        options.addArguments("--disable-dev-shm-usage");
        return new ChromeDriver(options);
    }
}
