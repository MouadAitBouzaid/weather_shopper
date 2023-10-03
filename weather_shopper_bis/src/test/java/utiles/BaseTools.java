package utiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BaseTools {
    int EXPLICIT_WAIT = 10;

    public void waitForElementThenClick(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void waitForElementToBeVisible(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public List<WebElement> addProductToList(WebDriver driver){
        List<WebElement> productDivs = driver.findElements(By.cssSelector("div.text-center.col-4"));

        for (WebElement productDiv : productDivs) {
            WebElement titleElement = productDiv.findElement(By.tagName("p"));
            WebElement priceElement = productDiv.findElement(By.xpath(".//p[last()]")); // Sélectionne le dernier élément p (le prix)
        }
        return productDivs;
    }
}
