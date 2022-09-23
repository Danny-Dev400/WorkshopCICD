package UI.Pages;

import UI.Base.BasePage;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.apache.logging.log4j.ThreadContext;

public class LandingPage extends BasePage {

    private final By loginBtn = By.xpath("//ul[@class='primary']//li[3]/a");
    private final By movieSearchBar = By.id("inner_search_v4");
    private final By searchMovieBtn = By.xpath("//form[@id='inner_search_form']/input");
    private final By moviesBtn = By.xpath("//a[.='Movies']");
    private final By topRatedMovieBtn = By.xpath("//a[@href='/movie/top-rated']");

    public LandingPage(WebDriver driver){
        super(driver);
    }

    @Step("Click in login Button")
    public LoginPage clickLoginBtn(){
        mapLocator(loginBtn).click();
        return new LoginPage(driver);
    }

    @Step("Send Keys Movies Input")
    public LoginPage sendKeysMoviesInput(String query){
        mapLocator(movieSearchBar).sendKeys(query);
        return new LoginPage(driver);
    }

    @Step("Click in search btn")
    public SearchPage clickInSearchBtn(){
        mapLocator(searchMovieBtn).click();
        return new SearchPage(driver);
    }

    @Step("Click In Top Rated Movies")
    public MoviesPage clickInTopRatedMovies() {
        Actions action = new Actions(driver);
        action.moveToElement(mapLocator(moviesBtn)).perform();
        mapLocator(topRatedMovieBtn).click();
        return new MoviesPage(driver);
    }
}
