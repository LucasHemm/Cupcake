package dat.backend.model.persistence;

import dat.backend.model.entities.*;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderMapper {


    static ArrayList<Order> getAllOrders(ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");

        ArrayList<Order> orderList = new ArrayList<>();

        String sql = "SELECT * from orders";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    int orderID = rs.getInt("idorders");
                    int userID = rs.getInt("userid");
                    int totalPrice = rs.getInt("totalPrice");
                    Timestamp timestamp = rs.getTimestamp("time");

                    Order order = new Order(orderID, userID, totalPrice, timestamp);
                    order.setCupcakeList(getCupcakeFromOrderID(orderID, connectionPool));
                    orderList.add(order);

                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "No users were found");
        }
        return orderList;
    }

    static ArrayList<Cupcake> getCupcakeFromOrderID(int orderID, ConnectionPool connectionPool) throws DatabaseException {


        Logger.getLogger("web").log(Level.INFO, "");

        ArrayList<Cupcake> cupcakeList = new ArrayList<>();

        String sql = "SELECT * from cupcake where orderid=?";


        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, orderID);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    Topping topping = getToppingFromID(rs.getInt("toppingid"), connectionPool);
                    Bottom bottom = getBottomFromID(rs.getInt("bottomid"), connectionPool);
                    int price = rs.getInt("price");
                    int amount = rs.getInt("amount");
                    Cupcake cupcake = new Cupcake(topping, bottom, price, orderID, amount);
                    cupcakeList.add(cupcake);
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "No users were found");
        }

        return cupcakeList;
    }

    static Topping getToppingFromID(int id, ConnectionPool connectionPool) throws DatabaseException {

        Logger.getLogger("web").log(Level.INFO, "");
        String sql = "SELECT * from toppings where idtoppings=?";
        Topping topping = null;


        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {

                    String type = rs.getString("type");
                    int price = rs.getInt("price");
                    topping = new Topping(id, type, price);

                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "No users were found");
        }
        return topping;
    }

    static Bottom getBottomFromID(int id, ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        Bottom bottom = null;

        String sql = "SELECT * from bottoms where idbottoms=?";
        Topping topping = null;


        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {

                    String type = rs.getString("type");
                    int price = rs.getInt("price");
                    bottom = new Bottom(id, type, price);
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "No users were found");
        }
        return bottom;
    }

    static void deleteOrderFromID(int id, ConnectionPool connectionPool) {

        deleteCupcakesFromOrderID(id, connectionPool);

        String sql = "delete from orders where idorders = ?";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, id);
                ps.executeUpdate();
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    static ArrayList<Order> getOrdersFromEmail(String email, ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");

        int userID = getUserIDFromEmail(email, connectionPool);
        ArrayList<Order> orderList = new ArrayList<>();

        String sql = "SELECT * from orders where userid=?";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, userID);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    int orderID = rs.getInt("idorders");
                    int totalPrice = rs.getInt("totalPrice");
                    Timestamp timestamp = rs.getTimestamp("time");
                    Order order = new Order(orderID, userID, totalPrice, timestamp);
                    order.setCupcakeList(getCupcakeFromOrderID(orderID, connectionPool));
                    orderList.add(order);
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "No users were found");
        }
        return orderList;
    }

    static int getUserIDFromEmail(String email, ConnectionPool connectionPool) throws DatabaseException {
        int ID = 0;

        String sql = "SELECT * from user where email=?";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, email);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    ID = rs.getInt("iduser");
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "No users were found");
        }
        return ID;
    }

    private static void deleteCupcakesFromOrderID(int id, ConnectionPool connectionPool) {
        String sql = "delete from cupcake where orderid = ?";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, id);
                ps.executeUpdate();
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static Order getOrdersFromOrderID(int userID, ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        Order order = null;

        String sql = "SELECT * from orders where userid=?";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, userID);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    int orderID = rs.getInt("idorders");
                    int totalPrice = rs.getInt("totalPrice");
                    Timestamp timestamp = rs.getTimestamp("time");
                    order = new Order(orderID, userID, totalPrice, timestamp);
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "No users were found");
        }
        return order;
    }


    public static int getOrderID(ConnectionPool connectionPool) throws DatabaseException {
        int orderID = 1;

        String sql = "SELECT * from orders";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    orderID++;
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "No users were found");
        }
        return orderID;

    }

    public static void createOrder(Basket basket, int totalPrice, int userid, ConnectionPool connectionPool) {

        int orderid = 0;

        System.out.println("USER ID IS: " + userid);
        String sql = "INSERT INTO orders (userid, totalPrice) VALUES (?, ?)";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, userid);
                ps.setInt(2, totalPrice);
                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                rs.next();
                orderid = rs.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        createCupcake(orderid, basket, connectionPool);

    }

    private static void createCupcake(int orderid, Basket basket, ConnectionPool connectionPool) {

        String sql = "INSERT INTO cupcake (toppingid,bottomid,price,orderid,amount) VALUES (?,?,?,?,?)";

        for (Cupcake c : basket.getCupcakeArrayList()) {
            try (Connection connection = connectionPool.getConnection()) {
                try (PreparedStatement ps = connection.prepareStatement(sql)) {
                    ps.setInt(1, c.getTopping().getToppingid());
                    ps.setInt(2, c.getBottom().getBottomid());
                    ps.setInt(3, c.calcPrice());
                    ps.setInt(4, orderid);
                    ps.setInt(5, c.getAmount());
                    ps.executeUpdate();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }


}
