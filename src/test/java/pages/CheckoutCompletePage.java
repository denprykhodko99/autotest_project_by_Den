package pages;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
/*
 * Эта страница появляется после успешного оформления заказа.
 */

public class CheckoutCompletePage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Локаторы
    private By successMessage = By.className("complete-header"); // Заголовок успешного оформления заказа.

    // Конструктор класса.
    public CheckoutCompletePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    /*
     * Получение тескта успешного завершения заказа.
     */
    public String getSuccessMessage() {
        Allure.step("Проверка сообщения об успешном заказе");
        // Ждём появления заголовка успеха.
        wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        return driver.findElement(successMessage).getText();
    }
}
