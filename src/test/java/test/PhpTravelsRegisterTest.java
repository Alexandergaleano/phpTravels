package test;

import Pages.PageRegister;
import com.github.javafaker.Faker;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import util.Constants;

import java.util.concurrent.TimeUnit;

public class PhpTravelsRegisterTest {

   private String FIRSTNAME;
   private String LASTNAME;
   private String PHONENUMBER;
   private String EMAIL;

    String baseUrl = "https://www.phptravels.net/";
    private WebDriver driver;

    @Before // preparacion de pruebas
    public void setUpChrome() throws Exception {
        Faker faker = new Faker();
        FIRSTNAME = faker.firstName();
        LASTNAME = faker.lastName();
        PHONENUMBER = faker.phoneNumber();
        EMAIL = faker.firstName()+"@gmail.com";
        ChromeOptions options = new ChromeOptions();
        System.setProperty ("webdriver.chrome.driver", Constants.PATHDRIVERCHROME +"chromedriver.exe");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


     /* @Before // preparacion de pruebas
      public void setUpFirefox() throws Exception {
          Faker faker = new Faker();
          FIRSTNAME = faker.firstName();
          LASTNAME = faker.lastName();
          PHONENUMBER = faker.phoneNumber();
          EMAIL = faker.firstName()+"@gmail.com";
          FirefoxOptions options = new FirefoxOptions();
          System.setProperty ("webdriver.gecko.driver",Constants.PATHDRIVERFIREFOX+"geckodriver.exe");
          driver = new FirefoxDriver(options);
      }*/

    @Test // pruebas
    public void singUp()throws Exception {
        driver.get(baseUrl);
        PageRegister pageRegister = new PageRegister (driver);
        pageRegister.clickButtonMyAccount();
        pageRegister.clickButtonSingUp();
        pageRegister.sendFirstName(FIRSTNAME);
        pageRegister.sendLastName(LASTNAME);
        pageRegister.sendMobileNumber(PHONENUMBER);
        pageRegister.sendEmail("alexgaleanol34@hotmail.com");
        pageRegister.sendPassword("1234567899");
        pageRegister.sendConfirmPassword("1234567899");
        pageRegister.clickButtonGOIti();
        pageRegister.clickButtonRegister();
        Thread.sleep(2000);
        assertTrue(pageRegister.isAlertEmailPresent());

    }
    @After
    public void close() throws Exception {
        Thread.sleep(2000);
        driver.close();
    }
}
