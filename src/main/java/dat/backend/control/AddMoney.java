package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Order;
import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.CheckString;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.OrderFacade;
import dat.backend.model.persistence.UserFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "addMoney", value = "/addMoney")
public class AddMoney extends HttpServlet {

    private static ConnectionPool connectionPool = ApplicationStart.getConnectionPool();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String item = "user";
        int amount = CheckString.stringToInt(request.getParameter("amount"));
        ArrayList<User> userList = null;

        try {
            UserFacade.addMoneyToAccount(email,amount,connectionPool);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }

        try {
            userList = UserFacade.getAllUsers(connectionPool);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }

        request.setAttribute("userList",userList);
        request.setAttribute("item",item);
        request.getRequestDispatcher("WEB-INF/admin.jsp").forward(request, response);
    }
}

