package com.company;

import java.util.Random;

public class Token {
    private int number;
    boolean blank=false; //the case when a token may be blank, it can take the place of any number
    Random r=new Random();

    public Token(int m)
    {
        if(m==-1)
        {
            //the case when a token is blank
            blank=true;
        }
        else
        {
            //define the range
            int min=1;
            int max=m;
            int range=max-min+1;

            //generate a random number beetwen 1 and m
            number=(int)(Math.random()*range)+min;
        }
    }

    public int getNumber() {
        return number;
    }

    public boolean isBlank() {
        return blank;
    }

}
