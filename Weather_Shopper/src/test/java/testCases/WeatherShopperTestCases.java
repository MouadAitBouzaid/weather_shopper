package testCases;

import configTest.configuration;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.HomePage;
import pages.MoisturizersPage;

public class WeatherShopperTestCases extends configuration{

    @Test
    public void test1() throws InterruptedException{
        HomePage hp =new HomePage(driver);
        //Je check si je me suis bien redirigé vers la page Current temperature
        hp.checkCurrentMoisturizersPageTitle();
        //Je clique sur le bouton Buy moisturizers
        hp.clickOnBuymoisturizers();

        MoisturizersPage mp = new MoisturizersPage(driver);
        //Je check si je me suis redirigé vers la page Moisturizers
        mp.checkCurrentMoisturizersPageTitle();
        //Je check que chaque produit est affiché avec son titre et son prix
        mp.checkingProductWithPrice();
        //J’ajoute le 1er produit à mon panier
        mp.addFirstProduct();
        //Je clique sur carte
        mp.moveToCartClick();
        //Je check que je me suis redirigé vers la page checkout
        mp.checkCurrentCheckoutTitle();
        //Je check que le panier contient un item
        mp.checkProductOnCart();


        CheckoutPage cp = new CheckoutPage(driver);
        //Je clique sur le bouton Pay with card
        cp.clickOnPayWithCard();
        //Je check si la popup Stripe.com s’affiche
        cp.checkingPopUp();
        //Je saisis les informations nécessaires pour compléter l’achat (email, card number , date , cvc, zip code)
        cp.checkout();


    }

}
