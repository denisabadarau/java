package app;
import com.*;

import java.util.Scanner;

public class LocaleExplore {
    public static void main(String args[]){
        Scanner console = new Scanner(System.in);
        while(true){
            String comanda=console.nextLine();
            if(comanda.equals("stop"))break;
            System.out.println(comanda);
        }

    }

}
