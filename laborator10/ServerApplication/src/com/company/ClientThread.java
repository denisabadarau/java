package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread{
    private Socket socket=null;

    //o instanta a acestei clase este responsabila cu comunicarea cu un client Socket
    public ClientThread(Socket socket)
    {
        this.socket=socket;
    }

    public void run()
    {
        try
        {
            //obtine comanda de la client
            BufferedReader input=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String comanda=input.readLine();

            //se trimite raspunsul catre server
            //daca serverul primeste comanda "stop", se opreste si returneaza clientului raspunsul "Server stopped
            PrintWriter output=new PrintWriter(socket.getOutputStream());
            String raspuns;
            if(comanda.equals("stop"))
            {
                //daca serverul primeste comanda "stop", se opreste
                raspuns="Serverul s-a oprit";
                output.println(raspuns);
                output.flush();
                socket.close();
            }
            else
            {
                //in caz contrar, afisez comanda
                raspuns="Serverul a primit comanda " + comanda;
                output.println(raspuns);
                output.flush();
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
