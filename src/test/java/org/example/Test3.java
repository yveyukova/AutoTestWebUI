package org.example;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
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
    }

    @AfterEach
    void getPage() {
        driver.get("https://monro24.ru");
    }

    @Test
    void test() {
        WebElement webElement = driver.findElement(By.xpath(" //span[text()=\"Детям\"]/parent::a"));
        webElement.click();
        Assertions.assertEquals("Поиск",driver.getTitle(),"Не та страница");

    }
    @AfterAll
    static void close(){
        driver.quit();
    }
}