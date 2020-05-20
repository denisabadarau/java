package com;

import java.util.Locale;

//SetLocale: to set the application current locale or a specific locale
public class SetLocale {
    Locale locale;

    public SetLocale(Locale locale){
        this.locale.setDefault(locale);
    }
}
