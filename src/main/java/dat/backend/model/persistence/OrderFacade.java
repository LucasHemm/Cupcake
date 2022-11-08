package dat.backend.model.persistence;

import dat.backend.model.entities.Cupcake;
import dat.backend.model.entities.Order;
import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;

import java.util.ArrayList;

public class OrderFacade {
    public static void deleteOrderFromID(int id, ConnectionPool connectionPool) {
        OrderMapper.deleteOrderFromID(id, connectionPool);
    }

    public static ArrayList<Order> getAllOrder(ConnectionPool connectionPool) throws DatabaseException {
        return OrderMapper.getAllOrders(connectionPool);
    }

    public static ArrayList<Order> getOrdersFromEmail(String email, ConnectionPool connectionPool) throws DatabaseException {
        return OrderMapper.getOrdersFromEmail(email, connectionPool);
    }

    public static ArrayList<Cupcake> getCupcakeFromOrderID(int orderID, ConnectionPool connectionPool) throws DatabaseException {
        return OrderMapper.getCupcakeFromOrderID(orderID,connectionPool);
    }

    public static Order getOrderFromOrderID(int id, ConnectionPool connectionPool) throws DatabaseException {
        return OrderMapper.getOrdersFromOrderID(id, connectionPool);
    }
}
