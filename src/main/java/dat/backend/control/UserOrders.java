package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Order;
import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.OrderFacade;
import dat.backend.model.persistence.OrderMapper;
import dat.backend.model.persistence.UserFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "userOrders", value = "/userOrders")
public class UserOrders extends HttpServlet {
    private static ConnectionPool connectionPool = ApplicationStart.getConnectionPool();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String item = "userOrder";
        String email = request.getParameter("email");
        ArrayList<Order> orderList = null;


        try {
            orderList = OrderFacade.getOrdersFromEmail(email,connectionPool);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }

        request.setAttribute("orderList",orderList);
        request.setAttribute("item",item);
        request.getRequestDispatcher("WEB-INF/admin.jsp").forward(request,response);
    }
}
