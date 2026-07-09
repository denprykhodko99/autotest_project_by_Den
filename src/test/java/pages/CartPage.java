package pages;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage {
    private WebDriver driver; // Объект браузера.
    private WebDriverWait wait; // Объект ожидания.

    // ЛОКАТОРЫ
    private By backpack = By.xpath("//div[text()='Sauce Labs Backpack']"); // Название товара Backpack.
    private By tShirt = By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']"); // Название товара T-Shirt.
    private By continueShoppingButton = By.id("continue-shopping"); // Кнопка Continue Shopping.
    private By removeBackpackButton = By.id("remove-sauce-labs-backpack"); // Кнопка Remove у Backpack.
    private By removetShirtButton = By.id("remove-sauce-labs-bolt-t-shirt"); // Кнопка Remove у Bike Light.
    private By checkout = By.id("checkout");
    /*
     * Конструктор класса.
     * При создании объекта CartPage передаем браузер и ожидание.
     */

    public CartPage(WebDriver driver, WebDriverWait wait){

        this.driver = driver; // Сохраняем браузер.

        this.wait = wait; // Сохраняем ожидание.

    }

    public void checkout() {
        Allure.step("Нажимаем Checkout");
        wait.until(ExpectedConditions.elementToBeClickable(checkout));
        driver.findElement(checkout).click();
    }

    /*

     * Проверка отображения Backpack в корзине.

     * Возвращает true, если товар найден.

     */

    public boolean isBackpackDisplayed(){
        Allure.step("Проверяем наличие Backpack в корзине");
        wait.until(ExpectedConditions.visibilityOfElementLocated(backpack));
        return driver.findElement(backpack).isDisplayed();
    }
    /*
     * Проверка отображения T-Shirt в корзине.
     * Возвращает true, если товар найден.
     */
    public boolean istShirtDisplayed(){
        Allure.step("Проверяем наличие T-Shirt в корзине");
        wait.until(ExpectedConditions.visibilityOfElementLocated(tShirt));
        return driver.findElement(tShirt).isDisplayed();
    }
    /*
     * Удаление Backpack из корзины.
     */
    public void removeBackpack(){
        Allure.step("Удаляем Backpack");
        wait.until(ExpectedConditions.elementToBeClickable(removeBackpackButton));
        driver.findElement(removeBackpackButton).click();
    }

    public boolean isBackpackPresent() {
        return driver.findElements(backpack).size() > 0;
    }
    /*
     * Удаление T-Shirt из корзины.
     */
    public void removetShirt(){
        Allure.step("Удаляем Bike Light");
        wait.until(ExpectedConditions.elementToBeClickable(removetShirtButton));
        driver.findElement(removetShirtButton).click();
    }

    /*
     * Возврат на страницу товаров.
     */

    public void continueShopping(){
        Allure.step("Нажимаем Continue Shopping");
        wait.until(ExpectedConditions.elementToBeClickable(continueShoppingButton));
        driver.findElement(continueShoppingButton).click();

    }
}
