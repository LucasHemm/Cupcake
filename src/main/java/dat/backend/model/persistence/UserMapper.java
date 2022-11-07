package dat.backend.model.persistence;

import dat.backend.model.entities.Order;
import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

class UserMapper {
    static User login(String email, String password, ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");

        User user = null;

        String sql = "SELECT * FROM user WHERE email = ? AND password = ?";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, email);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    int balance = rs.getInt("balance");
                    String name = rs.getString("name");
                    boolean isAdmin = rs.getBoolean("isAdmin");
                    user = new User(name, email, password, isAdmin, balance);
                } else {
                    throw new DatabaseException("Wrong username or password");
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Error logging in. Something went wrong with the database");
        }
        return user;
    }

    static User createUser(String name, String email, String password, int balance, ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        User user;
        String sql = "insert into user (name,email,password,balance) values (?,?,?,?)";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, name);
                ps.setString(2, email);
                ps.setString(3, password);
                ps.setInt(4, balance);
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1) {
                    user = new User(name, email, password, false, balance);
                } else {
                    throw new DatabaseException("The user with name = " + name + " could not be inserted into the database");
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Could not insert user into database");
        }
        return user;
    }

    static ArrayList<User> getAllUsers(ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");

        ArrayList<User> userList = new ArrayList<>();

        String sql = "SELECT * from user)";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {

                    String name = rs.getString("name");
                    String email = rs.getString("email");
                    String password = rs.getString("password");
                    int balance = rs.getInt("balance");
                    boolean isAdmin = rs.getBoolean("isAdmin");
                    if(!isAdmin) {
                        User user = new User(name, email, password, isAdmin, balance);
                        userList.add(user);
                    }
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "No users were found");
        }
        return userList;
    }

    static void addMoneyToAccount(int userID, int amount, ConnectionPool connectionPool) throws DatabaseException {

        Logger.getLogger("web").log(Level.INFO, "");

        User user = getUserFromId(userID,connectionPool);

        String sql = "insert into user (balance) values (?) where iduser=?";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setInt(1, user.getBalance() + amount);
                ps.setInt(2, userID);
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Could not add money into database");
        }
    }


    private static User getUserFromId(int ID, ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");

        User user = null;

        String sql = "SELECT * FROM user WHERE iduser=?";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, ID);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {

                    String name = rs.getString("name");
                    String email = rs.getString("email");
                    String password = rs.getString("password");
                    int balance = rs.getInt("balance");
                    boolean isAdmin = rs.getBoolean("isAdmin");
                    user = new User(name, email, password, isAdmin, balance);

                } else {
                    throw new DatabaseException("Wrong userid");
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Error logging in. Something went wrong with the database");
        }
        return user;
    }
}
