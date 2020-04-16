package com.company;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/*clasa singleton care se ocupa cu conexiunea*/
public class DataBase {

    private static final String URL = "jdbc:oracle:thin:@localhost:1521/XE";
    private static final String USER = "dbapa"; //nu am putut sa fac cu dba ptc e rezervat
    private static final String PASSWORD = "sql";
    private static Connection connection = null;

    private DataBase() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your Oracle JDBC Driver?");
            e.printStackTrace();
            return;
        }
    }
    public static Connection getConnection() {
        if (connection == null) {
            try{
                createConnection();
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
    //Implement the method createConnection()
    static void createConnection() throws SQLException {
        connection = DriverManager.getConnection(URL, USER, PASSWORD);

    }
    //Implement the method closeConnection()
    static void closeConnection() throws SQLException {
        if(connection!=null)
            connection.close();
    }

}
