package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Basket;
import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.CupcakeFacade;
import dat.backend.model.persistence.UserFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "createUser", value = "/createUser")
public class CreateUser extends HttpServlet {

    private static ConnectionPool connectionPool = ApplicationStart.getConnectionPool();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        request.getRequestDispatcher("WEB-INF/createUser.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        session.setAttribute("user", null); // invalidating user object in session scope
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        int balance = Integer.parseInt(request.getParameter("balance"));
        String role = request.getParameter("role");
        session.setAttribute("bottomList", CupcakeFacade.getbottoms(connectionPool));
        session.setAttribute("toppingList", CupcakeFacade.gettoppings(connectionPool));
        Basket basket = new Basket();
        session.setAttribute("basket",basket);


        try {
            User user = UserFacade.createUser(name,email, password,balance, connectionPool);
            session = request.getSession();
            session.setAttribute("user", user); // adding user object to session scope
            request.getRequestDispatcher("WEB-INF/welcome.jsp").forward(request, response);
        } catch (DatabaseException e) {
            String msg = "En bruger med den email eksisterer allerede";
            request.setAttribute("msg",msg);
            request.getRequestDispatcher("WEB-INF/createUser.jsp").forward(request, response);
        }

    }
}
