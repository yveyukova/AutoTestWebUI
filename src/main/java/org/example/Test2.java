package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class Test2 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--incognito");
        options.addArguments("disable-popup-blocking");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://demoqa.com/buttons");


        Actions action = new Actions(driver);
        WebElement elementLocator = driver.findElement(By.id("doubleClickBtn"));
        action.doubleClick(elementLocator).perform();
        WebElement elementLocators = driver.findElement(By.id("rightClickBtn"));
        action.contextClick(elementLocators).perform();
        WebElement webElement = driver.findElement(By.xpath("//button[starts-with(.,'Click Me')]"));
        webElement.click();
        driver.quit();

    }
}
