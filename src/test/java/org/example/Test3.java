package org.example;

import io.qameta.allure.*;
import org.example.utils.Monro24Page;
import org.junit.jupiter.api.*;
@Story("Тестируем разделы на сайте monro24.ru")
public class Test3 {
    static Monro24Page monro24Page;
    @BeforeAll
    static void init() {
        monro24Page = new Monro24Page();
        monro24Page.getRoot();
    }

    @AfterAll
    static void close() {
        monro24Page.quit();
    }
    @AfterEach
    void getPage() {
        monro24Page.getRoot();
    }

    @AfterEach
    public void checkBrowser(){
        monro24Page.printBrowserLog();
    }
    @Test
    @DisplayName("Тест раздела Детям")
    @Description("Проверка срабатывания навигации по разделам. Переход к разделу Детям")
    @Link("https://monro24.ru")
    @Severity(SeverityLevel.MINOR)
    void testChildren() {
        Assertions.assertTrue(
                monro24Page.clickChildrenFilter()
                        .makeScreenshot()
                        .getCatalogFilters()
                        .equals("Детям"));
    }
    @Test
    @DisplayName("Тест раздела Мужчинам")
    @Description("Проверка срабатывания навигации по разделам. Переход к разделу Мужчинам")
    @Link("https://monro24.ru")
    @Severity(SeverityLevel.MINOR)
    void testMan() {
        Assertions.assertTrue(
                monro24Page.clickManFilter()
                        .makeScreenshot()
                        .getCatalogFilters()
                        .equals("Мужчинам"));
    }
    @Test
    @DisplayName("Тест раздела Женщинам")
    @Description("Проверка срабатывания навигации по разделам. Переход к разделу Женщинам")
    @Link("https://monro24.ru")
    @Severity(SeverityLevel.MINOR)
    void testWoman() {
        Assertions.assertTrue(
                monro24Page.clickWomanFilter()
                        .makeScreenshot()
                        .getCatalogFilters()
                        .equals("Женщинам"));
    }
    @Test
    @DisplayName("Тест раздела Товары для дома")
    @Description("Проверка срабатывания навигации по разделам. Переход к разделу Товары для дома")
    @Link("https://monro24.ru")
    @Severity(SeverityLevel.MINOR)
    void testGoods() {
        Assertions.assertTrue(
                monro24Page.clickGoodsFilter()
                        .makeScreenshot()
                        .getCatalogFilters()
                        .equals("Товары для дома"));
    }
}