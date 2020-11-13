package ru.netology.selenium;

import org.junit.jupiter.api.Test;
import ru.netology.selenium.pages.OrderPage;
import ru.netology.selenium.utils.DateUtils;
import ru.netology.selenium.utils.UserGenerator;

import static com.codeborne.selenide.Selenide.open;

public class OrderCardTest {
    private String startUrl = "http://localhost:9999";

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
