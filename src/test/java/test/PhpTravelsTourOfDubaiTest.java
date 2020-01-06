package test;

import Pages.PageTourOfDubai;
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

public class PhpTravelsTourOfDubaiTest {


    String baseUrl = "https://www.phptravels.net/tours/united-arab-emirates/dubai/Big-Bus-Tour-of-Dubai?date=30/12/2019&adults=2";
    private WebDriver driver;

   @Before // preparacion de pruebas
    public void setUpChrome() throws Exception {
        ChromeOptions options = new ChromeOptions();
        System.setProperty ("webdriver.chrome.driver",Constants.PATHDRIVERCHROME+"chromedriver.exe");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);

    }

   /*   @Before // preparacion de pruebas
      public void setUpFirefox() throws Exception {
          FirefoxOptions options = new FirefoxOptions();
          System.setProperty ("webdriver.gecko.driver",Constants.PATHDRIVERFIREFOX+"geckodriver.exe");
          driver = new FirefoxDriver(options);
      }*/

    @Test // pruebas
    public void toursOfDubai()throws Exception {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get(baseUrl);
        Thread.sleep(5000);
        PageTourOfDubai pageTourOfDubai = new PageTourOfDubai(driver);
        js.executeScript ("window.scrollBy (0,300)");
        pageTourOfDubai.clickselectedInfants();
        pageTourOfDubai.clickselectInfant();
        pageTourOfDubai.clickWeb();
        pageTourOfDubai.clickButtonGOIti();
        pageTourOfDubai.clickButtonBookNow();
    }
    @After
    public void close() throws Exception {
        Thread.sleep(3000);
        driver.close();
    }
}
