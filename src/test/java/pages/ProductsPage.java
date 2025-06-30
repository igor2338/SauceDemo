package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {
    public final By TITLE = By.xpath("//span[text()='Products']");
    public final By PRODUCTS = By.xpath("//button[contains(@class,'btn btn_primary btn_small btn_inventory')]");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL + "inventory.html");
    }

    public boolean isPageOpened() {
        return driver.findElement(TITLE).isDisplayed();
    }

    public void addProduct() {
        driver.findElement(PRODUCTS).click();
    }
}