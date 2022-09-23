package UI.Drivers.ChromeDriver;

import UI.Drivers.IDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverS implements IDriver {
    @Override
    public WebDriver loadDriver() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\java\\UI\\Drivers\\ChromeDriver\\chromedriver.exe");
        return new ChromeDriver();
    }
}
