package com.example.ui.tests;

import com.example.base.BaseTest;
import com.example.config.ConfigReader;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void testValidLogin() {
        driver.get(ConfigReader.get("baseUrl") + "/login");
        driver.findElement(By.id("email")).sendKeys(ConfigReader.get("email"));
        driver.findElement(By.id("password")).sendKeys(ConfigReader.get("password"));
        driver.findElement(By.id("login-button")).click();
        Assert.assertTrue(driver.getPageSource().contains("Dashboard"));
    }

    @Test
    public void testInvalidLogin() {
        driver.get(ConfigReader.get("baseUrl") + "/login");
        driver.findElement(By.id("email")).sendKeys("wrong@example.com");
        driver.findElement(By.id("password")).sendKeys("wrongpassword");
        driver.findElement(By.id("login-button")).click();
        Assert.assertTrue(driver.getPageSource().contains("Invalid credentials"));
    }
}