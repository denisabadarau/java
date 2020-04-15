package com.company;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        try {

            /*cele 3 controllere*/
            AlbumsController album = new AlbumsController();
            ArtistController artist = new ArtistController();
            ChartsController chart=new ChartsController();

            //inseram in albums 3 albume
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

            //Chart c=new Chart("My top");
            /*inserez in chart cele 3 albume*/
            chart.insertAlbum("My top","Noapte buna",1);
            chart.insertAlbum("My top","Mi-e foame",2);
            chart.insertAlbum("My top","Mi-e somn",3);

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