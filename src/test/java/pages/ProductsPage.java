package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class ProductsPage extends BasePage {
    public final By TITLE = By.xpath("//span[text()='Products']");
    public final By PRODUCTS = By.xpath("//button[contains(@class,'btn btn_primary btn_small btn_inventory')]");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие страницы Корзина")
    @Override
    public ProductsPage open() {
        log.info("Products Cart page");
        driver.get(BASE_URL + "inventory.html");
        return this;
    }

    @Step("Отображение элемента на странице Корзина")
    @Override
    public ProductsPage isPageOpened() {
        log.info("Products page is opened");
        wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE));
        return this;
    }

    @Step("Добавление элемента в Корзину")
    public void addProduct() {
        log.info("Added product to Cart");
        driver.findElement(PRODUCTS).click();
    }
}