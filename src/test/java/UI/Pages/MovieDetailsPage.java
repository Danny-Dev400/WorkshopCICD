package UI.Pages;

import UI.Base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class MovieDetailsPage extends BasePage {
    //private final TLogger logger = LogManager.getLogger(MovieDetailsPage.class);

    private final By genres = By.xpath("//span[@class='genres']/a");
    private final By topBilledCast = By.xpath("//ol/li[@class='card']");
    private final By titleMovie = By.cssSelector("div.title > h2 > a");

    public MovieDetailsPage(WebDriver driver){
        super(driver);
    }

    @Step("Verifying if the filter is contained ....")
    public boolean containsFilter(String queryFilter){
        boolean isContained = false;
        for (WebElement genre: mapListLocator(genres)){
            if (genre.getText().equals(queryFilter)){
                isContained = true;
            }
        }
        return isContained;
    }

    @Step("Verifying if the title is correct ....")
    public boolean containsTittle(String queryFilter){
        if (mapLocator(titleMovie).getText().equals(queryFilter)){
            return true;
        }
        return false;
    }

    @Step("Secelt an actor in the top rated list")
    public ActorPage selectAnActor(){
        Random randomActor = new Random();
        mapListLocator(topBilledCast).get(randomActor.nextInt(mapListLocator(topBilledCast).size())).click();
        return new ActorPage(driver);
    }
}
