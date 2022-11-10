package dat.backend.model.persistence;

import dat.backend.model.entities.*;
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

    public static Bottom getBottomFromID(int id, ConnectionPool connectionPool) throws DatabaseException {
        return OrderMapper.getBottomFromID(id,connectionPool);
    }
    public static Topping getToppingFromID(int id, ConnectionPool connectionPool) throws DatabaseException {
        return OrderMapper.getToppingFromID(id,connectionPool);
    }
    public static int getOrderID(ConnectionPool connectionPool) throws DatabaseException {
        return OrderMapper.getOrderID(connectionPool);
    }

    public static void createOrder(Basket basket,int totalPrice, int userid, ConnectionPool connectionPool) {

         OrderMapper.createOrder(basket,totalPrice,userid,connectionPool);
    }
}
