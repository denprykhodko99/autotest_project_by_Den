package pages;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InventoryPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // ЛОКАТОРЫ
    private By backpackButton = By.id("add-to-cart-sauce-labs-backpack"); // Кнопка добавления рюкзака.

    private By tShirtButton = By.id("add-to-cart-sauce-labs-bolt-t-shirt");

    private By cartButton = By.className("shopping_cart_link"); // Значок корзины.

    private By cartBadgeCount = By.className("shopping_cart_badge"); // Счетчик товаров в корзине.


    public InventoryPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver; // Сохраняем браузер.
        this.wait = wait; // Сохраняем ожидание.
    }

    /*
     * Добавление рюкзака в корзину.
     */
    public void addBackpackToCart(){
        Allure.step("Добавление рюкзака в корзину");
        wait.until(ExpectedConditions.elementToBeClickable(backpackButton));
        driver.findElement(backpackButton).click(); //Нажимаем добавить в корзину.
    }

    /*
     * Добавление фонаря в корзину.
     */
    public void addtShirtToCart(){
        Allure.step("Добавление фонаря в корзину");
        wait.until(ExpectedConditions.elementToBeClickable(tShirtButton));
        driver.findElement(tShirtButton).click(); //Нажимаем добавить в корзину.
    }

    /*
     * Открытие корзины.
     */
    public void openCart(){
        Allure.step("Открытие корзины");
        wait.until(ExpectedConditions.elementToBeClickable(cartButton));
        driver.findElement(cartButton).click();
    }
    /*
     * Получение количества товаров в корзине.
     */
    public String getCartBadge(){
        Allure.step("Получение количества товаров в корзине");
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartBadgeCount));
        return driver.findElement(cartBadgeCount).getText();
    }
    /*
     * Проверка Url, что пользователь находится на странице Products (inventory).
     */
    public boolean isInventoryPageDisplayed(){
        return driver.getCurrentUrl().contains("inventory");

    }
}
