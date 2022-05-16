package org.example;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;

public class Test1 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--incognito");
        options.addArguments("disable-popup-blocking");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.get("https://demoqa.com/automation-practice-form");

        WebElement webElement = driver.findElement(By.id("firstName"));
        webElement.sendKeys("Ivan");
        driver.findElement(By.id("lastName")).sendKeys("Ivanov");
        driver.findElement(By.id("userEmail")).sendKeys("ivanov@mail.ru");
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
        driver.quit();

    }

}
