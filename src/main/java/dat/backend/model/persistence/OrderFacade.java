package dat.backend.model.persistence;

import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;

public class OrderFacade {
    public static User login(String email, String password, ConnectionPool connectionPool) throws DatabaseException
    {
        return UserMapper.login(email, password, connectionPool);
    }

    public static User createUser(String name, String email, String password, int balance, ConnectionPool connectionPool) throws DatabaseException
    {
        return UserMapper.createUser(name, email, password, balance, connectionPool);
    }
}
