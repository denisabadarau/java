package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Board {
    private List<Token> tokens=new ArrayList<Token>(); //board contains a list of tokens

    public Board(int n)
    {
        //the board contain n tokens
        for(int i=0;i<n;i++)
            tokens.add(new Token(n));

    }

    public List<Token> getTokens() {
        return tokens;
    }

    public void setTokens(Token ... token) {
        Collections.addAll(tokens,token);
    }

    public int getNumberOfTokens()
    {
        return tokens.size();
    }
    @Override
    public String toString() {
        return "Board{" +
                "tokens=" + tokens +
                '}';
    }
}
