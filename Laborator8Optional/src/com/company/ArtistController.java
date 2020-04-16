package com.company;

import java.sql.*;
/*optiunea de a adauga un artist in baza de date*/
public class ArtistController {
    private int idArtist=0;
    Connection con = DataBase.getConnection();
    PreparedStatement statement;
    String sql;

    public int getIdArtist() {
        return idArtist;
    }

    public void increaseIdArtist()
    {
        this.idArtist++;
    }

    public void insertArtist(Artist artist)
    {
        try {
            statement = (PreparedStatement) con.createStatement();
            sql = "INSERT INTO artists(id,name,country) values(" + artist.getIdArtist() + "," + artist.getNameArtist() + "," + artist.getCountry() + ")";
            statement.executeUpdate(sql);
            statement.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }
}