package tests;

import base.BaseTest;

import org.testng.Assert;

import org.testng.annotations.Test;

import pages.InventoryPage;

import pages.LoginPage;

//ТЕСТЫ СТРАНИЦЫ PRODUCTS (INVENTORY)

public class InventoryTests extends BaseTest {

    @Test(description = "Проверка заголовка страницы Products")

    public void inventoryTitleTest() {

        // Сначала нужно авторизоваться, потому что Inventory доступна только после логина

        new LoginPage(driver, wait).login("standard_user", "secret_sauce");

        // Создаем страницу товаров

        InventoryPage inventory = new InventoryPage(driver, wait);

    }

    @Test(description = "Проверка выхода из системы")

    public void logoutTest() {

        // Логинимся

        new LoginPage(driver, wait).login("standard_user", "secret_sauce");

        // Создаем страницу товаров

        InventoryPage inventory = new InventoryPage(driver, wait);

        // Нажимаем logout (через меню)

    }


    @Test(description = "Проверка счетчика корзины после открытия корзины")

    public void cartBadgeAfterOpeningCartTest() {

        // Логинимся

        new LoginPage(driver, wait).login("standard_user", "secret_sauce");

        // Создаем страницу товаров

        InventoryPage inventory = new InventoryPage(driver, wait);

        // Добавляем товар в корзину

        inventory.addBackpackToCart();

        // Открываем корзину

        inventory.openCart();

        // Проверяем счетчик корзины после открытия корзины

        Assert.assertEquals(inventory.getCartBadge(), "1");

    }

}