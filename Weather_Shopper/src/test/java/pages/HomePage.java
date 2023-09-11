package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.Commun;


public class HomePage extends Commun {
    WebDriver driver;
    @FindBy(xpath = "//button[text()='Buy moisturizers']")
    WebElement Buy_moisturizers;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void checkCurrentMoisturizersPageTitle() {
        Assert.assertEquals(driver.getTitle(), "Current Temperature");
    }

    public void clickOnBuymoisturizers() {
        waitForElementThenClick(driver, Buy_moisturizers);
    }

}
