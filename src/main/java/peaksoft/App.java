package peaksoft;

import peaksoft.dao.UserDaoJdbcImpl;
import peaksoft.util1.Database;

import java.sql.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        UserDaoJdbcImpl userDaoJdbc = new UserDaoJdbcImpl();
//        userDaoJdbc.createUsersTable();
//        userDaoJdbc.dropUsersTable();
//        userDaoJdbc.saveUser(1, "Arlen", "Kurbanbaev", (byte)20);
//        userDaoJdbc.addUser(2, "Sultan", "Bakirov", 41);
//        userDaoJdbc.removeUserById(1);
        userDaoJdbc.getAllUsers();
//        userDaoJdbc.cleanUsersTable();
//        userDaoJdbc.existsByFirstName("Sultan");

//        userDaoJdbc.dropUsersTable();
//        Database database = new Database();
//        database.connection();
//        System.out.println(getUserCount());
//        addUser(5, "Tynych", 12);
//        System.out.println(getUserCount());
//        printUsers();
    }

    public static void printUsers() {
        String sql = "SELECT * FROM users";
        try (Connection conn = Database.connection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " "
                        + rs.getString("name") + " "
                        + rs.getInt("age"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static int getUserCount() {
        String sql = "select count(*) from users";
        int count = 0;
        try (Connection connect = Database.connection();
             Statement stmt = connect.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            rs.next();
            count = rs.getInt(1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return count;
    }
}
