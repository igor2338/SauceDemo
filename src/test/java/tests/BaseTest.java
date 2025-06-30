package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import pages.*;

import java.time.Duration;
import java.util.HashMap;

public class BaseTest {
    WebDriver driver;
    SoftAssert softAssert;
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    CheckOutStepOnePage checkOutStepOnePage;
    CheckOutStepTwoPage checkOutStepTwoPage;

    @BeforeMethod
    public void setup() {
        softAssert = new SoftAssert();

        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("credentials_enable_service", false);
        chromePrefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-infobars");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        softAssert = new SoftAssert();
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        checkOutStepOnePage = new CheckOutStepOnePage(driver);
        checkOutStepTwoPage = new CheckOutStepTwoPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}