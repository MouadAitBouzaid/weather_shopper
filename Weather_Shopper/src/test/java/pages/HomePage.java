package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Commun;


public class HomePage extends Commun {
    WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//button[text()='Buy moisturizers']")
    WebElement Buy_moisturizers;

    public void clickOnBuymoisturizers(){
        if(checkPage("Current Temperature",driver))
        Buy_moisturizers.click();
    }

}
