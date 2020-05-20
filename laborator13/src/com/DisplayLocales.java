package com;

import java.util.Locale;
import java.util.Properties;
//import res.*;
//DisplayLocales: to display all available locales
public class DisplayLocales {
    public  DisplayLocales(){
        //Properties properties=new Properties();
        //System.out.println(properties.getProperty("locales"));
        Locale available[]=Locale.getAvailableLocales();
        for(Locale locale : available) {
            System.out.println(locale.toString()+" "+locale.getDisplayName()+" "+ locale.getDisplayCountry()+" "+locale.getDisplayLanguage(locale));
        }
    }

}
