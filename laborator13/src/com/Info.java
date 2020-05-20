package com;

import java.text.DateFormatSymbols;
import java.util.Currency;
import java.util.Locale;

//Info: to display informations about the current or a specific locale.
public class Info {
    Locale locale;
    public Info(Locale locale) {
        this.locale = locale;
        System.out.println("Country: " + locale.getDisplayCountry());
        System.out.println("Language: " + locale.getDisplayLanguage());
        System.out.println("Currency: " + Currency.getInstance(locale));
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
    }
}
