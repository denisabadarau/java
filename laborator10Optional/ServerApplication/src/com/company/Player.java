package com.company;

public class Player {
    char symbol; //simbolul cu care va juca playerul pe tabla
    String name; //numele jucatorului

    public Player(char symbol, String name)
    {
        this.symbol=symbol;
        this.name=name;
    }

    public Player(Player player)
    {
        this.symbol=player.symbol;
        this.name=player.name;
    }

    public char getSymbol() {
        return symbol;
    }


    public String getName() {
        return name;
    }

}
