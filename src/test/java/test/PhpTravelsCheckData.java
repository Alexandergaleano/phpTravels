package test;

import Pages.PageCheckData;
import Pages.PageTourOfDubai;
import com.github.javafaker.Faker;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import util.Constants;

import java.util.List;

public class PhpTravelsCheckData {

    private String FIRSTNAME;
    private String SECONDFIRSTNAME;
    private String LASTNAME;
    private String EMAIL;
    private String PHONENUMBER;
    private String ADDRESS;
    private String PASSPORT;


    String baseUrl = "https://www.phptravels.net/tours/book/Big-Bus-Tour-of-Dubai?date=30%2F12%2F2019&adults=2&child=0&infant=1";
    private WebDriver driver;

    @Before // preparacion de pruebas
    public void setUpChrome() throws Exception {
        Faker faker = new Faker();
        FIRSTNAME = faker.firstName();
        SECONDFIRSTNAME = faker.firstName();
        LASTNAME = faker.lastName();
        PHONENUMBER = faker.phoneNumber();
        ADDRESS = faker.secondaryAddress();
        EMAIL = faker.firstName()+"@gmail.com";
        PASSPORT = faker.numerify(String.valueOf(123456789));
        ChromeOptions options = new ChromeOptions();
        System.setProperty ("webdriver.chrome.driver", Constants.PATHDRIVERCHROME +"chromedriver.exe");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);

    }

/*    @Before // preparacion de pruebas
    public void setUpFirefox() throws Exception {
        Faker faker = new Faker();
        FIRSTNAME = faker.firstName();
        SECONDFIRSTNAME = faker.firstName();
        LASTNAME = faker.lastName();
        PHONENUMBER = faker.phoneNumber();
        ADDRESS = faker.secondaryAddress();
        EMAIL = faker.firstName()+"@gmail.com";
        PASSPORT = faker.numerify(String.valueOf(123456789));
        FirefoxOptions options = new FirefoxOptions();
        System.setProperty ("webdriver.gecko.driver",Constants.PATHDRIVERFIREFOX+"geckodriver.exe");
        driver = new FirefoxDriver(options);
    }*/

    @Test // pruebas
    public void guests()throws Exception {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get(baseUrl);
        PageCheckData pageCheckData = new PageCheckData(driver);
        pageCheckData.sendFirstName(FIRSTNAME);
        pageCheckData.sendLastName(LASTNAME);
        pageCheckData.sendEmail(EMAIL);
        pageCheckData.sendConfirmEmail(EMAIL);
        pageCheckData.sendContactNumber(PHONENUMBER);
        pageCheckData.sendAddress(ADDRESS);
        pageCheckData.clickButtonGOIti();
        js.executeScript ("window.scrollBy (0,300)");
        pageCheckData.clickCountry();
        pageCheckData.sendCountry("Colombia");
        pageCheckData.selectCountry();
        js.executeScript ("window.scrollBy (0,1000)");
        pageCheckData.sendName(SECONDFIRSTNAME);
        pageCheckData.sendPassport(PASSPORT);
        pageCheckData.sendAge("26");
        js.executeScript ("window.scrollBy (0,400)");
        Thread.sleep(2000);
        pageCheckData.clickButtonConfirm();
        Thread.sleep(10000);
        pageCheckData.ClickButtonPayOnArrival();
        Alert alert = driver.switchTo().alert();
        alert.accept();
}

    @Test // pruebas
    public void singIn()throws Exception {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get(baseUrl);
        PageCheckData pageCheckData = new PageCheckData(driver);
        pageCheckData.clickButtonSingIn();
        Thread.sleep(1000);
        js.executeScript ("window.scrollBy (0,300)");
        pageCheckData.sendEmailPersonal("alexgaleanol34@hotmail.com");
        Thread.sleep(1000);
        pageCheckData.sendPassword("1234567899");
        pageCheckData.sendName(FIRSTNAME);
        pageCheckData.sendPassport(PASSPORT);
        pageCheckData.sendAge("26");
        js.executeScript ("window.scrollBy (0,200)");
        pageCheckData.clickButtonGOIti();
        pageCheckData.clickButtonConfirm();
        Thread.sleep(10000);
        pageCheckData.ClickButtonPayOnArrival();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    @After
    public void close() throws Exception {
        Thread.sleep(5000);
        driver.close();
    }

}
