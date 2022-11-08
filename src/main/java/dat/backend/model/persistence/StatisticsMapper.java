package dat.backend.model.persistence;

import dat.backend.model.entities.Order;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.*;

public class StatisticsMapper {

    //Bottom counters
   private static int chocoBot = 0;
   private static int vanillaBot = 0;
   private static int nutmegBot = 0;
   private static int pistachioBot = 0;
   private static int AlmondBot = 0;

    //Topping counters
   private static int chocoTop = 0;
   private static int blueberryTop = 0;
   private static int raspberryTop = 0;
   private static int crispyTop = 0;
   private static int strawberryTop = 0;
   private static int rumTop = 0;
   private static int orangeTop = 0;
   private static int LemonTop = 0;
   private static int cheeseTop = 0;





    private static void count(ConnectionPool connectionPool) throws DatabaseException {

        String sql = "SELECT * from cupcake";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    int topppingID = rs.getInt("toppingid");
                    int bottomID = rs.getInt("bottomid");
                    switch (topppingID)
                    {
                        case 1: chocoTop++;
                            break;
                        case 2: blueberryTop++;
                            break;
                        case 3: raspberryTop++;
                            break;
                        case 4: crispyTop++;
                            break;
                        case 5: strawberryTop++;
                            break;
                        case 6: rumTop++;
                            break;
                        case 7: orangeTop++;
                            break;
                        case 8: LemonTop++;
                            break;
                        case 9: cheeseTop++;
                            break;

                    }

                    switch (bottomID)
                    {
                        case 1: chocoBot++;
                            break;
                        case 2: vanillaBot++;
                            break;
                        case 3: nutmegBot++;
                            break;
                        case 4: pistachioBot++;
                            break;
                        case 5: AlmondBot++;
                            break;

                    }

                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "No cupcake were found");
        }
    }
}
