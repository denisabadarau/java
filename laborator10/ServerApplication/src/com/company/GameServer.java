package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GameServer {
    //portul pe care asculta serverul
    public static final int port=9999; //am pus un numar random de la 1024 la 65535(de la 0-1023 sunt valori rezervate)

    //socketul care ruleaza la portul specificat mai sus
    ServerSocket serverSocket;

    //o instanta a acestei clase va crea socketul la portul specificat
    public GameServer() throws IOException
    {
        serverSocket=null;
        try
        {
            serverSocket=new ServerSocket(port);
            while(true)
            {
                System.out.println("Astept un client...");
                Socket socket = serverSocket.accept();

                System.out.println("A sosit clientul...");
                //se executa comanda clientului intr-un thread nou
                new ClientThread(socket).start();

            }
        }catch(IOException e)
        {
            System.out.println("Eroare..." + e);
        }finally {
            serverSocket.close();
        }

    }
}
