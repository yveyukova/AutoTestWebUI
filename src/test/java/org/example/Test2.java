package org.example;

import org.junit.jupiter.api.*;

public class Test2 {
    static DemoqaPage demoqaPage;
    @BeforeAll
    static void init() {
        demoqaPage = new DemoqaPage();
    }

    @AfterAll
    static void close() {
        demoqaPage.quit();
    }

    @Test
    void testDoubleClickBtn() {
        Assertions.assertTrue(
                demoqaPage.getButtonsPage()
                        .clickDoubleClickBtn()
                        .getDoubleClickMessage()
                        .equals("You have done a double click"));
     }
    @Test
    void testRightClickBtn() {
        Assertions.assertTrue(
                demoqaPage.getButtonsPage()
                        .clickRightClickBtn()
                        .getRightClickMessage()
                        .equals("You have done a right click"));
    }
    @Test
    void testDynamicClickBtn() {
        Assertions.assertTrue(
                demoqaPage.getButtonsPage()
                        .clickDynamicClickBtn()
                        .getDynamicClickMessage()
                        .equals("You have done a dynamic click"));
    }
}
