package com.company;

import java.sql.*;

public class AlbumsController {
    public void create(String albumName, int artistID, int releaseYear) throws SQLException {
        Connection con = DataBase.getConnection();
        try (PreparedStatement statement = con.prepareStatement("insert into albums (name, artist_id, release_year) values (?, ?, ?)")) {
            statement.setString(1, albumName);
            statement.setInt(2, artistID);
            statement.setInt(3, releaseYear);
            statement.executeUpdate();
            DataBase.commit();
        }
    }
    public Integer findByArtist(int artistID) throws SQLException {
        Connection con = DataBase.getConnection();
        try (Statement statement = con.createStatement()) {
            ResultSet querry = statement.executeQuery("select id from albums where artist_id=" + artistID);
            Integer id = querry.next() ? querry.getInt(1) : null;
            querry.close();
            return id;
        }
    }
}