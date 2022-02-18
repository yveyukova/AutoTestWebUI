package org.example;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Test6 {
    static WebDriver driver;

    @BeforeAll
    static void init() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://monro24.ru");
    }

    @AfterAll
    static void close() {
        driver.quit();
    }

    @AfterEach
    void getPage() {
        driver.get("https://monro24.ru");
    }

    @ParameterizedTest
    @CsvSource({"Тест, +79991234567, Проверка. Перезванивать не нужно"})
    void test(String name, String phone, String mess) {
        WebElement webElement = driver.findElement(By.className("order-call"));
        webElement.click();
        driver.findElement(By.id("support_name")).sendKeys(name);
        driver.findElement(By.id("support_tel")).sendKeys(phone);
        driver.findElement(By.id("support_msg")).sendKeys(mess);
        webElement = driver.findElement(By.id("support_call_callback"));
        webElement.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assertions.assertTrue(driver.findElement(By.className("support__nav-title")).getText().equals("Помощь"));
    }
}
