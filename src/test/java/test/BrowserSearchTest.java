package test;

import Pages.BrowserSearch;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import util.Constants;

public class BrowserSearchTest {
    private StringBuffer verificationErrors = new StringBuffer();
    private String PATHDRIVER = "src/test/resources/drivers/";
    private String baseURL = "https://www.google.com/";
    private WebDriver driver;

    @Before
    public void setup(){

        System.setProperty("webdriver.chrome.driver", Constants.PATHDRIVERCHROME + "chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();
    }

    @Test
    public void signUp() throws InterruptedException {

        driver.get(baseURL);
        BrowserSearch browserSearch = new BrowserSearch(driver);
        browserSearch.setSearchBox("fluente wait");
        browserSearch.setSearchButton();;
        browserSearch.fluentWait();
    }

    @After
    public void tearDown() {

        driver.close();
        driver.quit();

    }
}

