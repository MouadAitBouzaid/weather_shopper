package testCases;

import configTest.configuration;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.HomePage;
import pages.MoisturizersPage;

public class HomeTest extends configuration{

    WebDriver driver;

    public HomeTest(WebDriver driver) {
        super(driver);
    }



    @Test
    public void test1() throws InterruptedException{
        HomePage hp =new HomePage(driver);
        CheckoutPage cp = new CheckoutPage(driver);
        MoisturizersPage mp = new MoisturizersPage(driver);

        hp.clickOnBuymoisturizers();



    }

}
