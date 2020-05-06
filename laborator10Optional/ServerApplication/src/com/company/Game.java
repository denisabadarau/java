package com.company;

public class Game {
    Player player1;
    Player player2;
    Board board;

    public Game(Player player1, Player player2, Board board)
    {
        this.player1=new Player(player1);
        this.player2=new Player(player2);
        this.board=new Board(board);
    }

    public boolean gameFinished()
    {
        //pozitia primului jucator
        int r1,c1;
        r1=board.getRow(player1.getSymbol());
        c1= board.getColumn(player1.getSymbol());
        if(board.castigator(r1,c1))return true;

        //pozitia celui de al doilea castigator
        int r2,c2;
        r2=board.getRow(player2.getSymbol());
        c2= board.getColumn(player2.getSymbol());
        if(board.castigator(r2,c2))return true;

        //daca nu mai am mutari libere
        if(board.tablaPlina())return true;

        return false;
    }

    public void muta(Player player, String comanda)
    {
        //un player da o comanda de tipul "move x y", se va executa o mutare la linia x, coloana y
        String[] comanda1=comanda.split(" ");
        int row=Integer.parseInt(comanda1[1]);
        int col=Integer.parseInt(comanda1[2]);
        if(board.esteLiber(row,col))board.alegeMutare(row,col,player.getSymbol());
    }

    public boolean esteMutare(String comanda)
    {
        String[] comanda1=comanda.split(" ");
        if(comanda1[0].equals("move"))return true;
        return false;

    }



}
