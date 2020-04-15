package com.company;

import java.sql.*;

public class ArtistController {
    public void create(String artistName, String artistCountry) throws SQLException {
        Connection con = DataBase.getConnection();
        try (PreparedStatement statement = con.prepareStatement("insert into artists (name, country) values (?, ?)")) {
            statement.setString(1, artistName);
            statement.setString(2, artistCountry);
            statement.executeUpdate();
            DataBase.commit();
        }
    }


    public Integer findByName(String artistName) throws SQLException {
        Connection con = DataBase.getConnection();
        try (Statement statemet = con.createStatement()) {
            ResultSet querry = statemet.executeQuery("select id from artists where name='" + artistName + "'");
            Integer id = querry.next() ? querry.getInt(1) : null;
            querry.close();
            return id;
        }
    }
}