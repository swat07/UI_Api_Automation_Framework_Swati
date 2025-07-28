package com.example.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            String browser = TestConfigReader.get("browser");
            boolean headless = Boolean.parseBoolean(TestConfigReader.get("headless"));

            if ("chrome".equalsIgnoreCase(browser)) {
                System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
                ChromeOptions options = new ChromeOptions();
                if (headless) {
                    options.addArguments("--headless=new");
                    options.addArguments("--disable-gpu");
                    options.addArguments("--window-size=1920,1080");
                }
                driver = new ChromeDriver(options);
            } else {
                throw new RuntimeException("Unsupported browser: " + browser);
            }
        }
        return driver;
    }
}