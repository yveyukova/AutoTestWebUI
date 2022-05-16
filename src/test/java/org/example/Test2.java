package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class Test2 {
    static WebDriver driver;

    @BeforeAll
    static void init() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--incognito");
        options.addArguments("disable-popup-blocking");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://demoqa.com/buttons");
    }

    @AfterAll
    static void close() {
        driver.quit();
    }

    @Test
    void test() {
        Actions action = new Actions(driver);
        WebElement elementLocator = driver.findElement(By.id("doubleClickBtn"));
        action.doubleClick(elementLocator).perform();
        WebElement elementLocators = driver.findElement(By.id("rightClickBtn"));
        action.contextClick(elementLocators).perform();
        WebElement webElement = driver.findElement(By.xpath("//button[starts-with(.,'Click Me')]"));
        webElement.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assertions.assertTrue(driver.findElement(By.id("doubleClickMessage")).getText().equals("You have done a double click"));
        Assertions.assertTrue(driver.findElement(By.id("rightClickMessage")).getText().equals("You have done a right click"));
        Assertions.assertTrue(driver.findElement(By.id("dynamicClickMessage")).getText().equals("You have done a dynamic click"));
    }

    @AfterEach
    void getPage() {
        driver.get("https://demoqa.com/");
    }
}
