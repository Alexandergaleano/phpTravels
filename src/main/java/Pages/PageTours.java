package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageTours {
    private WebDriver driver;

    @FindBy(xpath  = "/html/body/div[2]/div[1]/div[1]/div[3]/div/div/div/div/div/nav/ul/li[3]/a")
    WebElement buttonTours;

    @FindBy(xpath  = "//*[@id=\"s2id_autogen8\"]/a")
    WebElement destination;

    @FindBy(xpath = "//*[@id=\"select2-drop\"]/div/input")
    WebElement TxtDestination;

    @FindBy(xpath = "//*[@id=\"select2-drop\"]/ul/li[1]/ul/li")
    WebElement selectDestination;

    @FindBy(id = "tourtype_chosen")
    WebElement tourType;

    @FindBy(xpath = "//*[@id=\"tourtype_chosen\"]/div/ul/li[3]")
    WebElement selectTourType;

    @FindBy(id = "DateTours")
    WebElement dateTours;

    @FindBy(xpath = "//*[@id=\"datepickers-container\"]/div[6]/nav/div[3]")
    WebElement nextMonth;

    @FindBy(xpath = "//*[@id=\"datepickers-container\"]/div[6]/div/div/div[2]/div[27]")
    WebElement selectDay;

    @FindBy(xpath = "//*[@id=\"tours\"]/div/div/form/div/div/div[3]/div/div/div/div/div/div/div[2]/div/div[2]/div/span/button[1]")
    WebElement buttonMaxAdults;

    @FindBy(xpath = "//*[@id=\"tours\"]/div/div/form/div/div/div[4]/button")
    WebElement buttonSearch;


    public PageTours(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickButtonTours(){
        clickOnElement(buttonTours);
    }
    public void clickDestination(){
        clickOnElement(destination);
    }
    public void sendDestination(String Destination){
        sendText(TxtDestination,Destination);
    }

     public void clickTourType(){
        clickOnElement(tourType);
    }

    public void clickSelectDestination(){
        clickOnElement(selectDestination);
    }
    public void clickSelectTourType(){
        clickOnElement(selectTourType);
    }

    public void clickDateTours(){
        clickOnElement(dateTours);
    }

    public void clickNextMonth(){
        clickOnElement(nextMonth);
    }

    public void clickSelectDay(){
        clickOnElement(selectDay);
    }

    public void clickbuttonMaxAdults(){
        clickOnElement(buttonMaxAdults);
    }

    public void clickbuttonSearch(){
        clickOnElement(buttonSearch);
    }

    public void clickOnElement(WebElement element){
        element.click();
    }

    public void sendText(WebElement element,String text){
        element.sendKeys(text);
    }
}
