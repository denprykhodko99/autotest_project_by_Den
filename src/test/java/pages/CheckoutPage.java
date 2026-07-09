package pages;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {
    private WebDriver driver;
    private WebDriverWait wait;

    //ЛОКАТОРЫ
    private By firstNameField = By.id("first-name");
    private By lastNameField = By.id("last-name");
    private By postalCodeField = By.id("postal-code");
    private By continueButton = By.id("continue");
    private By finishButton = By.id("finish");

    //Конструктор класса.
    public CheckoutPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    /*
     * Заполнение формы checkout данными пользователя.
     */
    public void fillInformation(String firstName, String lastName,String postalCode) {
        Allure.step("Заполнение формы checkout данными пользователя");
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField)); // Ждем поле для имени.
        driver.findElement(firstNameField).sendKeys(firstName); // Вводим имя.
        driver.findElement(lastNameField).sendKeys(lastName); // Вводим фамилию.
        driver.findElement(postalCodeField).sendKeys(postalCode); // Вводим индекс.
        driver.findElement(continueButton).click(); // Нажимаем Continue.
    }

    /*
     * Завершение заказа.
     */
    public void finishOrder() {
        Allure.step("Завершение заказа");
        wait.until(ExpectedConditions.elementToBeClickable(finishButton)); // Ждем кнопку Finish.
        driver.findElement(finishButton).click(); // Жмем Finish.
    }
}
