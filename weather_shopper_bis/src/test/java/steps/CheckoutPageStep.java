package steps;

import configuration.DriverSetup;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import pages.CheckoutPage;

import java.util.List;
import java.util.Map;

public class CheckoutPageStep {

    private WebDriver driver = DriverSetup.getDriver();
    CheckoutPage cp = new CheckoutPage(driver);

    @And("Je clique sur le bouton \"Pay with card\"")
    public void clickOnPayWithCard() {
        cp.clickOnPayWithCard();
    }

    @And("Une popup \"Stripe.com\" s'affiche")
    public void checkingPopUp() {
        cp.checkingPopUp();
    }

    @And("Je saisis les informations nécessaires pour compléter l’achat")
    public void checkout(List<List<String>> tableData) {
        // Obtenir les données de la deuxième ligne, car la première ligne contient les en-têtes
        List<String> data = tableData.get(1);

        String email = data.get(0);
        String cardNumber = data.get(1);
        String date = data.get(2);
        String cvc = data.get(3);
        String zipCode = data.get(4);

        cp.checkout(email, cardNumber, date, cvc, zipCode);
    }

    @And("Je vérifie le total affiché sur le pop-up")
    public void checkingTotalCart() {
        cp.checkingTotalCart();
    }

    @And("Je clique sur le bouton \"pay\"")
    public void validationPayement() {
        cp.validationPayement();
    }

    @And("Je suis redirigé vers la page \"confirmation\"")
    public void redirectToConfirmationPage() {
        // ici une vérification de la redirection vers la page de confirmation si nécessaire
    }

    @And("Je devrais voir le message \"Your payment was successful. You should receive a follow-up call from our sales team\"")
    public void verifySuccessMessage() {
        cp.messageSuccessVerification();
    }
}
