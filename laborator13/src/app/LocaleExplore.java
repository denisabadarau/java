package app;
import com.*;

import java.util.Locale;
import java.util.Scanner;

public class LocaleExplore {
    public static void main(String args[]){
        System.out.println("Choose a command: ");
        System.out.println("1. display locales");
        System.out.println("2. set locale");
        System.out.println("3. info");
        System.out.println("4. stop");

        Locale locale;
        Scanner console = new Scanner(System.in);
        while(true){
            String comanda=console.nextLine();
            if(comanda.equals("stop"))break;
            else if(comanda.equals("display locales")){
                DisplayLocales locales=new DisplayLocales();
            }
            else if(comanda.equals("set locale")){
                System.out.println("Choose a locale: ");
                Scanner localeScanner=new Scanner(System.in);
                String localeOutput=localeScanner.nextLine();
                //System.out.println(localeOutput);
                Locale localeOut=new Locale(localeOutput);
                SetLocale setlocale=new SetLocale(localeOut);
            }
            else if(comanda.equals("info")){
                System.out.println("Choose a locale: RO or DEFAULT");
                Scanner localeScanner=new Scanner(System.in);
                String localeOutput=localeScanner.nextLine();
                if(localeOutput.equals("RO")){
                    locale=new Locale("ro","RO");
                }
                else
                {
                     locale= Locale.getDefault();
                }
                Info info=new Info(locale);
            }
            //System.out.println(comanda);
        }

    }

}
