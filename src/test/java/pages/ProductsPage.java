package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductsPage extends BasePage {
    public final By TITLE = By.xpath("//span[text()='Products']");
    public final By PRODUCTS = By.xpath("//button[contains(@class,'btn btn_primary btn_small btn_inventory')]");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие страницы Корзина")
    @Override
    public ProductsPage open() {
        driver.get(BASE_URL + "inventory.html");
        return this;
    }

    @Step("Отображение элемента на странице Корзина")
    @Override
    public ProductsPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE));
        return this;
    }

    @Override
    public BasePage isElement() {
        return null;
    }

    @Override
    public BasePage removeProduct() {
        return null;
    }

    public void addProduct() {
        driver.findElement(PRODUCTS).click();
    }
}