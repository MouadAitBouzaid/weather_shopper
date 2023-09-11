package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.Commun;

import java.util.List;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.xpath;

public class MoisturizersPage extends Commun {
    WebDriver driver;
    private String expectedItemText ;
    List<WebElement> productDivs;


    @FindBy(xpath="/html/body/div[1]/div[2]/div[1]/button")
    WebElement addButtonProduct;
    @FindBy(xpath="/html/body/nav/ul/button")
    WebElement goToCartButton;

    public MoisturizersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void checkCurrentMoisturizersPageTitle() {
        Assert.assertEquals(driver.getTitle(), "The Best Moisturizers in the World!");
    }

    public void checkCurrentCheckoutTitle() {
        Assert.assertEquals(driver.getTitle(), "Cart Items");
    }

    public  void getProduct(){
        productDivs = addProductToList(driver);
    }

    public void moveToCartClick(){
        waitForElementThenClick(driver,goToCartButton);
    }

    //remplacer les sout par des assert
    //les wait displayed or clicable pour les boutons

    public void checkingProductWithPrice(){
              boolean allProductsGotTitleAndPrice = true;
              getProduct();
            // Parcourez chaque div de produit et vérifiez si le titre et le prix existent
            for (WebElement productDiv : productDivs) {
                WebElement titleElement = productDiv.findElement(By.tagName("p"));
                WebElement priceElement = productDiv.findElement(By.xpath(".//p[last()]")); // Sélectionne le dernier élément p (le prix)
                // Vérifiez si le titre et le prix existent
                if (titleElement.isDisplayed() && priceElement.isDisplayed()) {
                    System.out.println("Le produit est correct : " + titleElement.getText() + " - " + priceElement.getText());
                } else {
                    System.out.println("Le produit est incorrect : " + titleElement.getText() + " - " + priceElement.getText());
                    allProductsGotTitleAndPrice = false;
                }
            }
            Assert.assertTrue(allProductsGotTitleAndPrice);
    }

    public void addFirstProduct(){
            // On verifie si la page remplie avec des produits
            getProduct();
            if (!productDivs.isEmpty()) {
                addButtonProduct = productDivs.get(0).findElement(xpath("/html/body/div[1]/div[2]/div[1]/button"));
                waitForElementThenClick(driver,addButtonProduct);
                expectedItemText = productDivs.get(0).getText();
                System.out.println("Le premier produit a été ajouté au panier.");
                Assert.assertTrue(true);
            } else {
                System.out.println("Aucun produit trouvé sur la page.");
                Assert.assertTrue(false);
            }
    }

    public void checkProductOnCart() {
            List<WebElement> cartItems = driver.findElements(cssSelector("table.table.table-striped tbody tr"));
            // Vérifiez d'abord si la liste n'est pas vide
            if (!cartItems.isEmpty()) {
                //  actualItemText = firstItemInCart.getText();
                System.out.println("Le premier élément dans le panier est bien ajouter : " + expectedItemText);
                Assert.assertTrue(true);
            }else {
                    System.out.println("Le panier est vide" );
                    Assert.assertTrue(false);
                }
    }





}
