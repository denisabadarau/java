package com;

import java.util.Locale;

//DisplayLocales: to display all available locales
public class DisplayLocales {
    public  DisplayLocales(){

        Locale available[]=Locale.getAvailableLocales();
        for(Locale locale : available) {
            System.out.println(locale.toString()+" "+locale.getDisplayName()+" "+ locale.getDisplayCountry()+" "+locale.getDisplayLanguage(locale));
        }
    }

}
