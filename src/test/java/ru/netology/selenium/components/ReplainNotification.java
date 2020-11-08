package ru.netology.selenium.components;

import static com.codeborne.selenide.Condition.visible;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ReplainNotification {
    private SelenideElement container = $("[data-test-id=replan-notification]");
    private SelenideElement title = container.$(".notification__title");
    private SelenideElement content = container.$(".notification__content");
    private SelenideElement orderButton = container.$(".button__content");

    public ReplainNotification() {
        container.shouldBe(visible);
    }

    public SelenideElement title() {
        return title;
    }

    public SelenideElement content() {
        return content;
    }

    public void confirm() {
        orderButton.click();
    }

}
