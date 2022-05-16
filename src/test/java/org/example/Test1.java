package org.example;

import io.qameta.allure.*;
import org.example.utils.DemoqaPage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.List;

@Story("Тестируем форму регистрации на спецсайте")
public class Test1 {
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

    @ParameterizedTest
    @CsvSource({"Ivan, Ivanov, ivanov@mail.ru"})
    @DisplayName("Тест формы регистрации")
    @Description("Проверка корректности заполнения формы регистрации на спецсайте")
    @Link("https://demoqa.com/automation-practice-form")
    @Severity(SeverityLevel.MINOR)
    void test(String name, String lastName, String email) {
        Assertions.assertTrue(
                demoqaPage.getAutomationPracticeForm()
                        .sendFirstName(name)
                        .sendLastName(lastName)
                        .sendEmail(email)
                        .clickMan()
                        .sendUserNumber("89999999999")
                        .setDateOfBirth()
                        .setHobbies()
                        .sendCurrentAddress("Moscow")
                        .clickSubmit()
                        .makeScreenshot()
                        .getResultText()
                        .equals("Thanks for submitting the form"));
    }
}
