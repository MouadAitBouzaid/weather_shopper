package steps;

import configuration.DriverSetup;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import pages.WeatherShopperHomePage;

public class WeatherShopperHomeSteps {
    WebDriver driver = DriverSetup.getDriver();
    WeatherShopperHomePage weatherShopperHomePage = new WeatherShopperHomePage(driver);

   // @And("Based on hint text navigate to moisturizers or sunscreens shopping page")
    public void navigateToPageBasedOnTemperature() {
        weatherShopperHomePage.checkCurrentTemperaturePageTitle();
        int temperature = weatherShopperHomePage.getTemperature();
        if (temperature > 19) weatherShopperHomePage.clickSunscreensButton();
        else weatherShopperHomePage.clickMoisturizersButton();
    }

    @And("Je clique sur le bouton \"Buy moisturizers\"")
    public void clickOnBuymoisturizers() {
        weatherShopperHomePage.clickMoisturizersButton();
    }




}
