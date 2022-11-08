package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Order;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.OrderFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "seeCupcakes", value = "/seeCupcakes")
public class SeeCupcakes extends HttpServlet {

    private static ConnectionPool connectionPool = ApplicationStart.getConnectionPool();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String item = "order";
        int id = Integer.parseInt(request.getParameter("orderID"));
        ArrayList<Order> orderList = null;
        Order order = null;
        String pressed = "pressed";


        try {
            order = OrderFacade.getOrderFromOrderID(id,connectionPool);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }

        try {
            order.setCupcakeList(OrderFacade.getCupcakeFromOrderID(order.getOrderid(), connectionPool));
        } catch (DatabaseException e) {
            e.printStackTrace();
        }

        try {
            orderList = OrderFacade.getAllOrder(connectionPool);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }

        request.setAttribute("pressed",pressed);
        request.setAttribute("order",order);
        request.setAttribute("orderList", orderList);
        request.setAttribute("item", item);
        request.getRequestDispatcher("WEB-INF/admin.jsp").forward(request, response);
    }
}
