package org.example;

import io.qameta.allure.*;
import org.example.utils.DemoqaPage;
import org.junit.jupiter.api.*;

@Story("Тестируем кнопки на спецсайте")
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

    @AfterEach
    public void checkBrowser(){
        demoqaPage.printBrowserLog();
    }
    @Test
    @DisplayName("Тест кнопки двойным нажатием")
    @Description("Проверка срабатывания кнопки по двойному нажатию на спецсайте")
    @Link("https://demoqa.com/buttons")
    @Severity(SeverityLevel.MINOR)
    void testDoubleClickBtn() {
        Assertions.assertTrue(
                demoqaPage.getButtonsPage()
                        .clickDoubleClickBtn()
                        .makeScreenshot()
                        .getDoubleClickMessage()
                        .equals("You have done a double click"));
     }
    @Test
    @DisplayName("Тест кнопки нажатием правой кнопки мыши")
    @Description("Проверка срабатывания кнопки по нажатию правой кнопки мыши на спецсайте")
    @Link("https://demoqa.com/buttons")
    @Severity(SeverityLevel.MINOR)
    void testRightClickBtn() {
        Assertions.assertTrue(
                demoqaPage.getButtonsPage()
                        .clickRightClickBtn()
                        .makeScreenshot()
                        .getRightClickMessage()
                        .equals("You have done a right click"));
    }
    @Test
    @DisplayName("Тест кнопки динамической")
    @Description("Проверка срабатывания динамической кнопки")
    @Link("https://demoqa.com/buttons")
    @Severity(SeverityLevel.MINOR)
    void testDynamicClickBtn() {
        Assertions.assertTrue(
                demoqaPage.getButtonsPage()
                        .clickDynamicClickBtn()
                        .makeScreenshot()
                        .getDynamicClickMessage()
                        .equals("You have done a dynamic click"));
    }
}
