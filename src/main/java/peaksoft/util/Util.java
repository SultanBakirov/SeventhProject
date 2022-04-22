package peaksoft.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String url = "jdbc:postgresql://localhost:5432/seventhproject";
    private static final String username = "postgres";
    private static final String password = "nurislam";

    public static Connection connection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the PostgresSql successfully...");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }
}
