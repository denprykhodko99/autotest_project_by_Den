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
    private By backpack = By.id("add-to-cart-sauce-labs-backpack"); // Кнопка добавления рюкзака.

    private By bikeLight = By.id("add-to-cart-sauce-labs-bike-light");

    private By cartButton = By.className("shopping_cart_link"); // Значок корзины.

    private By cartBadge = By.className("shopping_cart_badge"); // Счетчик товаров в корзине.

    private By burgerMenuButton = By.id("react-burger-menu-btn"); // Кнопка открытия бокового меню.

    private By logout = By.id("logout_sidebar_link"); // Кнопка Logout.

    private By title = By.className("title"); // Заголовок страницы Products.

    private By sortDropdown = By.className("product_sort_container"); // Выпадающий список сортировки.



    public InventoryPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver; // Сохраняем браузер.
        this.wait = wait; // Сохраняем ожидание.
    }

    /*
     * Добавление рюкзака в корзину.
     */
    public void addBackpackToCart(){
        Allure.step("Добавление рюкзака в корзину");
        wait.until(ExpectedConditions.elementToBeClickable(backpack));
        driver.findElement(backpack).click(); //Нажимаем добавить в корзину.
    }

    /*
     * Добавление фонаря в корзину.
     */
    public void addBikeLightToCart(){
        Allure.step("Добавление фонаря в корзину");
        wait.until(ExpectedConditions.elementToBeClickable(bikeLight));
        driver.findElement(bikeLight).click(); //Нажимаем добавить в корзину.
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
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartBadge));
        return driver.findElement(cartBadge).getText();
    }
    /*
     * Выход из аккакунта
     */
    public void logout(){
        Allure.step("Выход из аккаунта");
        wait.until(ExpectedConditions.elementToBeClickable(burgerMenuButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(logout));
        driver.findElement(logout).click();
    }
    /*
     * Получение названия страницы
     */
    public String getTitle(){
        return driver.findElement(title).getText();
    }
    /*
     * Проверка Url, что пользователь находится на странице Products (inventory).
     */
    public boolean isInventoryPageDisplayed(){
        return driver.getCurrentUrl().contains("inventory");

    }
}
