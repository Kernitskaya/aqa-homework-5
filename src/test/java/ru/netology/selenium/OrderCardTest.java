package ru.netology.selenium;

import org.junit.jupiter.api.Test;
import ru.netology.selenium.components.ReplainNotification;
import ru.netology.selenium.components.SuccessNotification;
import ru.netology.selenium.components.SuccessReplainNotification;
import ru.netology.selenium.pages.OrderPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;

public class OrderCardTest {
    private String startUrl = "http://localhost:9999";
    private String successPlainPattern = "Встреча успешно запланирована на %s";
    private String successReplainPattern = "Встреча успешно запланирована на %s";

    @Test
    void testValidOrder() {
        open(startUrl);
        OrderPage orderPage = new OrderPage();
        orderPage.fillFormAndConfirm(3);

        SuccessNotification successNotification = orderPage.successNotification();
        successNotification.content().shouldHave(text(String.format(successPlainPattern, orderPage.getFutureDate())));
        successNotification.close();

        orderPage.setNewDate(4);
        orderPage.confirm();
        ReplainNotification replainNotification = orderPage.replainNotification();
        replainNotification.title().shouldHave(text("Необходимо подтверждение"));
        replainNotification.content().shouldHave(text("У вас уже запланирована встреча на другую дату. Перепланировать?"));
        replainNotification.confirm();

        SuccessReplainNotification successReplainNotification = orderPage.successReplainNotification();
        successReplainNotification.title().shouldHave(text("Успешно!"));
        successReplainNotification.content().shouldHave(text(String.format(successReplainPattern, orderPage.getFutureDate())));
    }
}
