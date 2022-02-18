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

import java.util.concurrent.TimeUnit;

public class Test1 {
    static WebDriver driver;

    @BeforeAll
    static void init() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://demoqa.com/automation-practice-form");
    }

    @AfterAll
    static void close() {
        driver.quit();
    }

    @ParameterizedTest
    @CsvSource({"Ivan, Ivanov, ivanov@mail.ru"})
    void test(String name, String lastName, String email) {
        WebElement webElement = driver.findElement(By.id("firstName"));
        webElement.sendKeys(name);
        driver.findElement(By.id("lastName")).sendKeys(lastName);
        driver.findElement(By.id("userEmail")).sendKeys(email);
        driver.findElement(By.cssSelector("#gender-radio-1+label")).click();
        driver.findElement(By.id("userNumber")).sendKeys("89999999999");
        driver.findElement((By.id("dateOfBirthInput"))).click();
        driver.findElement((By.cssSelector(".react-datepicker__year-select>option:nth-child(103)"))).click();
        driver.findElement(By.cssSelector(".react-datepicker__month-select>option:nth-child(3)")).click();
        driver.findElement(By.cssSelector(".react-datepicker__day--010")).click();
        driver.findElement(By.xpath("//input[@id=\"hobbies-checkbox-1\"]/../label")).click();
        driver.findElement(By.xpath("//input[@id=\"hobbies-checkbox-3\"]//following-sibling::label")).click();
        driver.findElement(By.id("currentAddress")).sendKeys("Moscow");
        driver.findElement(By.id("submit")).submit();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assertions.assertTrue(driver.findElement(By.id("example-modal-sizes-title-lg")).getText().equals("Thanks for submitting the form"));
    }

    @AfterEach
    void getPage() {
        driver.get("https://demoqa.com/");
    }
}
