package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientThread extends Thread{
    private Socket socket=null;
    ServerSocket serverSocket=null;
    Player player1=new Player('1',"player1");
    Player player2=new Player('2',"player2");
    Board board=new Board(10,10);
    Game game=new Game(player1,player2,board);
    //o instanta a acestei clase este responsabila cu comunicarea cu un client Socket
    public ClientThread(Socket socket, ServerSocket serverSocket )
    {
        this.socket=socket;
        this.serverSocket=serverSocket;
    }

    public void run()
    {
        try
        {
            while(!game.gameFinished()) {

                //obtine comanda de la client
                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String comanda = input.readLine();


                //daca serverul primeste comanda "stop", se opreste si returneaza clientului raspunsul "Server stopped
                PrintWriter output = new PrintWriter(socket.getOutputStream());
                String raspuns;
                if (comanda.equals("stop")) {
                    //daca serverul primeste comanda "stop", se opreste
                    raspuns = "Serverul s-a oprit";

                    //se trimite raspunsul catre server
                    output.println(raspuns);

                    //golesc bufferul
                    output.flush();

                    //inchid socketul
                    socket.close();
                    serverSocket.close();
                    break;
                }
                if(comanda.equals("start")){
                    raspuns="Am inceput jocul";
                    //se trimite raspunsul catre server
                    output.println(raspuns);

                    //golesc bufferul
                    output.flush();

                }
                if(comanda.equals("show"))
                {
                   output.println(game.board.tabla());
                }
                if(game.esteMutare(comanda))
                {
                    //in cazul in care comanda este de tipul "move x y" se realizeaza comanda
                    game.muta(player1,comanda);
                }
            }

        }catch(IOException e)
        {
            System.out.println("Eroare la comunicare: " + e);
        }finally {
            try{
                socket.close();
            }catch (IOException e)
            {
                System.out.println("Eroare..." + e);
            }
        }
    }
}