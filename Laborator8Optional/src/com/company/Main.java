package com.company;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

        /*cele 3 controllere*/
        AlbumsController album = new AlbumsController();
        ArtistController artist = new ArtistController();
        ChartsController chart = new ChartsController();

        Artist artist1 = new Artist();
        Artist artist2 = new Artist();
        Artist artist3 = new Artist();

        //3 artisti generati random
        artist1.generateRandomArtists();
        artist2.generateRandomArtists();
        artist3.generateRandomArtists();

        Album album1 = new Album();
        Album album2 = new Album();
        Album album3 = new Album();

        //3 albume generate random
        album1.generateRandomAlbum();
        album2.generateRandomAlbum();
        album3.generateRandomAlbum();

        chart.insertAlbum("My top", album1, 1);
        chart.insertAlbum("My top", album2, 2);
        chart.insertAlbum("My top", album3, 3);

        chart.showChart("My top");
    }
}