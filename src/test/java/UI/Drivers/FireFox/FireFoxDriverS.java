package UI.Drivers.FireFox;

import UI.Drivers.IDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FireFoxDriverS implements IDriver {
    @Override
    public FirefoxDriver loadDriver() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--no-sandbox");
        //options.addArguments("--headless");
        options.addArguments("--disable-dev-shm-usage");
        return new FirefoxDriver(options);
    }
}
