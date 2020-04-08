package com.company;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        try {

            /*cele 2 controllere*/
            AlbumsController album = new AlbumsController();
            ArtistController artist = new ArtistController();

            //inseram in albums 1 albume
            album.create("Mi-e foame", 3,1996);
            album.create("Mi-e somn", 2, 1999);
            album.create("Noapte buna", 1, 2000);
            DataBase.commit();

            int albumID = album.findByArtist(3);
            System.out.println("Id-ul albumului: " + albumID);

            /*inseram 3 artisti*/
            artist.create("Denisa", "Romania");
            artist.create("Ionela","America");
            artist.create("Madonna","Franta");
            DataBase.commit();

            int artistID = artist.findByName("Denisa");
            System.out.println("Id-ul artistului: " + artistID);

        } catch (SQLException e) {
            System.err.println(e);
            DataBase.rollback();
        }//inchidem conexiunea cu baza de date
        finally {
            try {
                DataBase.closeConnection();
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}