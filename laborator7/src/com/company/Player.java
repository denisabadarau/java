package com.company;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.exit;

public class Player  implements Runnable {
    private final String playerName; //each player will have a name
    private final List<Token> playerTokens = new ArrayList<Token>(); //a list of token that have been  extracted from the board
    private int points = 0; //the number of points for each player game
    private final int progression;
    private boolean go = false;
    private boolean gameFinished = false;
    final Game game; //the game in wich all the players are involved

    public Player(String playerName, int progression, boolean gameFinished, Game game) {
        this.playerName = playerName;
        this.progression = progression;
        this.gameFinished = gameFinished;
        this.game = game;
    }


    public String getPlayerName() {
        return playerName;
    }

    public List<Token> getPlayerTokens() {
        return playerTokens;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getProgression() {
        return progression;
    }

    public boolean isGo() {
        return go;
    }

    public void setGo(boolean go) {
        this.go = go;
    }

    public boolean isGameFinished() {
        return gameFinished;
    }

    public void setGameFinished(boolean gameFinished) {
        this.gameFinished = gameFinished;
    }

    public Game getGame() {
        return game;
    }

    private void extract(int index) {
        this.game.extractToken(index);
    }

    @Override
    public void run() {
        synchronized (this) {
            while (go) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                System.out.println("Player: " + this.playerName);

                Thread.sleep(5000);
                if(!gameFinished)
                    while (this.game.getNumberOfTokensLeft() != 0) {
                        Token tkn=this.game.extractToken(0);
                        this.playerTokens.add(tkn);
                        if(this.progressionTest()>=this.progression){
                            System.out.println();
                            System.out.println("Player-ul "+this.playerName + " a castigat!");
                            System.out.println();
                            points=progressionTest();
                            gameFinished=true;
                            System.out.println(this);
                            exit(0);
                        }
                        //System.out.println(this.name + " extracted | tokens extracted->" + aux);
                    }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            go = true;
            notifyAll();
        }


        points=progressionTest();
        System.out.println(this);

    }

    public int progressionTest()
    {
        int maxProgression=1;
        int ration=-1;
        int numberOfBlankTokens=0;
        playerTokens.sort(new CompareByValue());
        int i;
        for(i=1; i<playerTokens.size();i++)
        {
            if(this.playerTokens.get(i-1).isBlank())
                numberOfBlankTokens++;
            else
            {
                if(ration==-1)
                {
                    ration=playerTokens.get(i+1).getNumber()-playerTokens.get(i).getNumber();
                    maxProgression++;
                }
                else
                {
                    if(playerTokens.get(i+1).getNumber()-playerTokens.get(i).getNumber() != ration)
                    {
                        //if the ration is different, restart the progression
                        maxProgression=1;
                        ration=-1;
                    }
                    else maxProgression++;
                }
            }
        }
        maxProgression+=numberOfBlankTokens;
        return maxProgression;


    }

    @Override
    public String toString() {
        return "Player{" +
                "playerName='" + playerName + '\'' +
                ", playerTokens=" + playerTokens +
                ", points=" + points +
                ", progression=" + progression +
                ", go=" + go +
                ", gameFinished=" + gameFinished +
                ", game=" + game +
                '}';
    }
}

