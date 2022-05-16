package org.example;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.*;

import java.util.concurrent.TimeUnit;

public class DemoqaPage {
    private WebDriver driver;
    @FindBy(id = "firstName")
    private WebElement firstName;
    @FindBy(id = "lastName")
    private WebElement lastName;
    @FindBy(id = "userEmail")
    private WebElement email;
    @FindBy(css = "#gender-radio-1+label")
    private WebElement man;
    @FindBy(css = "#gender-radio-2+label")
    private WebElement woman;
    @FindBy(id = "userNumber")
    private WebElement userNumber;
    @FindBy(id = "dateOfBirthInput")
    private WebElement dateOfBirthInput;
    @FindBy(css = ".react-datepicker__year-select>option:nth-child(103)")
    private WebElement year;
    @FindBy(css = ".react-datepicker__month-select>option:nth-child(3)")
    private WebElement month;
    @FindBy(css = ".react-datepicker__day--010")
    private WebElement day;
    @FindBy(xpath = "//input[@id=\"hobbies-checkbox-1\"]/../label")
    private WebElement hobby1;
    @FindBy(xpath = "//input[@id=\"hobbies-checkbox-3\"]//following-sibling::label")
    private WebElement hobby2;
    @FindBy(id = "currentAddress")
    private WebElement currentAddress;
    @FindBy(id = "submit")
    private WebElement submit;
    @FindBy(id = "example-modal-sizes-title-lg")
    private WebElement resultText;

    @FindBy(id = "doubleClickBtn")
    private WebElement doubleClickBtn;
    @FindBy(id = "rightClickBtn")
    private WebElement rightClickBtn;
    @FindBy(xpath = "//button[starts-with(.,'Click Me')]")
    private WebElement dynamicClickBtn;

    @FindBy(id = "doubleClickMessage")
    private WebElement doubleClickMessage;
    @FindBy(id = "rightClickMessage")
    private WebElement rightClickMessage;
    @FindBy(id = "dynamicClickMessage")
    private WebElement dynamicClickMessage;

    public DemoqaPage() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        this.driver = new ChromeDriver(options);
        PageFactory.initElements(driver, this);
        this.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }
    public DemoqaPage getAutomationPracticeForm(){
        driver.get("https://demoqa.com/automation-practice-form");
        return this;
    }
    public DemoqaPage getButtonsPage(){
        driver.get("https://demoqa.com/buttons");
        return this;
    }
    public DemoqaPage sendFirstName(CharSequence... keysToSend) {
        firstName.sendKeys(keysToSend);
        return this;
    }
    public DemoqaPage sendLastName(CharSequence... keysToSend) {
        lastName.sendKeys(keysToSend);
        return this;
    }
    public DemoqaPage sendEmail(CharSequence... keysToSend) {
        email.sendKeys(keysToSend);
        return this;
    }
    public DemoqaPage sendUserNumber(CharSequence... keysToSend) {
        userNumber.sendKeys(keysToSend);
        return this;
    }
    public DemoqaPage clickMan() {
        man.click();
        return this;
    }
    public DemoqaPage clickWoman() {
        woman.click();
        return this;
    }

    public DemoqaPage setDateOfBirth() {
        dateOfBirthInput.click();
        year.click();
        month.click();
        day.click();
        return this;
    }
    public DemoqaPage setHobbies() {
        hobby1.click();
        hobby2.click();
        return this;
    }
    public DemoqaPage sendCurrentAddress(CharSequence... keysToSend) {
        currentAddress.sendKeys(keysToSend);
        return this;
    }

    public String getResultText() {
        return resultText.getText();
    }
    public DemoqaPage clickSubmit() {
        submit.submit();
        return this;
    }
    public void quit() {
        driver.quit();
    }

    public DemoqaPage clickDoubleClickBtn(){
        new Actions(driver).doubleClick(doubleClickBtn).perform();
        return this;
    }
    public DemoqaPage clickRightClickBtn(){
        new Actions(driver).contextClick(rightClickBtn).perform();
        return this;
    }
    public DemoqaPage clickDynamicClickBtn(){
        dynamicClickBtn.click();
        return this;
    }
    public String getDoubleClickMessage() {
        return doubleClickMessage.getText();
    }
    public String getRightClickMessage() {
        return rightClickMessage.getText();
    }
    public String getDynamicClickMessage() {
        return dynamicClickMessage.getText();
    }
}
