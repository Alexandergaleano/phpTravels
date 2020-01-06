package test;

import Pages.PageLogin;
import Pages.PageRegister;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import util.Constants;

public class PhpTravelsLoginTest {


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
    public void login()throws Exception {
        driver.get(baseUrl);
        Thread.sleep(5000);
        PageLogin pagelogin = new PageLogin (driver);
        Thread.sleep(5000);
        pagelogin.clickButtonMyAccount();
        Thread.sleep(2000);
        pagelogin.clickButtonLogin();
        Thread.sleep(2000);
        pagelogin.sendEmail("alexgaleanol34@hotmail.com");
        pagelogin.sendPassword("1234567899");
        pagelogin.clickButtonLoginUser();
    }

    @After
    public void close() throws Exception {
        Thread.sleep(5000);
        driver.close();
    }

}
