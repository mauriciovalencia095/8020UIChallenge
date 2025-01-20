package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class Waits {

    public  static final Duration time = Duration.ofSeconds(180);

    public static Wait<WebDriver> explicitWaitExpectedConditionsVisibility (WebDriver driver, WebElement element){
        WebDriverWait wait  = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOf(element));
        return wait;
    }

    public static WebElement explicitWaitExpectedConditionsVisibility (WebDriver driver, String xpath){
        WebDriverWait wait  = new WebDriverWait(driver, time);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }
    public static void explicitWaitExpectedConditionsVisibilityList (WebDriver driver, List<WebElement> list){
        WebDriverWait wait  = new WebDriverWait(driver, time);
        wait.until((ExpectedConditions.visibilityOfAllElements(list)));
    }

    public static List<WebElement> explicitWaitExpectedConditionsVisibilityListLocatedBy (WebDriver driver, String xpath){
        WebDriverWait wait  = new WebDriverWait(driver, time);
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath)));
    }

    public static Wait<WebDriver> explicitWaitExpectedConditionsClickable (WebDriver driver, WebElement element){
        WebDriverWait wait  = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return wait;
    }

    public static Wait<WebDriver> explicitWaitExpectedConditionsTextPresent (WebDriver driver, WebElement element, String text){
        WebDriverWait wait  = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.textToBePresentInElement(element,text));
        return wait;
    }




}