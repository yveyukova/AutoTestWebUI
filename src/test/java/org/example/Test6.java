package org.example;
import io.qameta.allure.*;
import org.example.utils.Monro24Page;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
@Story("Тестируем работу формы поддержки на сайте monro24.ru")
public class Test6 {
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
    @ParameterizedTest
    @CsvSource({"Тест, +79991234567, Проверка. Перезванивать не нужно"})
    @DisplayName("Тест кнопки Заказать звонок")
    @Description("Проверка работы кнопки Заказать звонок и заполнения обратной связи")
    @Link("https://monro24.ru")
    @Severity(SeverityLevel.MINOR)
    void test(String name, String phone, String mess) {
        Assertions.assertTrue(
                monro24Page.getRoot()
                        .clickSupportCall()
                        .sendSupportName(name)
                        .sendSupportTel(phone)
                        .sendSupportMsg(mess)
                        .clickSupportBtn()
                        .makeScreenshot()
                        .getHelp()
                        .equals("Помощь"));
    }
}
