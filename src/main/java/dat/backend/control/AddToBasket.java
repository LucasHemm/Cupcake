package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.*;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.OrderFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "addToBasket", value = "/addToBasket")
public class AddToBasket extends HttpServlet {

    private static ConnectionPool connectionPool = ApplicationStart.getConnectionPool();



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        int toppingId = Integer.parseInt(request.getParameter("topping"));
        int bottomId = Integer.parseInt(request.getParameter("bottom"));
        int amount = Integer.parseInt(request.getParameter("amount"));
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

        Basket basket = (Basket) session.getAttribute("basket");
        basket.addToBasket(cupcake);
        request.getRequestDispatcher("WEB-INF/welcome.jsp").forward(request, response);



    }
}
