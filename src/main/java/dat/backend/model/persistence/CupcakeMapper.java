package dat.backend.model.persistence;

import dat.backend.model.entities.Bottom;
import dat.backend.model.entities.Topping;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CupcakeMapper {

    public static List<Topping> getToppings(ConnectionPool connectionPool) {

        List<Topping> ToppingList = new ArrayList<>();


        String sql = "select * from toppings";

        try (Connection connection = connectionPool.getConnection()) {


            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int toppingid = rs.getInt("idtoppings");
                    String type = rs.getString("type");
                    int price = rs.getInt("price");

                    Topping newTopping = new Topping(toppingid, type, price);
                    ToppingList.add(newTopping);
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ToppingList;
    }

    public static List<Bottom> getBottoms(ConnectionPool connectionPool) {

        List<Bottom> BottomList = new ArrayList<>();


        String sql = "select * from toppings";

        try (Connection connection = connectionPool.getConnection()) {


            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int bottomid = rs.getInt("idbottoms");
                    String type = rs.getString("type");
                    int price = rs.getInt("price");

                    Bottom newBottom = new Bottom(bottomid, type, price);
                    BottomList.add(newBottom);
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return BottomList;
    }
}
