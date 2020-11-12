package ru.netology.selenium.utils;

import com.github.javafaker.Faker;
import ru.netology.selenium.domain.UserData;

import java.util.Locale;
import java.util.Random;

public class UserGenerator {
    private static Faker faker = new Faker(new Locale("ru"));
    private static String[] cities = {"Москва", "Красноярск", "Тюмень", "Краснодар", "Екатеринбург"};

    private UserGenerator(){}

    public static UserData generateUser() {
        return new UserData(faker.name().firstName() + " " + faker.name().lastName(),
                faker.phoneNumber().phoneNumber(),
                getRandomCity());
    }

    public static String getRandomCity() {
        int rnd = new Random().nextInt(cities.length);
        return cities[rnd];
    }
}
