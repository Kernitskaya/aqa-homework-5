package ru.netology.selenium.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class SuccessReplainNotification {

    SelenideElement container = $("[data-test-id=success-notification]");
    private SelenideElement title = container.$(".notification__title");
    private SelenideElement content = container.$(".notification__content");

    private String titleText = "Успешно!";
    private String successReplainPattern = "Встреча успешно запланирована на %s";

    public SuccessReplainNotification() {
        container.shouldBe(Condition.visible);
    }

    public SelenideElement title() {
        return title;
    }

    public SelenideElement content() {
        return content;
    }

    public SuccessReplainNotification checkTitleText() {
        title.shouldHave(text(titleText));
        return this;
    }

    public void checkContentText(String date) {
        content().shouldHave(text(String.format(successReplainPattern, date)));
    }

}
