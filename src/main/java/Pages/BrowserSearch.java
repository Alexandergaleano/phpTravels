package Pages;

import com.google.common.base.Function;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class BrowserSearch {
    private WebDriver driver;

    @FindBy(how = How.NAME, using = "q")
    WebElement searchBox;

    @FindBy(how = How.NAME, using = "btnK")
    WebElement searchButton;

    @FindBy(how = How.XPATH, using = "//*[@id=\"rso\"]/div[2]/div/div[1]/div/div/div[1]/a[1]/h3")
    WebElement linkText;

   /* @FindBy(how = How.LINK_TEXT, using = "Fluent - Wait")
    WebElement linkText;*/

    public BrowserSearch(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnElement(WebElement element) {
        element.click();
    }


    public void sendKeys(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    public void setSearchBox(String searchBox1) throws InterruptedException {

        sendKeys(searchBox, searchBox1);
        Thread.sleep(2000);
    }

    public void setSearchButton() {

        clickOnElement(searchButton);
    }

    public void fluentWait() {

        Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        WebElement webElement = fluentWait.until(new Function<WebDriver, WebElement>() {

            public WebElement apply(WebDriver driver) {
                WebElement linkElement = linkText;

                if (linkElement.isEnabled()) {

                    System.out.println("\n****El elemento fue encontrado con exito*****\n");
                    return linkElement;
                }
                return linkElement;
            }
        });
        clickOnElement(webElement);
    }
}

