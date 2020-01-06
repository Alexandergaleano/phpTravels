package test;

import Pages.PageLogin;
import Pages.PageTours;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import util.Constants;

public class PhpTravelsToursTest {

    String baseUrl = "https://www.phptravels.net/";
    private WebDriver driver;

    @Before // preparacion de pruebas
    public void setUpChrome() throws Exception {
        ChromeOptions options = new ChromeOptions();
        System.setProperty ("webdriver.chrome.driver",Constants.PATHDRIVERCHROME+"chromedriver.exe");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
    }

   /* @Before // preparacion de pruebas
    public void setUpFirefox() throws Exception {
        FirefoxOptions options = new FirefoxOptions();
        System.setProperty ("webdriver.gecko.driver", Constants.PATHDRIVERFIREFOX +"geckodriver.exe");
        driver = new FirefoxDriver(options);
    }*/

    @Test // pruebas
    public void Tours()throws Exception {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get(baseUrl);
        PageTours pageTours = new PageTours(driver);
        Thread.sleep(5000);
        js.executeScript ("window.scrollBy (0,100)");
        pageTours.clickButtonTours();
        Thread.sleep(2000);
        pageTours.clickDestination();
        pageTours.sendDestination("Big Bus Tour of Dubai");
        pageTours.clickSelectDestination();
        pageTours.clickTourType();
        pageTours.clickSelectTourType();
        pageTours.clickDateTours();
        pageTours.clickNextMonth();
        js.executeScript ("window.scrollBy (0,200)");
        pageTours.clickSelectDay();
        pageTours.clickbuttonMaxAdults();
        pageTours.clickbuttonSearch();
    }
    @After
    public void close() throws Exception {
        Thread.sleep(3000);
        driver.close();
    }

}

