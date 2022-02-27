package org.example;
import io.qameta.allure.*;
import org.example.utils.Monro24Page;
import org.junit.jupiter.api.*;
@Story("Тестируем заказ на сайте monro24.ru")
public class Test5 {
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
        monro24Page.printBrowserLog();
        monro24Page.getRoot();
    }

    @Test
    @DisplayName("Тест оформления заказа")
    @Description("Проверка оформления заказа (добавления товара в корзину)")
    @Link("https://monro24.ru")
    @Severity(SeverityLevel.MINOR)
    void test() {
        Assertions.assertTrue(
                monro24Page.getCatalog()
                        .clickModel()
                        .clickSize()
                        .clickAddBtn()
                        .makeScreenshot()
                        .getOrderBtn()
                        .equals("Оформить заказ"));
    }
}
