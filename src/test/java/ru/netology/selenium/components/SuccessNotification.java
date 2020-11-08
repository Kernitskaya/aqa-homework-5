package ru.netology.selenium.components;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class SuccessNotification {
    SelenideElement notificationContainer = $("[data-test-id=success-notification]");
    SelenideElement content = notificationContainer.$(".notification__content");
    SelenideElement closeIcon = notificationContainer.$(".icon-button__text");

    public SuccessNotification() {
        notificationContainer.shouldBe(Condition.visible);
    }

    public SelenideElement content() {
        return content;
    }

    public void close() {
        closeIcon.click();
    }
}
