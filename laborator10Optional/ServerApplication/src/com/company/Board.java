package com.company;

import java.util.Arrays;

public class Board {
    int rows;
    int columns;
    char[][] board; //tabla de joc(o matrice)
    public Board(int rows, int columns)
    {
       this.rows=rows;
       this.columns=columns;
       this.board=new char[rows][columns];
       initializare();
    }
    public Board(Board board)
    {
        this.rows=board.rows;
        this.columns=board.columns;
        this.board=new char[rows][columns];
        initializare();
    }

    private void initializare()
    {
        //initial matricea va fi toata cu valori de 0
        for(int i=0;i<this.rows;i++)
            for(int j=0;j<this.columns;j++)
                board[i][j]='0';

    }
    public void alegeMutare(int row, int column, char symbol)
    {
        //functia va face o mutare pe tabla, va pune pe linia row si coloana column semnul jucatorului
        board[row][column] = symbol;
    }
    public Boolean esteLiber(int row, int column)
    {
        //verifica daca locul ales nu este deja ocupat pe tabla
        if(board[row][column]!='0')return false;
        else return true;
    }



    public void afiseazaTabla() {
        for(int i=0;i<this.rows;i++) {
            for (int j = 0; j < this.columns; j++)
                System.out.print(board[i][j]+" ");
            System.out.println();
        }
    }

    public String tabla()
    {
        String out="";
        for(int i=0;i<this.rows;i++)
        {
            for(int j=0; j<this.columns;j++)
                out+=board[i][j]+" ";
            out+='\n';
        }
        return out;
    }

    private int totalPieseLinie(char symbol, int row, int col) {
        //functia numara cate piese are jucatorul specificat pe linie
        int nrLinie = 1; //numarul de piese dintr-o linie, pun la numar si piesa care se afla pe pozitiile row col
        int r, c;
        //ma deplasez la dreapta, pe aceeasi linie
        r = row;
        c = col + 1;
        while (c < this.columns && board[r][c] == symbol) {
            //cat timp ma aflu in limitele tablei, si exista piese ale jucatorului specificat
            nrLinie++; //maresc numarul de piese gasite
            c++; //si ma deplasez spre dreapta, pentru a cauta in continuare
        }
        //ma deplasez la stanga, pe aceeasi linie
        c = col - 1;
        while (c >= 0 && board[r][c] == symbol) {
            //cat timp ma aflu in limitele tablei, si exista piese ale jucatorului specificat
            nrLinie++; //maresc numarul de piese gasite
            c--; //si ma deplasez spre stanga, pentru a cauta in continuare
        }
        return nrLinie;
    }

    private int totalPieseColoana(char symbol, int row, int col)
    {
        int nrColoana=1;  //numarul de piese dintr-o coloana, pun la numar si piesa care se afla pe pozitiile row col
        int r,c;
        //ma deplasez in sus, pe aceeasi coloana
        r=row-1;
        c=col;
        while(r>=0 && board[r][c]==symbol)
        {
            //cat timp ma aflu in limitele tablei, si exista piese ale jucatorului specificat
            nrColoana++; //maresc nr de piese gasite
            r--; //ma deplasez in sus
        }
        //ma deplasez in jos pe coloana
        r=row+1;
        while(r<this.rows && board[r][c]==symbol)
        {
            //cat timp ma aflu in limitele tablei, si exista piese ale jucatorului specificat
            nrColoana++; //maresc nr de piese gasite
            r++; //ma deplasez in jos
        }
        return nrColoana;
    }

    private int totalPieseDiagonalaPrincipala(char symbol, int row, int col)
    {
        int nrDiag1=1;
        int r,c;
        //ma deplasez in sus, pe diagonala principala
        r=row-1;
        c=col-1;
        while(r>=0 && c>=0 && board[r][c]==symbol)
        {
            nrDiag1++;
            r--;
            c--;
        }
        //ma deplasez in jos, pe diagonala principala
        r=row+1;
        c=col+1;
        while(r<this.rows && c<this.columns && board[r][c]==symbol)
        {
            nrDiag1++;
            r++;
            c++;
        }
        return nrDiag1;
    }
    private int totalPieseDiagonalaSecundara(char symbol, int row, int col)
    {
        int nrDiag2=1;
        int r,c;
        //ma deplasez in sus, pe diagonala secundara
        r=row-1;
        c=col+1;
        while(r>=0 && c<this.columns && board[r][c]==symbol)
        {
            nrDiag2++;
            r--;
            c++;
        }
        //ma deplasez in jos, pe diagonala secundara
        r=row+1;
        c=col-1;
        while(r<this.rows && c>=0 && board[r][c]==symbol)
        {
            nrDiag2++;
            r++;
            c--;
        }
        return nrDiag2;
    }

    public boolean castigator(int row, int col)
    {
        //verifica daca jucatorul aflat la pozitiile row col a castigat
        if(totalPieseLinie(board[row][col],row,col)>=5)return true;
        if(totalPieseColoana(board[row][col],row,col)>=5)return true;
        if(totalPieseDiagonalaPrincipala(board[row][col],row,col)>=5)return true;
        if(totalPieseDiagonalaSecundara(board[row][col],row,col)>=5)return true;
        return false;
    }
    public boolean tablaPlina()
    {
        //verifica daca mai sunt locuri libere pe tabla
        int nr=0;
        for(int i=0;i<this.rows;i++)
            for(int j=0;j<this.columns;j++)
                if(board[i][j]!='0')
                    nr++;
        if(nr==this.rows*this.columns)return true;
        else return false;
    }
    public int getRow(char symbol)
    {
        for(int i=0;i<this.rows;i++)
            for(int j=0;j<this.columns;j++)
                if(board[i][j]==symbol)
                    return i;

     return -1; //nu se afla in tabla
    }
    public int getColumn(char symbol)
    {
        for(int i=0;i<this.rows;i++)
            for(int j=0;j<this.columns;j++)
                if(board[i][j]==symbol)
                    return j;

        return -1; //nu se afla in tabla
    }


}
