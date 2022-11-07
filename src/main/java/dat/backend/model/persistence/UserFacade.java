package dat.backend.model.persistence;

import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;

import java.util.ArrayList;

public class UserFacade
{
    public static User login(String email, String password, ConnectionPool connectionPool) throws DatabaseException
    {
        return UserMapper.login(email, password, connectionPool);
    }

    public static User createUser(String name, String email, String password, int balance, ConnectionPool connectionPool) throws DatabaseException
    {
        return UserMapper.createUser(name, email, password, balance, connectionPool);
    }

    public static void addMoneyToAccount(int userID, int amount, ConnectionPool connectionPool) throws DatabaseException {
        UserMapper.addMoneyToAccount(userID, amount, connectionPool);
    }

    public static ArrayList<User> getAllUsers(ConnectionPool connectionPool) throws DatabaseException {
        return UserMapper.getAllUsers(connectionPool);
    }
}
