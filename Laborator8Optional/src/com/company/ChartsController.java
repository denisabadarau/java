package com.company;

import java.sql.*;
/* Controllerul chartului in care implementez functiile de  inserare a unui album, vizualizarea datelor unui chart*/
public class ChartsController {

    Connection con = DataBase.getConnection();
    PreparedStatement statement;
    String sql;

    public void insertAlbum(String chartName, Album album, int rank) {
        try {
            statement = (PreparedStatement) con.createStatement();
            sql = "INSERT INTO charts(chart_name, album_name, rank) VALUES(" + "'" + chartName + "', "  + album.getNameAlbum() + "," + rank + ")";
            statement.executeUpdate(sql);
            statement.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }

    public void showChart(String chartName) {
        try {
            statement = (PreparedStatement) con.createStatement();
            sql = "SELECT * FROM charts where chart_name = " + "'" + chartName + "'" + " order by rank";
            ResultSet querry = statement.executeQuery(sql);
            while (querry.next()) {
                String albumName = querry.getString("album_name");
                int rank = querry.getInt("rank");
                System.out.println("Album Name: " + albumName);
                System.out.println("Rank: " + rank);

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }

}
