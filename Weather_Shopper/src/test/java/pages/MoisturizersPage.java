package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MoisturizersPage extends BasePage{

    private String expectedItemText ;
    String expectedText = "Your payment was successful. You should receive a follow-up call from our sales team.";


    public MoisturizersPage(WebDriver driver) {
        super(driver);
    }

    public void checkingProductWithPrice(){
        if(checkPage("Moisturizers")) {
            //Appel a la methode ajouter produit a la liste
            List<WebElement> productDivs = addProductToList();

            // Parcourez chaque div de produit et vérifiez si le titre et le prix existent
            for (WebElement productDiv : productDivs) {
                WebElement titleElement = productDiv.findElement(By.tagName("p"));
                WebElement priceElement = productDiv.findElement(By.xpath(".//p[last()]")); // Sélectionne le dernier élément p (le prix)

                // Vérifiez si le titre et le prix existent
                if (titleElement.isDisplayed() && priceElement.isDisplayed()) {
                    System.out.println("Le produit est correct : " + titleElement.getText() + " - " + priceElement.getText());
                } else {
                    System.out.println("Le produit est incorrect : " + titleElement.getText() + " - " + priceElement.getText());
                }
            }
        }
    }

    public void addFirstProduct(){
        if(checkPage("The Best Moisturizers in the World!")) {
            //Appel a la methode ajouter produit a la liste
            List<WebElement> productDivs = addProductToList();
            // On verifie si la page remplie avec des produits
            if (!productDivs.isEmpty()) {
                WebElement firstProductAddButton = productDivs.get(0).findElement(By.cssSelector("button.btn.btn-primary"));
                firstProductAddButton.click();
                expectedItemText = productDivs.get(0).getText();
                System.out.println("Le premier produit a été ajouté au panier.");
            } else {
                System.out.println("Aucun produit trouvé sur la page.");
            }
        }
    }

    public void checkProductOnCart() {
        if(checkPage("Cart Items")) {
            WebElement goToCartButton = basePageDriver.findElement(By.xpath("/html/body/nav/ul/button"));
            goToCartButton.click();

            // Vérifiez d'abord si la liste n'est pas vide
            List<WebElement> cartItems = basePageDriver.findElements(By.cssSelector("table.table.table-striped tbody tr"));

            if (!cartItems.isEmpty()) {
                WebElement firstItemInCart = cartItems.get(0).findElement(By.cssSelector("td:first-child"));
                String actualItemText = firstItemInCart.getText();

                if (actualItemText.equals(expectedItemText)) {
                    System.out.println("Le premier élément dans le panier est correct : " + actualItemText);
                } else {
                    System.out.println("Le premier élément dans le panier n'est pas correct. Attendu : " + expectedItemText + ", Réel : " + actualItemText);
                }
            } else {
                System.out.println("Le panier est vide.");
            }
        }
    }





}