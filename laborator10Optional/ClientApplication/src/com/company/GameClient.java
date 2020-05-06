package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class GameClient {
    public static final int port = 9999; // portul serverului
    String serverAddress = "127.0.0.1"; // adresa IP

    //o instanta a acestei clase va citi comenzi de la tastatura si le va trimite catre sever, iar in final va afisa raspunsul de la server
    public GameClient() throws IOException {
        try {
            Socket socket = new Socket(serverAddress, port);
            PrintWriter output= new PrintWriter(socket.getOutputStream(), true);
            BufferedReader input = new BufferedReader (new InputStreamReader(socket.getInputStream())) ;

            //pe masura ce citesc comenzi de la tastatura, le transmit serverului, si in final afisez raspunsul serverului
            while(true)
            {
                String comanda;
                //pentru a citi de la tastatura, folosesc un Scanner
                Scanner scan = new Scanner(System.in);
                comanda = scan.nextLine();

                //clientul se opreste cand citeste de la tastatura "exit"
                if (comanda.equals("exit"))
                {
                    socket.close();
                    break;
                }

                // trimite comanda catre server
                output.println(comanda);

                // asteapta raspuns de la server
                String raspuns = input.readLine();
                System.out.println(raspuns);
            }
        } catch (UnknownHostException e) {
            System.err.println("No server listening... " + e);
        }
    }
}