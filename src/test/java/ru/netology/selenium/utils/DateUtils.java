package ru.netology.selenium.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {
    public static String getFutureDateByDays(int daysCount) {
        LocalDate date = LocalDate.now();
        date = date.plusDays(daysCount);
        return date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }
}
