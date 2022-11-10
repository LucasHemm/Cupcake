package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Basket;
import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.OrderFacade;
import dat.backend.model.persistence.UserFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "pay", value = "/pay")
public class Pay extends HttpServlet {


    private static ConnectionPool connectionPool = ApplicationStart.getConnectionPool();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        Basket basket = (Basket) session.getAttribute("basket");
        int totalPrice = basket.calcTotalprice();
        User user = (User) session.getAttribute("user");
        int userid = 0;
        try {
            userid = UserFacade.getUserIdFromEmail(user.getEmail(), connectionPool);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }

        try {
            if(UserFacade.payment(totalPrice,user,connectionPool)) {
                OrderFacade.createOrder(basket, totalPrice, userid, connectionPool);
                basket.newBasket();
                session.setAttribute("basket",basket);
                AddToBasket.setCupcakeId(0);
                request.getRequestDispatcher("WEB-INF/welcome.jsp").forward(request, response);
            }
        } catch (DatabaseException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("WEB-INF/basket.jsp").forward(request, response);

    }
}
