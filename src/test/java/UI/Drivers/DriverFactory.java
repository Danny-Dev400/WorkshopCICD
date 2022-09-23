package UI.Drivers;

import UI.Drivers.ChromeDriver.ChromeDriverS;
import UI.Drivers.EdgeDriver.EdgeDriverS;
import Utils.Enum.Enums;
import org.openqa.selenium.WebDriver;

public class DriverFactory {

    public WebDriver loadDriver(Enums.Driver typedriver) {
        switch (typedriver){
            case CHROME:
                return new ChromeDriverS().loadDriver();
            case EDGE:
                return new EdgeDriverS().loadDriver();
        }
        return null;
    }
}
