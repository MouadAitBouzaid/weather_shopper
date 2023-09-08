package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.Commun;

public class CheckoutPage extends Commun {

    String expectedText = "Your payment was successful. You should receive a follow-up call from our sales team.";

    WebDriver driver;
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    private WebElement inputTextEmail = driver.findElement(By.cssSelector("#email"));
    private WebElement inputTextCardNumber = driver.findElement(By.id("card_number"));
    private WebElement inputTextExpirationCard = driver.findElement(By.id("cc-exp"));
    private WebElement inputTextCvv = driver.findElement(By.id("cc-csc"));
    private By BuyButton=By.xpath("//*[@id=\"submitButton\"]/span/span");
    private By paragraphByText = By.xpath("//p[text()='" + expectedText + "']");

    public void checkout() {
        if (checkPage("Cart Items",driver)) {
            WebElement payWithCard = driver.findElement(By.linkText("Pay with Card"));
            payWithCard.click();

            // Attendre que le popup apparaisse (ajoutez une attente explicite ici si nécessaire)

            // Changer de contexte vers l'iframe du popup
            WebElement iframeElement = driver.findElement(By.className("stripe_checkout_app"));
            driver.switchTo().frame(iframeElement);

            // Maintenant, vous pouvez vérifier si le contenu du popup est affiché
            WebElement popupContent = driver.findElement(By.cssSelector("div.v-accordion__content"));

            if (popupContent.isDisplayed()) {
                inputTextEmail.sendKeys("aitbouzaid.mouad@gmail.com");
                inputTextCardNumber.sendKeys("5321962270415344");
                inputTextExpirationCard.sendKeys("0124");
                inputTextCvv.sendKeys("876");
                //verification de total
                if(driver.findElement(BuyButton).getText().equals("Payer 128,00 INR ₹")){
                    driver.findElement(BuyButton).click();
                    System.out.println("Le produit est acheter");
                    if (checkPage("Confirmation", driver ))
                        System.out.println("Je suis sur la page de confirmation");
                }else{
                    System.out.println("Erreur d'achat de produit !");
                }
                System.out.println("Le popup est affiché.");
            } else {
                System.out.println("Le popup n'est pas affiché.");
            }
            // Pour revenir au contexte par défaut (en dehors de l'iframe)
            //  driver.switchTo().defaultContent();
        }
    }

    public void messageSuccessVerification() {
        if (checkPage("Confirmation",driver)) {
            WebElement paragraphElement = driver.findElement(paragraphByText);
            if (paragraphElement.equals(expectedText))
                System.out.println("Felicitaion, succes du payement");
            else
                System.out.println("le payement n'est pas effectuer");
        }
    }

}
