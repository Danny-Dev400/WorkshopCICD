package UI.Drivers.EdgeDriver;

import UI.Drivers.IDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class EdgeDriverS implements IDriver {
    @Override
    public EdgeDriver loadDriver() {
        WebDriverManager.edgedriver().setup();
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--no-sandbox");
        //options.addArguments("--headless");
        options.addArguments("--disable-dev-shm-usage");
        return new EdgeDriver(options);
    }
}
