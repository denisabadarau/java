package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int  n,k, m;
        if (args.length < 3)
        {
            System.out.println("Usage: number, number, one or more characters");
            System.exit(-1);
        }
        Main app=new Main();
        n= Integer.parseInt(args[0]);
        k = Integer.parseInt(args[1]);
        m = args.length - 2;
        char alphabet[] = new char[m];
        int i;
        for (i = 0; i < m; i++)
            alphabet[i] = args[i + 2].charAt(0);
        System.out.println("Alfabetul: ");
        for (i = 0; i < m; i++)
            System.out.println(alphabet[i]);
        String words[]=new String[n];
        System.out.println("Cuvintele generate: ");
        for(i=0;i<n;i++)
        {
            words[i]=app.generate(k,alphabet);
            System.out.println(words[i]);
        }
        int j;
        boolean[][] matrix=new boolean[n][n];
        for(i=0;i<n;i++)
            for (j = 0; j < n; j++)
            {
                for(int i1=0;i1<k;i1++)
                    for(int j1=0;j1<k;j1++)
                        if(words[i].charAt(i1)==words[j].charAt(j1) && i!=j)
                        {
                            matrix[i][j]=true;
                        }
            }
        System.out.println("Matricea de adiacenta:");
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.print("\n");
        }

        //BONUS
        isConnected(n,words,matrix);
    }


    public  String generate(int l, char[] alphabet)
    {
        StringBuilder word=new StringBuilder();
        Random rand=new Random();
        int i,j;
        for(i=0;i<l;i++)
        {
            j=rand.nextInt(alphabet.length);
            word.append(alphabet[j]);
        }
        return word.toString();
    }

    private static void isConnected(int n, String[] words, boolean[][] matrix) {
        //  BFS parcurge mai intai toate nodurile de acelasi nivel si avem nevoie sa folosim o coada pentru a retine nodurile ce urmeaza a fi parcurse
        int coada[] = new int[n];
        int viz[] = new int[n];
        int i, j;
        int poz;
        int nod;
        int componenteConexe = 0;
        /*initial toate nodurile sunt nevizitate*/
        for (i = 0; i < n; i++) {
            viz[i] = 0;
        }

        for (i = 0; i < n; i++) {
            if (viz[i] == 0) {
                poz = 0;
                componenteConexe++;
                coada[++poz] = i;
                viz[i] = componenteConexe;
                while (poz > 0) {
                    nod = coada[poz];
                    poz--;
                    for (j = 0; j < n; j++) {
                        if (matrix[nod][j] && viz[j] == 0) {
                            coada[++poz] = j;
                            viz[j] = componenteConexe;
                        }
                    }
                }
            }
        }
        if (componenteConexe == 1) {
            System.out.println("Graful este conex.");
        } else {
            for (i = 1; i <= componenteConexe; i++) {
                System.out.print("Componenta conexa cu numarul " + i + " :");
                for (j = 0; j < n; j++) {
                    if (viz[j] == i) {
                        System.out.print(" " + words[i]);
                    }
                }
                System.out.println();
            }
        }
    }

}