package UI.Pages;

import UI.Base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage extends BasePage {

    //private final TLogger logger = LogManager.getLogger(SearchPage.class);

    private final By sectionSearchResultOnlyTitles = By.xpath("//div[@class='title']/div/a");

    public SearchPage(WebDriver driver){
        super(driver);
    }

    @Step("Get The First Result")
    public WebElement getTheFirstResult(){
        return mapListLocator(sectionSearchResultOnlyTitles).get(0);
    }

    @Step("Click In The First Result")
    public MovieDetailsPage clickInTheFirstResult(){
        mapListLocator(sectionSearchResultOnlyTitles).get(0).click();
        return new MovieDetailsPage(driver);
    }
}
