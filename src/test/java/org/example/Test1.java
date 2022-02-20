package org.example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @ParameterizedTest
    @CsvSource({"Ivan, Ivanov, ivanov@mail.ru"})
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
                        .getResultText()
                        .equals("Thanks for submitting the form"));
    }
}
