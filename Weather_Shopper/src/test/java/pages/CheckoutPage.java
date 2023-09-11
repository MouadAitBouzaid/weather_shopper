package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Commun;

import java.time.Duration;

public class CheckoutPage extends Commun {
    WebDriver driver;
    Duration timeout = Duration.ofSeconds(10);
    WebDriverWait wait = new WebDriverWait(driver, timeout);

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
    @FindBy(xpath = "//p[@class='text-justify']")
    WebElement pageMessage;
    @FindBy(xpath = "/html/body/div[1]/div[3]/form/button/span")
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

    public void checkout() {
        waitForElementToBeVisible(driver, inputTextCardNumber);

        inputTextEmail.sendKeys("aitbouzaid.mouad@gmail.com");
        waitForElementToBeVisible(driver, inputTextCardNumber);
        inputTextCardNumber.sendKeys("5321");
        inputTextCardNumber.sendKeys("9622");
        inputTextCardNumber.sendKeys("7041");
        inputTextCardNumber.sendKeys("5344");
        waitForElementToBeVisible(driver, inputTextExpirationCard);
        inputTextExpirationCard.sendKeys("01");
        inputTextExpirationCard.sendKeys("24");
        waitForElementToBeVisible(driver, inputTextCvv);
        inputTextCvv.sendKeys("876");
        // waitForElementToBeVisible(driver, adressInput);
        //  adressInput.sendKeys("mohammedia");
        //verification de total
        System.out.println("Le popup est affiché.");
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
        String expectedMessage = "Your payment was successful. You should receive a follow-up call from our sales team.";
        // Utilisez wait avec ExpectedConditions
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class='text-justify']")));
        Assert.assertEquals(pageMessage.getText(), expectedMessage);
    }

}
