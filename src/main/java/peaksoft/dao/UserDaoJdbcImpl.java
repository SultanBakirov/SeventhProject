package peaksoft.dao;

import peaksoft.model.User;
import peaksoft.util.Util;
import peaksoft.util1.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJdbcImpl implements UserDao{

    @Override
    public void createUsersTable() {
        String sql = "CREATE TABLE users(" +
                "id BIGINT PRIMARY KEY, " +
                "name VARCHAR(250), " +
                "lastname VARCHAR(250), " +
                "age INTEGER )";
        try (Connection connect = Util.connection();
            Statement statement = connect.createStatement()) {
            statement.executeUpdate(sql);
            System.out.println("Table successfully created...");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void dropUsersTable() {
        String sql = "DROP TABLE users";
        try (Connection connect = Util.connection();
             Statement statement = connect.createStatement()) {
            statement.executeUpdate(sql);
            System.out.println("Table dropped successfully...");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void saveUser(long id, String name, String lastName, byte age) {
        String sql = "INSERT INTO users(id, name, lastName, age) VALUES (?, ?, ?, ?)";
                try (Connection connect = Util.connection();
                     PreparedStatement preparedStatement = connect.prepareStatement(sql)) {
                    preparedStatement.setInt(1, (int)id);
                    preparedStatement.setString(2, name);
                    preparedStatement.setString(3, lastName);
                    preparedStatement.setInt(4, age);
                    preparedStatement.executeUpdate();
                    System.out.println("Table saved successfully...");
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
    }

    public void addUser(int id, String name, String lastName, int age) {
        String sql = "insert into users (id, name,lastName, age) values (?, ?, ?, ?)";
        try (Connection connect = Util.connection();
             PreparedStatement preparedStatement = connect.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, lastName);
            preparedStatement.setInt(4, age);
            preparedStatement.executeUpdate();
            System.out.println("Successfully added " + name + "!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void removeUserById(long id) {
        String sql = "DELETE FROM users WHERE (id = ?)";
        try (Connection connect = Util.connection();
            PreparedStatement preparedStatement = connect.prepareStatement(sql)) {
            preparedStatement.setInt(1, (int) id);
            preparedStatement.executeUpdate();
            System.out.println("Users removed successfully by id = " + id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public List<User> getAllUsers() {
        String sql = "SELECT * FROM users";
        ArrayList<User> allStudents = new ArrayList<>();
        try (Connection connect = Util.connection();
             Statement statement = connect.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                User user = new User();
                System.out.println(resultSet.getLong(1));
                System.out.println(resultSet.getString(2));
                System.out.println(resultSet.getString(3));
                System.out.println(resultSet.getByte(4));
                allStudents.add(user);
                System.out.println(getAllUsers());
            }
            System.out.println("All users...");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return allStudents;
    }

    @Override
    public void cleanUsersTable() {
        String sql = "TRUNCATE TABLE users";
        try (Connection connect = Util.connection();
            Statement statement = connect.createStatement()) {
            statement.executeUpdate(sql);
            System.out.println("The table cleaned success...");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public boolean existsByFirstName(String firstName) {
        String sql = "SELECT name FROM users WHERE (name = ?)";
        try (Connection connect = Util.connection();
            PreparedStatement preparedStatement = connect.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery(sql)){
            User user = new User();
            preparedStatement.setString(2, firstName);
            preparedStatement.executeUpdate();
            System.out.println("Success...");
            if (firstName.equals(user.getName(resultSet.getString(2)))) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
