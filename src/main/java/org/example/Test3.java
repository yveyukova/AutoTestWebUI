package org.example;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class Test3 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--incognito");
        options.addArguments("disable-popup-blocking");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://monro24.ru");

        WebElement webElement = driver.findElement(By.xpath("//span[text()=\"Кабинет\"]/preceding-sibling::a"));
        webElement.click();
        driver.findElement(By.id("login_emailphone")).sendKeys("iuaisyytf34@mail.ru");
        driver.findElement(By.id("login_pass")).sendKeys("iuaisyytf34");
        driver.findElement(By.xpath("//a[@id=\"login-account-create\"]//following-sibling::button")).click();

        driver.quit();

    }
}
