package ru.netology.selenium;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.netology.selenium.pages.OrderPage;
import ru.netology.selenium.utils.DateUtils;
import ru.netology.selenium.utils.UserGenerator;

import static com.codeborne.selenide.Selenide.open;

public class OrderCardTest {
    private String startUrl = "http://localhost:9999";

    @BeforeAll
    public static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    public static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @Test
    void testValidOrder() {
        open(startUrl);
        OrderPage orderPage = new OrderPage();
        String futureDate = DateUtils.getFutureDateByDays(3);
        orderPage.fillFormAndConfirm(futureDate, UserGenerator.generateUser());
        orderPage.successNotification().checkContentText(futureDate).close();

        futureDate = DateUtils.getFutureDateByDays(4);
        orderPage.setNewDate(futureDate).confirm();
        orderPage.replainNotification().checkTitleText().checkContentText().confirm();
        orderPage.successReplainNotification().checkTitleText().checkContentText(futureDate);
    }
}
