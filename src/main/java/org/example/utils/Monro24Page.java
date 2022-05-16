package org.example.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Monro24Page {
    private WebDriver driver;

    @FindBy(xpath = " //span[text()=\"Детям\"]/parent::a")
    private WebElement childrenFilter;
    @FindBy(xpath = " //span[text()=\"Мужчинам\"]/parent::a")
    private WebElement manFilter;
    @FindBy(xpath = " //span[text()=\"Женщинам\"]/parent::a")
    private WebElement womanFilter;
    @FindBy(xpath = " //span[text()=\"Товары для дома\"]/parent::a")
    private WebElement goodsFilter;
    @FindBy(className = "catalog-filters__clear")
    private WebElement catalogFilters;


    @FindBy(css = "#model55543668")
    private WebElement model;
    @FindBy(xpath = "//*[@id=\"content\"]/descendant::a[text()=\"134-64\"]")
    private WebElement size;
    @FindBy(xpath = "//*[@id=\"model_form\"]/descendant::button[text()=\"Добавить в корзину\"]")
    private WebElement addBtn;
    @FindBy(className = "checkout-button")
    private WebElement orderBtn;
    @FindBy(className = "order-call")
    private WebElement supportCall;
    @FindBy(id = "support_name")
    private WebElement supportName;
    @FindBy(id = "support_tel")
    private WebElement supportTel;
    @FindBy(id = "support_msg")
    private WebElement supportMsg;
    @FindBy(id = "support_call_callback")
    private WebElement supportBtn;
    @FindBy(className = "support__nav-title")
    private WebElement help;

    public Monro24Page() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        this.driver = new ChromeDriver(options);
        PageFactory.initElements(driver, this);
        this.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }

    public Monro24Page getRoot() {
        driver.get("https://monro24.ru");
        return this;
    }

    public Monro24Page getCatalog() {
        driver.get("https://monro24.ru/catalog.php?f[cat]=1782861");
        return this;
    }

    public Monro24Page clickSupportCall() {
        supportCall.click();
        return this;
    }

    public Monro24Page clickSupportBtn() {
        supportBtn.click();
        return this;
    }

    public Monro24Page sendSupportName(CharSequence... keysToSend) {
        supportName.sendKeys(keysToSend);
        return this;
    }

    public Monro24Page sendSupportTel(CharSequence... keysToSend) {
        supportTel.sendKeys(keysToSend);
        return this;
    }

    public Monro24Page sendSupportMsg(CharSequence... keysToSend) {
        supportMsg.sendKeys(keysToSend);
        return this;
    }

    public Monro24Page clickChildrenFilter() {
        childrenFilter.click();
        return this;
    }

    public Monro24Page clickManFilter() {
        manFilter.click();
        return this;
    }

    public Monro24Page clickWomanFilter() {
        womanFilter.click();
        return this;
    }

    public Monro24Page clickGoodsFilter() {
        goodsFilter.click();
        return this;
    }

    public Monro24Page clickModel() {
        model.click();
        return this;
    }

    public Monro24Page clickSize() {
        size.click();
        return this;
    }

    public Monro24Page clickAddBtn() {
        addBtn.click();
        return this;
    }

    public String getCatalogFilters() {
        return catalogFilters.getText();
    }

    public String getOrderBtn() {
        return orderBtn.getText();
    }

    public String getHelp() {
        return help.getText();
    }

    public void quit() {
        driver.quit();
    }

    public Monro24Page makeScreenshot() {
        Allure.addAttachment("Screenshot" + System.currentTimeMillis() + ".png", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        return this;

    }
    public void printBrowserLog() {
        List<LogEntry> allLogRows = driver.manage().logs().get(LogType.BROWSER).getAll();
        if (!allLogRows.isEmpty()) {
            if (allLogRows.size() > 0) {
                allLogRows.forEach(logEntry -> {
                    System.out.println(logEntry.getMessage());
                });
            }
        }
    }
}
