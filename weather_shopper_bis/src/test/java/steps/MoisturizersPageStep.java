package steps;

import configuration.DriverSetup;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import pages.MoisturizersPage;

public class MoisturizersPageStep {

    private WebDriver driver = DriverSetup.getDriver();
    MoisturizersPage mp = new MoisturizersPage(driver);

    @And("Je suis redirigé vers la page \"Moisturizers\"")
    public void checkCurrentMoisturizersPageTitle() {
        mp.checkCurrentMoisturizersPageTitle();
    }

    @And("Chaque produit est affiché avec son \"titre\" et son \"prix\"")
    public void checkingProductWithPrice() {
        mp.checkingProductWithPrice();
    }

    @And("J’ajoute le 1er produit à mon panier")
    public void addFirstProduct() {
        mp.addFirstProduct();
    }

    @And("Je clique sur \"carte\"")
    public void moveToCartClickw2() {
        mp.moveToCartClick();
    }

    @And("Je suis redirigé vers la page \"checkout\"")
    public void checkCurrentCheckoutTitle() {
        mp.checkCurrentCheckoutTitle();
    }

    @And("Je vérifie si le produit ajouté a le bon \"titre\", \"prix\", et \"total\"")
    public void checkProductOnCart() {
        mp.checkProductOnCart();
    }


}
