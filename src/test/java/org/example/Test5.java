package org.example;
import org.junit.jupiter.api.*;

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
        monro24Page.getRoot();
    }

    @Test
    void test() {
        Assertions.assertTrue(
                monro24Page.getCatalog()
                        .clickModel()
                        .clickSize()
                        .clickAddBtn()
                        .getOrderBtn()
                        .equals("Оформить заказ"));
    }
}
