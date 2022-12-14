package dat.backend.model.persistence;

import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;

import java.util.ArrayList;

public class UserFacade {
    public static User login(String email, String password, ConnectionPool connectionPool) throws DatabaseException {
        return UserMapper.login(email, password, connectionPool);
    }

    public static User createUser(String name, String email, String password, int balance, ConnectionPool connectionPool) throws DatabaseException {
        return UserMapper.createUser(name, email, password, balance, connectionPool);
    }

    public static void addMoneyToAccount(String email, int amount, ConnectionPool connectionPool) throws DatabaseException {
        UserMapper.addMoneyToAccount(email, amount, connectionPool);
    }

    public static ArrayList<User> getAllUsers(ConnectionPool connectionPool) throws DatabaseException {
        return UserMapper.getAllUsers(connectionPool);
    }

    public static User getUserFromId(int id, ConnectionPool connectionPool) {
        return getUserFromId(id, connectionPool);
    }

    public static int getUserIdFromEmail(String email, ConnectionPool connectionPool) throws DatabaseException {
        return OrderMapper.getUserIDFromEmail(email, connectionPool);
    }

    public static boolean payment(int totalPrice, User user,ConnectionPool connectionPool) throws DatabaseException {
        return UserMapper.payment(totalPrice,user,connectionPool);
    }

}
