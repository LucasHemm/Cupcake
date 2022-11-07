package dat.backend.model.persistence;

import dat.backend.model.entities.Bottom;
import dat.backend.model.entities.Topping;
import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;

import java.util.List;

public class CupcakeFacade {

    public static List<Topping> getbottoms(ConnectionPool connectionPool){


        return CupcakeMapper.getItems(username,connectionPool);
    }
    public static List<Bottom> gettoppings(ConnectionPool connectionPool){


        return CupcakeMapper.getItems(username,connectionPool);
    }

}
