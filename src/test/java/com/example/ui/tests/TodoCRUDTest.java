package com.example.ui.tests;

import com.example.base.BaseTest;
import com.example.config.ConfigReader;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TodoCRUDTest extends BaseTest {

    @BeforeClass
    public void login() {
        driver.get(ConfigReader.get("baseUrl") + "/login");
        driver.findElement(By.id("email")).sendKeys(ConfigReader.get("email"));
        driver.findElement(By.id("password")).sendKeys(ConfigReader.get("password"));
        driver.findElement(By.id("login-button")).click();
    }

    @Test
    public void testCreateEditDeleteTodo() {
        driver.findElement(By.id("new-todo")).sendKeys("Test Todo");
        driver.findElement(By.id("add-button")).click();
        Assert.assertTrue(driver.getPageSource().contains("Test Todo"));

        driver.findElement(By.xpath("//button[contains(text(),'Edit')]")).click();
        driver.findElement(By.id("edit-todo")).clear();
        driver.findElement(By.id("edit-todo")).sendKeys("Updated Todo");
        driver.findElement(By.id("update-button")).click();
        Assert.assertTrue(driver.getPageSource().contains("Updated Todo"));

        driver.findElement(By.xpath("//button[contains(text(),'Delete')]")).click();
        Assert.assertFalse(driver.getPageSource().contains("Updated Todo"));
    }
}