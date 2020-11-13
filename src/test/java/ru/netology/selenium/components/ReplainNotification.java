package ru.netology.selenium.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ReplainNotification {

    private SelenideElement container = $("[data-test-id=replan-notification]");
    private SelenideElement title = container.$(".notification__title");
    private SelenideElement content = container.$(".notification__content");
    private SelenideElement orderButton = container.$(".button__content");

    private String titleText = "Необходимо подтверждение";
    private String contentText = "У вас уже запланирована встреча на другую дату. Перепланировать?";

    public ReplainNotification() {
        container.shouldBe(visible);
    }

    public SelenideElement title() {
        return title;
    }

    public SelenideElement content() {
        return content;
    }

    public ReplainNotification checkTitleText() {
        title().shouldHave(text(titleText));
        return this;
    }

    public ReplainNotification checkContentText() {
        content().shouldHave(text(contentText));
        return this;
    }

    public void confirm() {
        orderButton.click();
    }

}
