package org.example;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Test3 {
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

    @AfterEach
    void getPage() {
        driver.get("https://monro24.ru");
    }

    @ParameterizedTest
    @ValueSource(strings = {"Детям", "Мужчинам", "Женщинам","Товары для дома"})
    void test(String page) {
        WebElement webElement = driver.findElement(By.xpath(" //span[text()=\""+page+"\"]/parent::a"));
        webElement.click();
        Assertions.assertTrue(driver.findElement(By.className("catalog-filters__clear")).getText().equals(page));

    }
    @AfterAll
    static void close(){
        driver.quit();
    }
}