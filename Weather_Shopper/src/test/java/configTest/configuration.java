package configTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class configuration {
    public static WebDriver driver;


    @BeforeClass
    public void open_browser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\moaitbou\\IdeaProjects\\TestingPractice\\Weather_Shopper\\src\\main\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        //Lancer un navigateur chrome
        //Ouvrez le site Web https://www.lambdatest.com
        driver.get("https://weathershopper.pythonanywhere.com/");
        driver.manage().window().maximize();
    }

 //   @AfterClass
    public void close_broser() {
        try {
            Thread.sleep(10000);
        } catch (Exception e) {
        }
        driver.close();

    }
}
