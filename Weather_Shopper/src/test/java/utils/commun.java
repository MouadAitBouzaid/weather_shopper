package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Commun {


    public boolean checkPage(String titlePage, WebDriver driver){
        if(titlePage.equalsIgnoreCase(driver.getTitle())) {
            System.out.println("Correct La page est :"+ titlePage);
            return true;
        }else {
            System.out.println("incorrect La page est :"+ titlePage);
            return false;
        }
    }

    // Sélectionnez tous les éléments div contenant les produits
    public List<WebElement> addProductToList(WebDriver driver){
        List<WebElement> productDivs = driver.findElements(By.cssSelector("div.text-center.col-4"));

        for (WebElement productDiv : productDivs) {
            WebElement titleElement = productDiv.findElement(By.tagName("p"));
            WebElement priceElement = productDiv.findElement(By.xpath(".//p[last()]")); // Sélectionne le dernier élément p (le prix)
        }
        return productDivs;
    }

}
