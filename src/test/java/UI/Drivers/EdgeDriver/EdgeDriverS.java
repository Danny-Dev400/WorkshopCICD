package UI.Drivers.EdgeDriver;

import UI.Drivers.IDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class EdgeDriverS implements IDriver {
    @Override
    public EdgeDriver loadDriver() {
        System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "\\src\\test\\java\\UI\\Drivers\\EdgeDriver\\msedgedriver.exe");
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        options.addArguments("--disable-dev-shm-usage");
        return new EdgeDriver(options);
    }
}
