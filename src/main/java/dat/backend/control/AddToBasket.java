package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.*;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.CheckString;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.OrderFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "addToBasket", value = "/addToBasket")
public class AddToBasket extends HttpServlet {

    private static ConnectionPool connectionPool = ApplicationStart.getConnectionPool();

    private static int cupcakeId = 0;

    static public int getCupcakeId() {
        return cupcakeId;
    }

    public static void setCupcakeId(int id) {
        cupcakeId = id;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


//        int toppingId = Integer.parseInt(request.getParameter("topping"));
//        int bottomId = Integer.parseInt(request.getParameter("bottom"));
//        int amount = Integer.parseInt(request.getParameter("amount"));

        int toppingId = CheckString.stringToInt(request.getParameter("topping"));
        int bottomId = CheckString.stringToInt(request.getParameter("bottom"));
        int amount = CheckString.stringToInt(request.getParameter("amount"));

        Topping topping = null;
        Bottom bottom = null;
        try {
            topping = OrderFacade.getToppingFromID(toppingId,connectionPool);
            bottom = OrderFacade.getBottomFromID(bottomId,connectionPool);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }
        Cupcake cupcake = new Cupcake(topping,bottom,(topping.getPrice()+bottom.getPrice())*amount,amount);
        HttpSession session = request.getSession();

        cupcake.setCupcakeId(cupcakeId);

        Basket basket = (Basket) session.getAttribute("basket");
        basket.addToBasket(cupcake);
        cupcakeId++;
        String msg = "Bestillingen er blevet tilføjet til indkøbskurven";
        request.setAttribute("msg",msg);
        request.getRequestDispatcher("WEB-INF/welcome.jsp").forward(request, response);



    }
}
