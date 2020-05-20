package com;

import java.util.Locale;

//SetLocale: to set the application current locale.
public class SetLocale {
    public SetLocale(){
        Locale currentLocale = Locale.getDefault();
        System.out.println(currentLocale);
    }

}
