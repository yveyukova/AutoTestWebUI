package org.example;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Test5 {
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
    @CsvSource({"1782861, l54421433, 152-76"})
    void test(String cat, String model, String size) {
        driver.get("https://monro24.ru/catalog.php?f[cat]="+cat);
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("window.scrollBy(0,600)");
        WebElement webElement = driver.findElement(By.cssSelector("#mode"+model));
        webElement.click();
        webElement = driver.findElement(By.xpath("//*[@id=\"content\"]/descendant::a[text()=\""+size+"\"]"));
        webElement.click();
        webElement = driver.findElement(By.xpath("//*[@id=\"model_form\"]/descendant::button[text()=\"Добавить в корзину\"]"));
        webElement.click();
        Assertions.assertTrue(driver.findElement(By.className("checkout-button")).getText().equals("Оформить заказ"));

    }
    @AfterAll
    static void close(){
        driver.quit();
    }
}
