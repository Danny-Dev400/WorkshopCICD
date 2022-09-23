package UI.Pages;

import UI.Base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Locale;

public class ActorPage extends BasePage {

    //private final TLogger logger = LogManager.getLogger(ActorPage.class);

    By acting = By.className("tooltip");

    public ActorPage(WebDriver driver){
        super(driver);
    }

    @Step("Verify If TheMovies Is Contained")
    public boolean verifyIfTheMoviesIsContained(String Movie){
        boolean isContained = false;
        for(WebElement element : mapListLocator(acting)){
            if (element.getText().toLowerCase(Locale.ROOT).equals(Movie)){
                isContained = true;
            }
        }
        return isContained;
    }
}
