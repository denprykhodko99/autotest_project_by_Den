package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    @Test(description = "Успішний вхід в систему")
    public void validLoginTest(){
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.login("standard_user","secret_sauce");
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
    }
    @Test(description = "Невірний логін")
    public void invertLoginTest(){
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.login("wrong_user","secret_sauce");
        Assert.assertTrue(loginPage.getErrorText().contains("Username"));

    }
    @Test(description = "Логін з пустими полями")
    public void emptyLoginTest() {
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.login("", "");
        Assert.assertTrue(loginPage.getErrorText().contains("Username"));

    }
    @Test(description = "Логін без паролю")
    public void emptyPasswordTest() {
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.login("standard_user", "");
        Assert.assertTrue(loginPage.getErrorText().contains("Password"));
    }
}
