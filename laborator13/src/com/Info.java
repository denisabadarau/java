package com;

import java.text.DateFormatSymbols;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Currency;
import java.util.Locale;

//Info: to display informations about the current or a specific locale.
public class Info {
    Locale locale;
    public Info(Locale locale) {
        this.locale = locale;
        System.out.println("Country: " + this.locale.getDisplayCountry());
        System.out.println("Language: " + this.locale.getDisplayLanguage());
        System.out.println("Currency: " + Currency.getInstance(this.locale));
        String[] weekdays = new DateFormatSymbols(this.locale).getWeekdays();
        System.out.print("Week Days: ");
        for (String days : weekdays) {
            System.out.print(days+" ");
        }
        String[] months = new DateFormatSymbols(this.locale).getMonths();
        System.out.println("");
        System.out.print("Months: ");
        for (String month : months) {
            System.out.print(month+" ");

        }
        DateTimeFormatter date = DateTimeFormatter.ofPattern("dd MMM yyyy", this.locale);
        LocalDateTime now = LocalDateTime.now();
        System.out.println("");
        System.out.println("Today "+date.format(now));
    }
}
