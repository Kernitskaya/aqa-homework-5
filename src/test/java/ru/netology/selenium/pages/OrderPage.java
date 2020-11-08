package ru.netology.selenium.pages;

import static com.codeborne.selenide.Condition.visible;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import ru.netology.selenium.components.ReplainNotification;
import ru.netology.selenium.components.SuccessNotification;
import ru.netology.selenium.components.SuccessReplainNotification;
import ru.netology.selenium.domain.UserData;
import ru.netology.selenium.utils.DateUtils;

import java.util.Locale;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class OrderPage {
    private SelenideElement form = $("[id=root]");
    private SelenideElement city = form.$("[placeholder='Город']");
    private SelenideElement meetDate = form.$("[placeholder='Дата встречи']");
    private SelenideElement name = form.$("[name='name']");
    private SelenideElement phone = form.$("[name='phone']");
    private SelenideElement agreeCheckbox = form.$(".checkbox__box");
    private SelenideElement orderButton = form.$(withText("Запланировать"));
    private Faker faker = new Faker(new Locale("ru"));
    private String futureDate = "";
    private UserData userData;

    public OrderPage() {
        userData = new UserData(faker.name().fullName(), faker.phoneNumber().phoneNumber(), faker.address().city());
        form.shouldBe(visible);
    }

    public void fillFormAndConfirm(int futureDays) {
        city.setValue(userData.getCity());
        meetDate.doubleClick().sendKeys(Keys.BACK_SPACE);
        futureDate = DateUtils.getFutureDateByDays(futureDays);
        meetDate.setValue(futureDate);
        name.setValue(userData.getName());
        phone.setValue(userData.getPhone());
        agreeCheckbox.click();
        orderButton.click();
    }

    public void setNewDate(int futureDays) {
        meetDate.doubleClick().sendKeys(Keys.BACK_SPACE);
        futureDate = DateUtils.getFutureDateByDays(futureDays);
        meetDate.setValue(futureDate);
    }

    public void confirm() {
        orderButton.click();
    }

    public SuccessNotification successNotification() {
        return new SuccessNotification();
    }

    public ReplainNotification replainNotification() {
        return new ReplainNotification();
    }

    public SuccessReplainNotification successReplainNotification() {
        return new SuccessReplainNotification();
    }

    public String getFutureDate() {
        return futureDate;
    }

}
