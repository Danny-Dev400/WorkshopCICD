package UI.Pages;

import UI.Base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class MoviesPage extends BasePage {
    //private final TLogger logger = LogManager.getLogger(LogManager.class);

    private final By filterDropDown = By.xpath("//h2[.='Filters']");
    private final By filter = By.xpath("//a[.='Action']");
    private final By applyFiltersBtnEnabled = By.xpath("//div[@class='apply small background_color light_blue enabled']//a[.='Search']");
    private final By applyFiltersBtnDisabled = By.xpath("//div[@class='apply small background_color light_blue disabled']//a[.='Search']");
    private final By sectionResultsMovies = By.xpath("//section[@id='media_results']/div/div/div[contains(@class,'card')]");
    private final By sortBtn = By.xpath("//div[@class='filter']/span");
    private By listOfSortOptions;

    public MoviesPage(WebDriver driver){
        super(driver);
    }

    @Step("Click In Filter")
    public MoviesPage clickInFilter(){
        mapLocator(filterDropDown).click();
        return new MoviesPage(driver);
    }

    @Step("Put Action Filter")
    public MoviesPage putActionFilter(){
        waitForDisplayAnElement(filter,5).click();
        return new MoviesPage(driver);
    }

    @Step("Applying Filters")
    public MoviesPage applyFilters(){
        mapLocator(applyFiltersBtnEnabled).click();
        return new MoviesPage(driver);
    }

    @Step("Click In Sort DropDown")
    public MoviesPage clickInSortDropDown(){
        mapLocator(sortBtn).click();
        return new MoviesPage(driver);
    }

    @Step("Apply Sortting")
    public MoviesPage applySortting(String sortType){
        listOfSortOptions = By.xpath(String.format("//ul[@id='sort_by_listbox']/li[.='%s']", sortType));
        waitForDisplayAnElement(listOfSortOptions,5).click();
        mapLocator(applyFiltersBtnEnabled).click();
        waitForDisplayAnElement(applyFiltersBtnDisabled,5);
        return new MoviesPage(driver);
    }

    @Step("Verify Release Date Ascending")
    public boolean verifyReleaseDateAscending() throws ParseException {
        boolean isInAscendingOrder = true;
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
        for (int i = 0; i < 4; i++) {
            String getDate1 = mapListLocator(sectionResultsMovies).get(i).getText().split("\n")[1];
            String getDate2 = mapListLocator(sectionResultsMovies).get(i+1).getText().split("\n")[1];
            Date date1 = sdf.parse(getDate1);
            Date date2 = sdf.parse(getDate2);
            if (date1.after(date2)){
                isInAscendingOrder = false;
            }
        }
        return isInAscendingOrder;

    }

    @Step("Select Random Movie")
    public MovieDetailsPage selectRandomMovie(){
        Random randomMovie = new Random();
        waitForDisplayAnElement(applyFiltersBtnDisabled,5);
        mapListLocator(sectionResultsMovies)
                .get(randomMovie.nextInt(mapListLocator(sectionResultsMovies).size())).click();
        return new MovieDetailsPage(driver);
    }
}
