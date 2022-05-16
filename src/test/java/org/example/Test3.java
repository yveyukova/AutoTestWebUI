package org.example;

import org.junit.jupiter.api.*;

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
    @Test
    void testChildren() {
        Assertions.assertTrue(
                monro24Page.clickChildrenFilter()
                        .getCatalogFilters()
                        .equals("Детям"));
    }
    @Test
    void testMan() {
        Assertions.assertTrue(
                monro24Page.clickManFilter()
                        .getCatalogFilters()
                        .equals("Мужчинам"));
    }
    @Test
    void testWoman() {
        Assertions.assertTrue(
                monro24Page.clickWomanFilter()
                        .getCatalogFilters()
                        .equals("Женщинам"));
    }
    @Test
    void testGoods() {
        Assertions.assertTrue(
                monro24Page.clickGoodsFilter()
                        .getCatalogFilters()
                        .equals("Товары для дома"));
    }
}