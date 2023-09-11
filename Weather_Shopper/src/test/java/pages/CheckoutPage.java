package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.Commun;

public class CheckoutPage extends Commun {
    WebDriver driver;
    String expectedText = "Your payment was successful. You should receive a follow-up call from our sales team.";

    @FindBy(css = "#email")
    WebElement inputTextEmail;
    @FindBy(id = "card_number")
    WebElement inputTextCardNumber;
    @FindBy(id = "cc-exp")
    WebElement inputTextExpirationCard;
    @FindBy(id = "cc-csc")
    WebElement inputTextCvv;
    @FindBy(xpath = "//*[@id=\"submitButton\"]/span/span")
    WebElement BuyButton;
    @FindBy(xpath = "//p[text()='\" + expectedText + \"']")
    WebElement paragraphByText;
    @FindBy(xpath = "/html/body/div[1]/div[3]/form/button/span")
    WebElement payWithCard;
    @FindBy(className = "brandingLogoView")
    WebElement popupContent;
    @FindBy(className = "stripe_checkout_app")
    WebElement iframeElement;


    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

        // Initialisation des éléments après avoir reçu le driver
    }

    public void checkCurrentCheckoutPageTitle() {
        Assert.assertEquals(driver.getTitle(), "The Best Moisturizers in the World!");
    }

    public void clickOnPayWithCard(){
        waitForElementThenClick(driver,payWithCard);
    }

    public boolean checkingPopUp(){
        boolean isDisplayed = true;
        // Attendre que le popup apparaisse (ajoutez une attente explicite ici si nécessaire)
        // Changer de contexte vers l'iframe du popup
        driver.switchTo().frame(iframeElement);

              if (popupContent.isDisplayed()) {
                  Assert.assertTrue(isDisplayed);
                  return isDisplayed;
              }else{
                  isDisplayed= false;
                  Assert.assertTrue(isDisplayed);
                  return isDisplayed;
        }
    }

    public void checkout() {
        waitForElementToBeVisible(driver,inputTextCardNumber);
            if (checkingPopUp()) {
                inputTextEmail.sendKeys("aitbouzaid.mouad@gmail.com");
                inputTextCardNumber.sendKeys("5321962270415344");
                inputTextExpirationCard.sendKeys("0124");
                inputTextCvv.sendKeys("876");
                //verification de total
                if(BuyButton.getText().equals("Payer 128,00 INR ₹")){
                    BuyButton.click();
                    System.out.println("Le produit est acheter");

                        System.out.println("Je suis sur la page de confirmation");
                }else{
                    System.out.println("Erreur d'achat de produit !");
                }
                System.out.println("Le popup est affiché.");
            } else {
                System.out.println("Le popup n'est pas affiché.");
            }
    }

    public void messageSuccessVerification() {

            WebElement paragraphElement = paragraphByText;
            if (paragraphElement.equals(expectedText))
                System.out.println("Felicitaion, succes du payement");
            else
                System.out.println("le payement n'est pas effectuer");

    }

}
