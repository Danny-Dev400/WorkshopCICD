package UI.Drivers.EdgeDriver;

import UI.Drivers.IDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDriverS implements IDriver {
    @Override
    public EdgeDriver loadDriver() {
        System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "\\src\\test\\java\\UI\\Drivers\\EdgeDriver\\msedgedriver.exe");
        return new EdgeDriver();
    }
}
