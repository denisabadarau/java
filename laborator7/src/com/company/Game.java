package com.company;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> players=new ArrayList<Player>(); //the list of the players
    private Board board;
    private boolean gameFinished=false;

    public Game(){}
    public Game(Board board)
    {
        this.board=board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public boolean isGameFinished() {
        return gameFinished;
    }

    public void setGameFinished(boolean gameFinished) {
        this.gameFinished = gameFinished;
    }

    synchronized public Token extractToken(int index)
    {
        Token tkn=this.board.getTokens().get(index);
        //extract the selected token
        board.getTokens().remove(index);
        return tkn;
    }

    public int getNumberOfTokensLeft()
    {
        return board.getNumberOfTokens();
    }

    public void gameOn()
    {
        board=new Board(8);
        Player player1=new Player("Denisa",4,gameFinished,this);
        Player player2=new Player("Idk",4,gameFinished,this);
        players.add(player1);
        players.add(player2);

        Runnable firstPlayer=players.get(0);
        Runnable secondPlayer=players.get(1);

        //threads for each player
       new Thread(firstPlayer).start();
        new Thread(secondPlayer).start();

    }



}
