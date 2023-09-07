package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private By Buy_moisturizers=By.linkText("Buy moisturizers");

    public void clickOnBuymoisturizers(){
        if(checkPage("Current temperature"))
        basePageDriver.findElement(Buy_moisturizers).click();
    }

}
