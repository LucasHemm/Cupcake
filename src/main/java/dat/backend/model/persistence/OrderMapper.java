package dat.backend.model.persistence;

import dat.backend.model.entities.Cupcake;
import dat.backend.model.entities.Order;
import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderMapper {


    static ArrayList<Order> getAllOrders(ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");

        ArrayList<Order> orderList = new ArrayList<>();

        String sql = "SELECT * from orders)";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    int orderID = rs.getInt("idorders");
                    int userID = rs.getInt("userid");
                    int totalPrice = rs.getInt("totalPrice");
                    Timestamp timestamp = rs.getTimestamp("time");

                    Order order = new Order(orderID, userID, totalPrice, timestamp);


                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "No users were found");
        }
        return orderList;
    }

    private static ArrayList<Cupcake> getCupcakeFromOrderID(int orderID, ConnectionPool connectionPool)
    {
        ArrayList<Cupcake> cupcakeList = new ArrayList<>();

        return cupcakeList;
    }


}
