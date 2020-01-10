package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageTourOfDubai {
    private WebDriver driver;

    @FindBy(id = "selectedInfants")
    WebElement selectedInfants;

    @FindBy(xpath = "//*[@id=\"selectedInfants\"]/option[2]")
    WebElement selectInfant;

    @FindBy(xpath = "/html/body/div[2]/div/div/div[1]")
    WebElement clickWeb;

   @FindBy(xpath = "/html/body/div[2]/div/div/div[1]/div[4]/div/div[1]/aside/div/form/div/form/button")
    WebElement buttonBookNow;

    @FindBy(xpath = "//*[@id=\"cookyGotItBtnBox\"]/div/button")
    WebElement buttonGOIti;





    public PageTourOfDubai(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickselectedInfants(){
        clickOnElement(selectedInfants);
    }

   public void clickselectInfant(){
        clickOnElement(selectInfant);
    }
    public void clickWeb(){
        clickOnElement(clickWeb);
    }

    public void clickButtonBookNow(){
        clickOnElement(buttonBookNow);
    }
    public void clickButtonGOIti(){
        clickOnElement(buttonGOIti);
    }

    public void clickOnElement(WebElement element){
        element.click();
    }
}
