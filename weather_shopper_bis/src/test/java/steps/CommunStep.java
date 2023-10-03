package steps;

import configuration.DriverSetup;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import org.testng.Reporter;

public class CommunStep {
    @Before
    public void setupBrowser() {
        DriverSetup.loadProperties();
        DriverSetup.setUpBrowser();
    }

    @Given("Go To Home Page")
    public void goToHomePage() {
        DriverSetup.openUrl();
    }

    @After
    public void closeBrowser() {
        try {
            Thread.sleep(10000);
            Reporter.log("Closing The Driver", true);
            DriverSetup.getDriver().close();
            DriverSetup.getDriver().quit();
        } catch (Exception e) {
        }
    }
}
