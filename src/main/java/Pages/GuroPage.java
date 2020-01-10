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

public class GuroPage {
    private WebDriver driver;

    @FindBy(how = How.XPATH, using = "//*[@id=\"navbar-brand-centered\"]/ul/li[1]/a")
    WebElement fail;

   /* @FindBy(how = How.XPATH, using = " //*[@id=\"navbar-brand-centered\"]/ul/li[100]/a")
    WebElement fail;*/

    public GuroPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean fluentWait() {

        Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        WebElement element = fluentWait.until(new Function<WebDriver, WebElement>() {

            public WebElement apply(WebDriver driver) {
                WebElement linkElement = fail;
                if (linkElement.isDisplayed()) {
                    return linkElement; // encuentra
                }
                return linkElement; // no lo encuentra
            }
        });
       return element.isDisplayed();


    }
}


