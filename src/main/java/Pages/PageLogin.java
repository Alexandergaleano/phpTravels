package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageLogin {
    private WebDriver driver;

    @FindBy(xpath  = "//*[@id=\"header-waypoint-sticky\"]/div[1]/div/div/div[2]/div/ul/li[3]/div//*[@id=\"dropdownCurrency\"]")
    WebElement buttonMyAccount;

    @FindBy(linkText = "Login")
    WebElement buttonLogin;

    @FindBy(xpath = "//input[@placeholder='Email']")
    WebElement txtEmail;

    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement txtPassword;

    @FindBy(xpath= "//*[@id=\"loginfrm\"]/button")
    WebElement clickLogin;

    @FindBy(xpath= "//*[@id=\"bookings\"]/h4/strong")
    WebElement loginOk;



    public PageLogin(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void waitForElment(WebElement element){

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void clickButtonMyAccount(){
        waitForElment(buttonMyAccount);
        clickOnElement(buttonMyAccount);
    }

    public void clickButtonLogin(){
        waitForElment(buttonLogin);
        clickOnElement(buttonLogin);
    }

    public void sendEmail(String email){
        waitForElment(txtEmail);
        sendText(txtEmail,email);
    }
    public void sendPassword(String password){
        sendText(txtPassword,password);
    }
    public void clickButtonLoginUser(){
        clickOnElement(clickLogin);
    }

    public boolean loginIsOk(){
        return loginOk.isDisplayed();
    }


    public void clickOnElement(WebElement element){
        element.click();
    }

    public void sendText(WebElement element,String text){
        element.sendKeys(text);
    }
}

