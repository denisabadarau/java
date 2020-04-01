package com.company;

import com.company.Token;

import java.util.Comparator;

public class CompareByValue implements Comparator<Token> {

    //use for sorting the tokens
    public int compare(Token a, Token b)
    {
        return a.getNumber() - b.getNumber();
    }


}