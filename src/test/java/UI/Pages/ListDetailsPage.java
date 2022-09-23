package UI.Pages;

import UI.Base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ListDetailsPage extends BasePage {

    //private final TLogger logger = LogManager.getLogger(ListDetailsPage.class);

    private final By firstMovieOfTheList = By.cssSelector(".item");

    public ListDetailsPage(WebDriver driver){
        super(driver);
    }

    @Step("Select Movie Of The List")
    public MovieDetailsPage selectMovieOfTheList(int indexMovie){
        mapListLocator(firstMovieOfTheList).get(indexMovie).click();
        return new MovieDetailsPage(driver);
    }
}
