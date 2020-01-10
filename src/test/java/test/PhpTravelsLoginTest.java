package test;

import Pages.PageLogin;
import Pages.PageRegister;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import util.Constants;

public class PhpTravelsLoginTest {


    String baseUrl = "https://www.phptravels.net/";
    private WebDriver driver;

  /*  @Before // preparacion de pruebas
    public void setUpChrome() throws Exception {
        ChromeOptions options = new ChromeOptions();
        System.setProperty ("webdriver.chrome.driver",Constants.PATHDRIVERCHROME+"chromedriver.exe");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);

    }*/

    @Before // preparacion de pruebas
    public void setUpFirefox() throws Exception {
        FirefoxOptions options = new FirefoxOptions();
        System.setProperty ("webdriver.gecko.driver", Constants.PATHDRIVERFIREFOX +"geckodriver.exe");
        driver = new FirefoxDriver(options);
    }

    @Test // pruebas
    public void login()throws Exception {
        driver.get(baseUrl);
        PageLogin pagelogin = new PageLogin (driver);
        pagelogin.clickButtonMyAccount();
        pagelogin.clickButtonLogin();
        pagelogin.sendEmail("alexgaleanol34@hotmail.com");
        pagelogin.sendPassword("1234567899");
        pagelogin.clickButtonLoginUser();
        Thread.sleep(2000);
        assertTrue(pagelogin.loginIsOk());
    }

    @After
    public void close() throws Exception {
        Thread.sleep(2000);
        driver.close();
    }

}
