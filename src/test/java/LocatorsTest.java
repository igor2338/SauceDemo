/*
 • id
 • name
 • classname
 • tagname
 • linktext
 • partiallinktext
 • xpath:
 - поиск по атрибуту, например By.xpath("//tag[@attribute='value']");
 - поиск по тексту, например By.xpath("//tag[text()='text']");
 - поиск по частичному совпадению атрибута, например
 By.xpath("//tag[contains(@attribute,'text')]");
 - поиск по частичному совпадению текста, например
 By.xpath("//tag[contains(text(),'text')]");
 - ancestor, например //*[text()='Enterprise Testing']//ancestor::div
 - descendant
 - following
 - parent
 - preceding
 - Подсказка: XPath Axes
 - *поиск элемента с условием AND, например
 //input[@class='_2zrpKA_1dBPDZ' and @type='text']
 • css:
 - .class
 - .class1.class2
 - .class1 .class2
 - #id
 - tagname
 - tagname.class
 - [attribute=value]
 - [attribute~=value]
 - [attribute|=value]
 - [attribute^=value]
 - [attribute$=value]
 - [attribute*=value]
 - Подсказка: https://www.w3schools.com/cssref/css_selectors.asp

 a. Залогиниться
 b. Добавить товар в корзину
 c. Перейти в корзину
 d. Проверить (assertEquals) стоимость товара и его имя в корзине
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.HashMap;

public class LocatorsTest {
    @Test
    public void test() {
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("credentials_enable_service", false);
        chromePrefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-infobars");
        SoftAssert softAssert = new SoftAssert();
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //здесь 1 часть ДЗ до поиска локаторов
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");//id
        driver.findElement(By.name("password")).sendKeys("secret_sauce");//name
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        //здесь ищу разные локаторы пока не перешел в корзину
        driver.findElement(By.tagName("noscript"));//tagName
        driver.findElement(By.linkText("Twitter"));//linkText
        driver.findElement(By.partialLinkText("itt"));//partialLinkText
        //xpath:
        driver.findElement(By.xpath("//link[@rel='apple-touch-icon']"));//поиск по атрибуту
        driver.findElement(By.xpath("//div[text()='Swag Labs']"));//поиск по тексту
        driver.findElement(By.xpath("//div[contains(@class,'_container')]"));//поиск по частичному совпадению атрибута
        driver.findElement(By.xpath("//div[contains(text(),'Sly Pack')]"));//поиск по частичному совпадению текста
        driver.findElement(By.xpath("//*[text()='© ']//ancestor::div[1]"));//ancestor
        driver.findElement(By.xpath("//nav[@class='bm-item-list']//descendant::a[2]"));//descendant
        driver.findElement(By.xpath("//div[@class='inventory_item']/following::*"));//following
        driver.findElement(By.xpath("//footer/ul/li/parent::ul"));//parent
        driver.findElement(By.xpath("//noscript[text()='You need to enable JavaScript to run this app.']/preceding::*"));//preceding
        driver.findElement(By.xpath("//img[@alt='Sauce Labs Bolt T-Shirt' and @class='inventory_item_img']"));//поиск элемента с условием AND
        //css:
        driver.findElement(By.cssSelector("#page_wrapper"));//id
        driver.findElement(By.cssSelector(".shopping_cart_badge"));//class
        driver.findElement(By.cssSelector("noscript"));//tagName
        driver.findElement(By.cssSelector("nav.bm-item-list"));//tagname.class
        driver.findElement(By.cssSelector("nav[style='height: 100%;']"));//[attribute=value] [lang="it"] выбирает все элементы с атрибутом lang="it"
        driver.findElement(By.cssSelector("nav[style~='100%;']"));//[attribute~=value] [title~="flower"] выбирает все элементы с атрибутом title, содержащим слово "flower"
        //[attribute|=value] [lang|="en"] выбирает все элементы со значением атрибута lang, равным "en" или начинающимся с "en-"
        driver.findElement(By.cssSelector("a[id*='logout']"));//[attribute^=value] [href^="https"] выбирает все элементы со значением атрибута href, которое начинается с "https"
        driver.findElement(By.cssSelector("div[class$='_logo']"));//[attribute$=value] [href$=".pdf"] выбирает все элементы, значение атрибута href которых заканчивается на ".pdf"
        driver.findElement(By.cssSelector("a[id*='reset_sidebar_link']"));//[attribute*=value] [href*="w3schools"] выбирает все элементы со значением атрибута href, содержащим подстроку «w3schools»
        //здесь 2 часть ДЗ перехожу в корзину и сравниваю товары и цены
        driver.findElement(By.className("shopping_cart_link")).click();//className
        WebElement webElement1 = driver.findElements(By.className("inventory_item_name")).get(0);
        String title1 = webElement1.getText();
        softAssert.assertEquals(title1, "Sauce Labs Backpack");
        WebElement webElement2 = driver.findElements(By.className("inventory_item_price")).get(0);
        String sale1 = webElement2.getText();
        softAssert.assertEquals(sale1, "$29.99");
        WebElement webElement3 = driver.findElements(By.className("inventory_item_name")).get(1);
        String title2 = webElement3.getText();
        softAssert.assertEquals(title2, "Sauce Labs Bike Light");
        WebElement webElement4 = driver.findElements(By.className("inventory_item_price")).get(1);
        String sale2 = webElement4.getText();
        softAssert.assertEquals(sale2, "$9.99");
        driver.quit();
        softAssert.assertAll();
    }
}
