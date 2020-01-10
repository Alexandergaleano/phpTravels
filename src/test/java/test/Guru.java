package test;

import Pages.GuroPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import util.Constants;

public class Guru {
    String baseURL= "http://demo.guru99.com/test/guru99home/";
    private WebDriver driver;

    @Before
    public void setup(){

        System.setProperty("webdriver.chrome.driver", Constants.PATHDRIVERCHROME + "chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver();
    }
        @Test
        public void guru99tutorials() throws InterruptedException {
            driver.get(baseURL);
            String eTitle = "Demo Guru99 Page";
            String aTitle = "";
            aTitle = driver.getTitle();
            GuroPage guroPage = new GuroPage(driver);
            boolean elmentPresent = guroPage.fluentWait();
            assertTrue(elmentPresent);
            assertEquals(eTitle,aTitle);
        }

    @After
    public void tearDown() {
        driver.close();
    }
}

