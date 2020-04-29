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
            while(true) {

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
                } else {
                    //in caz contrar, afisez comanda
                    raspuns = "Serverul a primit comanda " + comanda;

                    //se trimite raspunsul catre server
                    output.println(raspuns);

                    //golesc bufferul
                    output.flush();
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
