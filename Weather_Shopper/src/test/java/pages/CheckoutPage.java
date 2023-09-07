package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage extends BasePage{

    String expectedText = "Your payment was successful. You should receive a follow-up call from our sales team.";

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    private WebElement inputTextEmail = basePageDriver.findElement(By.cssSelector("#email"));
    private WebElement inputTextCardNumber = basePageDriver.findElement(By.id("card_number"));
    private WebElement inputTextExpirationCard = basePageDriver.findElement(By.id("cc-exp"));
    private WebElement inputTextCvv = basePageDriver.findElement(By.id("cc-csc"));
    private By BuyButton=By.xpath("//*[@id=\"submitButton\"]/span/span");
    private By paragraphByText = By.xpath("//p[text()='" + expectedText + "']");

    public void checkout() {
        if (checkPage("Cart Items")) {
            WebElement payWithCard = basePageDriver.findElement(By.linkText("Pay with Card"));
            payWithCard.click();

            // Attendre que le popup apparaisse (ajoutez une attente explicite ici si nécessaire)

            // Changer de contexte vers l'iframe du popup
            WebElement iframeElement = basePageDriver.findElement(By.className("stripe_checkout_app"));
            basePageDriver.switchTo().frame(iframeElement);

            // Maintenant, vous pouvez vérifier si le contenu du popup est affiché
            WebElement popupContent = basePageDriver.findElement(By.cssSelector("div.v-accordion__content"));

            if (popupContent.isDisplayed()) {
                inputTextEmail.sendKeys("aitbouzaid.mouad@gmail.com");
                inputTextCardNumber.sendKeys("5321962270415344");
                inputTextExpirationCard.sendKeys("0124");
                inputTextCvv.sendKeys("876");
                //verification de total
                if(basePageDriver.findElement(BuyButton).getText().equals("Payer 128,00 INR ₹")){
                    basePageDriver.findElement(BuyButton).click();
                    System.out.println("Le produit est acheter");
                    if (checkPage("Confirmation" ))
                        System.out.println("Je suis sur la page de confirmation");
                }else{
                    System.out.println("Erreur d'achat de produit !");
                }
                System.out.println("Le popup est affiché.");
            } else {
                System.out.println("Le popup n'est pas affiché.");
            }
            // Pour revenir au contexte par défaut (en dehors de l'iframe)
            //  basePageDriver.switchTo().defaultContent();
        }
    }

    public void messageSuccessVerification() {
        if (checkPage("Confirmation")) {
            WebElement paragraphElement = basePageDriver.findElement(paragraphByText);
            if (paragraphElement.equals(expectedText))
                System.out.println("Felicitaion, succes du payement");
            else
                System.out.println("le payement n'est pas effectuer");
        }
    }

}
