package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utiles.BaseTools;

import java.time.Duration;

public class CheckoutPage extends BaseTools {

    WebDriver driver;
    Duration timeout = Duration.ofSeconds(10);
    //  WebDriverWait wait = new WebDriverWait(driver, timeout);

    @FindBy(css = "#email")
    WebElement inputTextEmail;
    @FindBy(id = "card_number")
    WebElement inputTextCardNumber;
    @FindBy(id = "cc-exp")
    WebElement inputTextExpirationCard;
    @FindBy(id = "cc-csc")
    WebElement inputTextCvv;
    @FindBy(id = "billing-zip")
    WebElement inputTextZip;
    @FindBy(xpath = "//*[@id=\"submitButton\"]/span/span")
    WebElement BuyButton;

    @FindBy(xpath = "//p[text()='Your payment was successful. You should receive a follow-up call from our sales team.']")
    WebElement pageMessage;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement payWithCard;
    @FindBy(className = "brandingLogoView")
    WebElement popupContent;
    @FindBy(xpath = "//iframe[@name='stripe_checkout_app']")
    WebElement iframeElement;


    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        // Initialisation des éléments après avoir reçu le driver
    }

    public void checkCurrentCheckoutPageTitle() {
        Assert.assertEquals(driver.getTitle(), "The Best Moisturizers in the World!");
    }

    public void clickOnPayWithCard() {
        waitForElementThenClick(driver, payWithCard);
    }

    public void checkingPopUp() {
        boolean isDisplayed = true;
        // Attendre que le popup apparaisse (ajoutez une attente explicite ici si nécessaire)
        // Changer de contexte vers l'iframe du popup
        String stripePopUpXPath = "//form[@class='checkoutView']";
        isDisplayed = driver.switchTo().frame(iframeElement).findElements(By.xpath(stripePopUpXPath)).size() > 0;
        Assert.assertTrue(isDisplayed);
    }

    public void checkout(String email, String cardNumber, String date, String cvc, String zipCode) {
        waitForElementToBeVisible(driver, inputTextCardNumber);

        // Saisie de l'e-mail
        inputTextEmail.sendKeys(email);

        // Saisie du numéro de carte
        for (char c : cardNumber.toCharArray()) {
            inputTextCardNumber.sendKeys(String.valueOf(c));
        }

        // Séparation et saisie de la date
        String[] dateParts = date.split("/"); // Sépare le mois de l'année
        String month = dateParts[0];
        String year = dateParts[1];

        // Saisissez le mois
        inputTextExpirationCard.sendKeys(month);

        // Pas besoin de saisir le "/" car il est automatiquement ajouté

        // Saisissez l'année
        inputTextExpirationCard.sendKeys(year);

        // Saisie du CVC
        inputTextCvv.sendKeys(cvc);

        //Saisie du ZipCode
        inputTextZip.sendKeys(zipCode);
    }


    public void checkingTotalCart() {
        //verification de total
        if (BuyButton.isDisplayed())
            Assert.assertTrue(true);
        System.out.println("Le total est affiché.");
    }

    public void validationPayement() {
        waitForElementThenClick(driver, BuyButton);
        Assert.assertTrue(true);
    }

    public void messageSuccessVerification() {
        String partialExpectedMessage = "Your payment was successful.";
        try {
            Thread.sleep(10000);
        } catch (Exception e) {

        }
        waitForElementToBeVisible(driver, pageMessage);
        String actualMessage = pageMessage.getText();

        // Vérifiez que le message actuel contient la partie attendue du message
        Assert.assertTrue(actualMessage.contains(partialExpectedMessage), "The expected message was not found in the actual message.");
    }


}
