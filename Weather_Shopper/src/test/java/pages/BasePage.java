package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BasePage {
    protected WebDriver basePageDriver;

    public BasePage(WebDriver driver){
        basePageDriver=driver;
    }

    public boolean checkPage(String titlePage){
        if(titlePage.equals(basePageDriver.getTitle())) {
            System.out.println("La page est :"+ titlePage);
            return true;
        }else {
            System.out.println("La page est :"+ titlePage);
            return false;
        }
    }

    // Sélectionnez tous les éléments div contenant les produits
    public List<WebElement> addProductToList(){
        List<WebElement> productDivs = basePageDriver.findElements(By.cssSelector("div.text-center.col-4"));

        for (WebElement productDiv : productDivs) {
            WebElement titleElement = productDiv.findElement(By.tagName("p"));
            WebElement priceElement = productDiv.findElement(By.xpath(".//p[last()]")); // Sélectionne le dernier élément p (le prix)
        }
        return productDivs;
    }

}