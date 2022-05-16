package org.example;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
        monro24Page.getRoot();
    }
    @ParameterizedTest
    @CsvSource({"Тест, +79991234567, Проверка. Перезванивать не нужно"})
    void test(String name, String phone, String mess) {
        Assertions.assertTrue(
                monro24Page.getRoot()
                        .clickSupportCall()
                        .sendSupportName(name)
                        .sendSupportTel(phone)
                        .sendSupportMsg(mess)
                        .clickSupportBtn()
                        .getHelp()
                        .equals("Помощь"));
    }
}
