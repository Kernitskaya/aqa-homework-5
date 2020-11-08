package ru.netology.selenium.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class SuccessReplainNotification {

    SelenideElement container = $("[data-test-id=success-notification]");
    private SelenideElement title = container.$(".notification__title");
    private SelenideElement content = container.$(".notification__content");

    public SuccessReplainNotification() {
        container.shouldBe(Condition.visible);
    }

    public SelenideElement title() {
        return title;
    }

    public SelenideElement content() {
        return content;
    }

}
