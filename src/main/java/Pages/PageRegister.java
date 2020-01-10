package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageRegister {
    private WebDriver driver;

    @FindBy(xpath  = "//*[@id=\"header-waypoint-sticky\"]/div[1]/div/div/div[2]/div/ul/li[3]/div//*[@id=\"dropdownCurrency\"]")
    WebElement buttonMyAccount;

    @FindBy(linkText = "Sign Up")
    WebElement buttonSingUp;

    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement txtFirstName;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement txtLastName;

    @FindBy(xpath = "//input[@placeholder='Mobile Number']")
    WebElement txtMobileNumber;

    @FindBy(xpath = "//input[@placeholder='Email']")
    WebElement txtEmail;

    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement txtPassword;

    @FindBy(xpath= "//input[@placeholder='Confirm Password']")
    WebElement txtConfirmPassword;

    @FindBy(xpath = "//*[@id=\"cookyGotItBtnBox\"]/div/button")
    WebElement buttonGOIti;

    @FindBy(xpath= "//*[@id=\"headersignupform\"]/div[9]/button")
    WebElement clickSingUp;

    @FindBy(xpath= "//*[@id=\"headersignupform\"]/div[2]/div")
    WebElement alertEmail;



    public PageRegister(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickButtonMyAccount(){
        waitForElment(buttonMyAccount);
        clickOnElement(buttonMyAccount);
    }
    public void clickButtonSingUp(){
        waitForElment(buttonSingUp);
        clickOnElement(buttonSingUp);
    }
    public void sendFirstName(String firstName){
        sendText(txtFirstName,firstName);
    }
    public void sendLastName(String lastName){
        sendText(txtLastName,lastName);
    }
    public void sendMobileNumber(String mobileNumber){
        sendText(txtMobileNumber,mobileNumber);
    }
    public void sendEmail(String email){
        sendText(txtEmail,email);
    }
    public void sendPassword(String password){
        sendText(txtPassword,password);
    }
    public void sendConfirmPassword(String confirmPassword){
        sendText(txtConfirmPassword,confirmPassword);
    }
    public void clickButtonGOIti(){
        waitForElment(buttonGOIti);
        clickOnElement(buttonGOIti);
    }
    public void clickButtonRegister(){
        clickOnElement(clickSingUp);
    }

    public boolean isAlertEmailPresent(){

        return alertEmail.isDisplayed();
    }

    public void waitForElment(WebElement element){

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void clickOnElement(WebElement element){
        element.click();
    }

    public void sendText(WebElement element,String text){
        element.sendKeys(text);
    }

}
