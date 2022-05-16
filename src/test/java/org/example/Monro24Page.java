package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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


    @FindBy(css = "#model54421433")
    private WebElement model;
    @FindBy(xpath = "//*[@id=\"content\"]/descendant::a[text()=\"152-76\"]")
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

}
