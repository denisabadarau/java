package com.company;

import java.sql.*;
/*optiunea de a insera un album in baza de date*/
public class AlbumsController {
    private int idAlbum=0;
    Connection con = DataBase.getConnection();
    PreparedStatement statement;
    String sql;

    public int getIdAlbum() {
        return idAlbum;
    }

    public void increaseIdAlbum()
    {
        this.idAlbum++;
    }
    public void insertAlbum(Album album)
    {
        try {
            statement = (PreparedStatement) con.createStatement();
            sql = "INSERT INTO albums(id,name,artist_id,release_year) values(" + album.getIdAlbum() + "," + album.getNameAlbum() + "," + album.getIdArtist() +"," + album.getReleaseYear() +")";
            statement.executeUpdate(sql);
            statement.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }
}