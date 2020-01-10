package Pages;

import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class PageCheckData {
    private WebDriver driver;

    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement txtFirstName;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement txtLastName;

    @FindBy(xpath = "//input[@placeholder='Email']")
    WebElement txtEmail;

    @FindBy(xpath = "//input[@placeholder='Confirm Email']")
    WebElement txtConfirmEmail;

    @FindBy(xpath = "//input[@placeholder='Contact Number']")
    WebElement txtContactNumber;

    @FindBy(xpath = "//input[@placeholder='Address']")
    WebElement txtAddress;

    @FindBy(xpath = "//*[@id=\"guestform\"]/div[5]/div/div[2]")
    WebElement clickCountry;

    @FindBy(xpath = "//*[@id=\"cookyGotItBtnBox\"]/div/button")
    WebElement buttonGOIti;

    @FindBy(xpath = "//*[@id=\"guestform\"]/div[5]/div/div[2]/div/div/input")
    WebElement sendCountry;

    @FindBy(xpath = "//*[@id=\"guestform\"]/div[5]/div/div[2]/div/ul/li")
    WebElement slectCountry;

    @FindBy(id = "signintab")
    WebElement singIn;

    @FindBy(xpath = "//*[@id=\"username\"]")
    WebElement txtEmailPersonal;

    @FindBy(xpath = "//*[@id=\"password\"]")
    WebElement txtPassword;

    @FindBy(xpath = "//*[@id=\"bookingdetails\"]/div[7]/div/div/div/div[1]/div[1]/input")
    WebElement txtName;

    @FindBy(xpath = "//*[@id=\"bookingdetails\"]/div[7]/div/div/div/div[1]/div[2]/input")
    WebElement txtPassport;

    @FindBy(xpath = "//*[@id=\"bookingdetails\"]/div[7]/div/div/div/div[1]/div[3]/input")
    WebElement txtAge;

    @FindBy(xpath = "//*[@id=\"bookingdetails\"]/div[9]/button")
    WebElement clickButtonConfirm;

    @FindBy(xpath = "/html/body/div[2]/div[1]/div[1]/div/div/div[2]/center/button[1]")
    WebElement clickButtonPayOnArrival;


    public PageCheckData(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void sendFirstName(String firstname) {
        sendText(txtFirstName, firstname);
    }

    public void sendLastName(String Lastname) {
        sendText(txtLastName, Lastname);
    }

    public void sendEmail(String email) {
        sendText(txtEmail, email);
    }

    public void sendConfirmEmail(String confirmemail) {
        sendText(txtConfirmEmail, confirmemail);
    }

    public void sendContactNumber(String contactnumber) {
        sendText(txtContactNumber, contactnumber);
    }

    public void sendAddress(String address) {
        sendText(txtAddress, address);
    }

    public void clickCountry() {
        clickOnElement(clickCountry);
    }

    public void clickButtonGOIti() {
        clickOnElement(buttonGOIti);
    }

    public void sendCountry(String country) {
        sendText(sendCountry, country);
    }

    public void selectCountry() {
        clickOnElement(slectCountry);
    }

    public void clickButtonSingIn() {
        clickOnElement(singIn);
    }

    public void sendEmailPersonal(String email) {
        waitForElment(txtEmailPersonal);
        sendText(txtEmailPersonal, email);
    }

    public void sendPassword(String password) {
        waitForElment(txtPassword);
        sendText(txtPassword, password);
    }

    public void sendName(String name) {
        sendText(txtName, name);
    }

    public void sendPassport(String passport) {
        sendText(txtPassport, passport);
    }

    public void sendAge(String age) {
        sendText(txtAge, age);
    }

    public void clickButtonConfirm() {
        waitForElment(clickButtonConfirm);
        clickOnElement(clickButtonConfirm);
    }

    public void ClickButtonPayOnArrival() {
        waitForElment(clickButtonPayOnArrival);
        clickOnElement(clickButtonPayOnArrival);
    }

    public void clickOnElement(WebElement element) {
        element.click();
    }

    public void sendText(WebElement element, String text) {
        element.sendKeys(text);
    }

    public void waitForElment(WebElement element){

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }


}
